package com.reportme.controller.controlleradvice;

import com.reportme.exception.person.UsernameNotAvailableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class PersonControllerAdvice {

    @ExceptionHandler({UsernameNotAvailableException.class})
    public ModelAndView personNotFoundException(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView("register/register-error");
        modelAndView.addObject("request", request);
        modelAndView.addObject("exception", exception);
        return modelAndView;
    }
}
