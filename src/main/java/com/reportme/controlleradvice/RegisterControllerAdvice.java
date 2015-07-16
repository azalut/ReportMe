package com.reportme.controlleradvice;

import com.reportme.controller.RegisterController;
import com.reportme.exception.person.InvalidConfirmationTokenException;
import com.reportme.exception.person.RegisterException;
import com.reportme.exception.person.UsernameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackageClasses = {RegisterController.class})
public class RegisterControllerAdvice {

    @ExceptionHandler({UsernameException.class, InvalidConfirmationTokenException.class})
    public ModelAndView usernameException(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView("register/confirmation-result");
        modelAndView.addObject("request", request);
        modelAndView.addObject("exception", exception);
        modelAndView.addObject("isConfirmationSucceed", false);
        return modelAndView;
    }

    @ExceptionHandler({RegisterException.class})
    public ModelAndView registerException(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView("register/register-error");
        modelAndView.addObject("request", request);
        modelAndView.addObject("exception", exception);

        return modelAndView;
    }
}
