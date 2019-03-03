package com.dev.ams;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class AppConfig {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("dev123"));
    }
}
