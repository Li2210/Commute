package com.elec5620.commute.Utils;

import com.elec5620.commute.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description TODO
 * @Author lishen
 * @Date 13/11/20 03:52
 **/
@Slf4j
@RestControllerAdvice
public class WebSiteExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public Result handler(RuntimeException e) {
        log.error("error happens: -----{} ", e);
        Result result = new Result();
        String exception =  e.getMessage();
        result.setStatus("exception");
        return result;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public Result handler(ShiroException e) {
        log.error("error happens: -----{} ", e);
        Result result = new Result();
        String exception =  e.getMessage();
        result.setStatus("shiroError");
        return result;
    }

}
