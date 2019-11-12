package com.homgkutech.pauth2.server.test;

import org.junit.Test;
import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class PasswordTest {

    public static void main(String[] args) {
        System.out.println("secret:"+new BCryptPasswordEncoder().encode("secret"));
        System.out.println("123456:"+new BCryptPasswordEncoder().encode("123456"));
    }
}
