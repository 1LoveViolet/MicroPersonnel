package com.group.microPersonnel.aop;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一日志处理切面
 */
@Aspect
@Component
//@Order(1)
@Slf4j   //为类提供一个属性名为log的日志对象
public class WebLogAspect {

    //定义切点表达式,指定通知功能被应用的范围
    @Pointcut("execution(public * com.group.microPersonnel.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {

    }

    /**value切入点位置
     * returning 自定义的变量，标识目标方法的返回值,自定义变量名必须和通知方法的形参一样
     * 特点：在目标方法之后执行的,能够获取到目标方法的返回值，可以根据这个返回值做不同的处理
     */
    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) throws Throwable {
    }

    //通知包裹了目标方法，在目标方法调用之前和之后执行自定义的行为
    //ProceedingJoinPoint切入点可以获取切入点方法上的名字、参数、注解和对象
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable
    {
        long startTime = System.currentTimeMillis();
        //获取当前请求对象
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //用于记录请求信息
        WebLog webLog = new WebLog();
        System.out.println("日志信息:------");
        //前面是环绕前通知

        // 调用原始操作
        Object result = joinPoint.proceed();
        //后面是环绕后通知

        //获取连接点的方法签名
        Signature signature = joinPoint.getSignature();
        //获取连接点的方法签名，并转型为MethodSignature
        MethodSignature methodSignature = (MethodSignature) signature;
        //获取连接点的方法
        Method method = methodSignature.getMethod();
        //记录方法结束时间
        long endTime = System.currentTimeMillis();
        //获取请求URL
        String urlStr = request.getRequestURL().toString();
        //设置WebLog的basePath
        webLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
        //设置WebLog的IP地址
        webLog.setIp(request.getRemoteUser());
        //设置WebLog的请求方法
        webLog.setMethod(request.getMethod());
        //设置WebLog的请求参数
        webLog.setParameter(getParameter(method, joinPoint.getArgs()));
        //设置WebLog的请求结果
        webLog.setResult(result);
        //设置WebLog的请求耗时
        webLog.setSpendTime((int) (endTime - startTime));
        //设置WebLog的请求开始时间
        webLog.setStartTime(startTime);
        //设置WebLog的请求URI
        webLog.setUri(request.getRequestURI());
        //设置WebLog的请求URL
        webLog.setUrl(request.getRequestURL().toString());
        //将WebLog对象转换成JSON字符串并输出日志信息
        log.info("{}", JSONUtil.parse(webLog));
        //返回原始操作的返回值
        return result;
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args)
    {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            }
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }
}
