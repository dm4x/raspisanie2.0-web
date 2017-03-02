package com.dm4x.service;

import com.dm4x.Model.User;

/**
 * Created by kiselev on 21.02.17.
 */
public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
