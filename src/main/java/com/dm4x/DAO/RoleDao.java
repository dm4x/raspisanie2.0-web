package com.dm4x.DAO;

import com.dm4x.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by kiselev on 21.02.17.
 */
public interface RoleDao extends JpaRepository<Role, Long> {
}
