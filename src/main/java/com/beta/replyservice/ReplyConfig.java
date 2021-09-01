package com.beta.replyservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Configuration
public class ReplyConfig {
    @Bean
    public Map<String, Function<String, String>> conf() {
        final Map<String, Function<String, String>> conf = new HashMap<>();
        conf.put("1", (s) -> new StringBuilder(s).reverse().toString());
        conf.put("2", (s) -> {
            MessageDigest md = null;
            try {
                md = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            byte[] messageDigest = md.digest(s.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        });
        return conf;
    }
}
