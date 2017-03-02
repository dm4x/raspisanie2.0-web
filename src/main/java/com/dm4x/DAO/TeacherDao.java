package com.dm4x.DAO;

import com.dm4x.Model.Subject;
import com.dm4x.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dm4x on 19.02.17.
 */
public interface TeacherDao extends JpaRepository<Teacher, Long> {
    Teacher getTeacherById(Long id);
    List<Teacher> findAll();
}
