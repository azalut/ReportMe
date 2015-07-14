package com.reportme.controlleradvice;

import com.reportme.exception.person.UsernameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler({UsernameException.class})
    public ModelAndView usernameException(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView("register/register-result");
        modelAndView.addObject("request", request);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
