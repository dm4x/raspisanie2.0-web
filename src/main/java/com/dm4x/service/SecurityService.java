package com.dm4x.service;

/**
 * Created by kiselev on 22.02.17.
 */
public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
