package com.example.demo.infrastructure.exception.rest;


import com.example.demo.infrastructure.constant.Message;

public class MessageHandlingException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String message;

    public MessageHandlingException() {
    }

    public MessageHandlingException(Message statusCode) {
        this.message = statusCode.getMessage();
    }

    public MessageHandlingException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
