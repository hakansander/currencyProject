package com.hakansander.currency.exceptionHandling;

import com.hakansander.currency.util.CommonUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CurrencyExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CurrencyExchangeErrorResponse> handleException(CurrencyFormatException exc) {
        CurrencyExchangeErrorResponse error = new CurrencyExchangeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                CommonUtils.getCurrentDate());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CurrencyExchangeErrorResponse> handleException(Exception exc) {
        CurrencyExchangeErrorResponse error = new CurrencyExchangeErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                CommonUtils.getCurrentDate());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
