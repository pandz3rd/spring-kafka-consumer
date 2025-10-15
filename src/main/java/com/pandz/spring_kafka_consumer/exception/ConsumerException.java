package com.pandz.spring_kafka_consumer.exception;

import com.pandz.spring_kafka_consumer.model.internal.ApiBaseResponse;
import com.pandz.spring_kafka_consumer.util.ResponseUtil;

import java.io.Serializable;

public class ConsumerException extends RuntimeException {
    private final String messageCode;
    private final String errorCode;
    private final String errorMessage;

    public ConsumerException(String message, String code, String errorMessage) {
        super(message);
        this.messageCode = message;
        this.errorCode = code;
        this.errorMessage = errorMessage;
    }

    public ApiBaseResponse<Serializable> apiResponseBase() {
        return ResponseUtil.buildResponse(this.messageCode, this.errorCode);
    }
}
