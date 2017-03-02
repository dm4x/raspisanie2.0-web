package com.dm4x.DAO;

import com.dm4x.Model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by dm4x on 19.02.17.
 */
public interface SubjectDao extends JpaRepository <Subject, Long> {
    Subject getSubjectById(Long id);
    List<Subject> findAll();
}
