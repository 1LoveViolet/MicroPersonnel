package com.group.microPersonnel.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.group.microPersonnel.common.vo.Result;
import com.group.microPersonnel.domain.User;
import com.group.microPersonnel.service.UserService;
import com.group.microPersonnel.util.SMSUtils;
import com.group.microPersonnel.util.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<User> login(HttpServletRequest request, @RequestBody User user){

        //1、将页面提交的密码password进行md5加密处理
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(password);

        //2、根据页面提交的用户名username查询数据库
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,user.getUsername());
        User user1 = userService.getOne(queryWrapper);

        //3、如果没有查询到则返回登录失败结果
        if(user1 == null){
            return Result.failed("登录失败");
        }

        //4、密码比对，如果不一致则返回登录失败结果
        if(!user1.getPassword().equals(password)){
            return Result.failed("登录失败");
        }

        //5、登录成功，将员工id存入Session并返回登录成功结果
        request.getSession().setAttribute("userid",user1.getId());

        return Result.ok(user1);
    }

    /**
     * 员工退出
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout(HttpServletRequest request){
        //清理Session中保存的当前登录员工的id
        request.getSession().removeAttribute("userid");
        return Result.ok("退出成功");
    }

    /**
     * 新增员工
     * @param
     * @return
     * 格式
     * {
     *     "id":51,
     *     "username":"xiaohei",
     *     "password":"123456" ,
     *     "phone":"18581713927",
     *     "code":"手机上收到的四位数验证码"
     * }
     */
    @PostMapping("/register")
    public Result<User> save(@RequestBody Map map,HttpSession session) {
        log.info("新增用户，用户信息：{}", map.toString());
        log.info(map.toString());

        //获取手机号
        String phone = map.get("phone").toString();
        String username = map.get("username").toString();

        //获取验证码
        String code = map.get("code").toString();

        //从Session中获取保存的验证码
        Object codeInSession = session.getAttribute(phone);
        log.info(codeInSession.toString());


        //进行验证码的比对（页面提交的验证码和Session中保存的验证码比对）
        if (codeInSession != null && codeInSession.equals(code)) {
            //如果能够比对成功，说明登录成功
//            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//            queryWrapper.eq(User::getPhone,phone);
//            User user = userService.getOne(queryWrapper);
//            if(user == null){
//                //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
//                user = new User();
//                user.setPhone(phone);
//                userService.save(user);
//
//            }

            User user = new User();
            user.setPhone(phone);
            user.setUsername(username);

            //获取密码，需要进行md5加密处理
            user.setPassword(DigestUtils.md5DigestAsHex(map.get("password").toString().getBytes()));
            userService.save(user);

            return Result.ok(user);
        }
        return Result.failed("注册失败");
    }

//    /**
//     * 根据id修改员工信息
//     * @param user
//     * @return
//     */
//    @PutMapping("/update")
//    public Result<String> update(HttpServletRequest request,@RequestBody User user){
//        log.info(user.toString());
//        long id = Thread.currentThread().getId();
//        log.info("线程id为：{}",id);
//        Long empId = (Long)request.getSession().getAttribute("userid");
//        //employee.setUpdateTime(LocalDateTime.now());
//        //employee.setUpdateUser(empId);
//        userService.updateById(user);
//
//        return Result.ok("员工信息修改成功");
//    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
//    @GetMapping("/{id}")
//    public R<Employee> getById(@PathVariable Long id){
//        log.info("根据id查询员工信息...");
//        Employee employee = employeeService.getById(id);
//        if(employee != null){
//            return R.success(employee);
//        }
//        return R.error("没有查询到对应员工信息");
//    }


    /**
     * 发送手机短信验证码
     * @param user
     * @return
     * 格式
     * {
     *
     *     "username":"xiaohei",
     *     "password":"123456" ,
     *     "phone":"18581713927",
     *
     * }
     */

    @PostMapping("/sendMsg")
    public Result<String> sendMsg(@RequestBody User user, HttpSession session){
        //获取手机号
        String phone = user.getPhone();

        if(StringUtils.isNotEmpty(phone)){
            //生成随机的4位验证码
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
            log.info("code={}",code);

            //调用阿里云提供的短信服务API完成发送短信
            SMSUtils.sendMessage("微人事","SMS_461360108",phone,code);

            //需要将生成的验证码保存到Session
            session.setAttribute(phone,code);

            return Result.ok("手机验证码短信发送成功");
        }

        return Result.failed("短信发送失败");
    }

    /**
     * 移动端用户登录
     * @param map
     * @param session
     * @return
     */
//    @PostMapping("/login")
//    public Result<User> login(@RequestBody Map map, HttpSession session){
//        log.info(map.toString());
//
//        //获取手机号
//        String phone = map.get("phone").toString();
//
//        //获取验证码
//        String code = map.get("code").toString();
//
//        //从Session中获取保存的验证码
//        Object codeInSession = session.getAttribute(phone);
//
//        //进行验证码的比对（页面提交的验证码和Session中保存的验证码比对）
//        if(codeInSession != null && codeInSession.equals(code)){
//            //如果能够比对成功，说明登录成功
//
//            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//            queryWrapper.eq(User::getPhone,phone);
//
//            User user = userService.getOne(queryWrapper);
//            if(user == null){
//                //判断当前手机号对应的用户是否为新用户，如果是新用户就自动完成注册
//                user = new User();
//                user.setPhone(phone);
//                userService.save(user);
//            }
//            session.setAttribute("user",user.getId());
//            return Result.ok(user);
//        }
//        return Result.failed("登录失败");
//    }
}
