package com.example.eurekaconsumer.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotEmpty;

@Data
@EqualsAndHashCode
public class UsersLoginParam {
    @NotEmpty
    private String username;
    @NotEmpty
    private String password;
}
