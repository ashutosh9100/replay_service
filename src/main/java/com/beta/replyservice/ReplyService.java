package com.beta.replyservice;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;

@Service
public class ReplyService {
    public static final String EMPTY_SEPARATOR = "";
    private final Map<String, Function<String,String>> configmap;

    public ReplyService(Map<String, Function<String, String>> configmap) {
        this.configmap = configmap;
    }

    public ReplyMessage processMessage(String message, String rule) {
        for(String str : rule.split(EMPTY_SEPARATOR)){
            message = configmap.get(str).apply(message);
        }
        return new ReplyMessage(message) ;
    }
}
