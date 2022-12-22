package com.musala.soft.resources.configuration;

import com.musala.soft.resources.exception.ApiException;
import com.musala.soft.resources.pojo.RestResponsePojo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@RestControllerAdvice
@Slf4j
public class ApiAdvice {
    @ExceptionHandler({HttpMessageNotReadableException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RestResponsePojo<?> handleMessageNotReadable(HttpMessageNotReadableException e,
                                                                      final Model model, HttpServletResponse response){
        RestResponsePojo<String> responsePojo = new RestResponsePojo<>();

        e.printStackTrace();
        log.info(e.getLocalizedMessage());
        responsePojo.setMessage("Unreadable message body");
        responsePojo.setSuccess(Boolean.FALSE);
        responsePojo.setData(e.getMessage());

        return responsePojo;
    }

    @ExceptionHandler({ApiException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RestResponsePojo<?> handleApiException(ApiException e, final Model model, HttpServletResponse response){
        log.error("Exception during execution of application " + e.getMessage());
        e.printStackTrace();
        RestResponsePojo<String> responsePojo = new RestResponsePojo<>();
        log.info(e.getLocalizedMessage());
        responsePojo.setMessage(e.getMessage());
        responsePojo.setSuccess(Boolean.FALSE);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return responsePojo;
    }

    @ExceptionHandler({SQLException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody RestResponsePojo<?> handleSQLException(SQLException e, final Model model, HttpServletResponse response){
        log.error("Exception during execution of application " + e.getMessage());
        e.printStackTrace();
        RestResponsePojo<String> responsePojo = new RestResponsePojo<>();
        log.info(e.getLocalizedMessage());
        responsePojo.setMessage(e.getMessage());
        responsePojo.setSuccess(Boolean.FALSE);
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return responsePojo;
    }

    @ExceptionHandler({Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public @ResponseBody RestResponsePojo<?> handleException(Exception e, final Model model, HttpServletResponse response){
        RestResponsePojo<String> responsePojo = new RestResponsePojo<>();

        e.printStackTrace();
        log.info(e.getLocalizedMessage());

        responsePojo.setMessage("Unable to process request at the moment | " + e.getMessage());
        responsePojo.setSuccess(Boolean.FALSE);
        responsePojo.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        return responsePojo;
    }
}
