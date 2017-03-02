package com.dm4x.DAO;

import com.dm4x.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kiselev on 21.02.17.
 */
public interface UserDao extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
