package com.booker.booker.server.advice;

import com.booker.booker.server.exception.ContractAlreadyExistsException;
import com.booker.booker.server.exception.ContractNotFoundException;
import com.booker.booker.server.exception.EmailFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler
{
    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    @ExceptionHandler( EmailFoundException.class )
    public Map<String,String> handleEmailFoundException( EmailFoundException e )
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put( "errorMessage", e.getMessage() );
        return errorMap;
    }

    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    @ExceptionHandler( ContractAlreadyExistsException.class )
    public Map<String,String> handleContractAlreadyExistsException( ContractAlreadyExistsException e )
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put( "errorMessage", e.getMessage() );
        return errorMap;
    }

    @ResponseStatus( HttpStatus.INTERNAL_SERVER_ERROR )
    @ExceptionHandler( ContractNotFoundException.class )
    public Map<String,String> handleContractNotFoundException( ContractNotFoundException e )
    {
        Map<String,String> errorMap = new HashMap<>();
        errorMap.put( "errorMessage", e.getMessage() );
        return errorMap;
    }
}
