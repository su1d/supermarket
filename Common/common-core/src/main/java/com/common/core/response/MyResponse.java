package com.common.core.response;

import com.alibaba.nacos.api.remote.response.Response;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class MyResponse {

    //状态码
    private Integer code;
    //返回消息
    private String message;

    private HttpHeaders headers;

    private ResponseEntity response;

    public MyResponse(Integer code, String message ,HttpHeaders headers) {
        this.code = code;
        this.message = message;
        this.headers = headers;
        if(code == 200){
            response=new ResponseEntity(message, headers, HttpStatus.OK);
        }else {
            response=new ResponseEntity(message, headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public MyResponse(){
    }
}
