package com.system.pojo;

import lombok.Data;

@Data
public class SystemUser {

    private Long id;
    private String username;
    private String password;
    private Integer flag;
}
