package com.dm4x.DAO;

import com.dm4x.Model.Group;
import com.dm4x.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dm4x on 19.02.17.
 */
public interface GroupDao extends JpaRepository<Group, Long> {
    Subject getGroupById(Long id);
    List<Group> findAll();
}
