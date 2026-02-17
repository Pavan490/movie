package com.software.movie_service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(Exception e){
        Map<String,Object> map = new HashMap<>();
        map.put("result","Failed");
        map.put("message",e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodExceptionHandler(MethodArgumentNotValidException exception){
        Map<String,Object> map = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach((e)->{
            map.put(e.getField(),e.getDefaultMessage()) ; });
        Map<String,Object> res = new HashMap<>();
            res.put("result","Failed");
            res.put("errors",map);
     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(res);
    }
}
