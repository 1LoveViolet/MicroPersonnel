import axios from "./axios";
//地址管理
export function addAddress(data) {
  return axios({
    url: "/address/insert",
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      "Access-Control-Allow-Origin": "*",
    },
    data: data,
  });
}

export function getAddress() {
  return axios({
    url: `/address/get/${id}`,
    method: "get",
  });
}
