package com.jo.registroclientes.model.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseEntityDTO <T>{
    T data;
    String error;
    String menssage;
}
