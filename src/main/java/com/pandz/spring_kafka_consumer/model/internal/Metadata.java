package com.pandz.spring_kafka_consumer.model.internal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Metadata implements Serializable {
    private static final long serialVersionUID = -7298300595712991590L;
    private String ipAddress;
    private String userAgent;
    private String channel;
    private String appVersion;
    private String signature;
    private String timestamp;
    private String requestId;
    private String bearerToken;
}
