package com.jo.registroclientes.exception;

import com.jo.registroclientes.model.dtos.ResponseEntityDTO;
import com.jo.registroclientes.model.entity.Producto;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
public class ExceptionHandler {
   @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseEntityDTO<String>>   handleValidationExceptions(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        StringBuilder errorMessage = new StringBuilder();
        Map<String,String>errorMap= new HashMap<>();
        fieldErrors.stream().forEach(err-> errorMap.put(err.getField(),err.getDefaultMessage()));
        return new ResponseEntity<ResponseEntityDTO<String>>(new ResponseEntityDTO<String>(null,errorMap.toString(),""),HttpStatus.BAD_REQUEST);
    }
}
