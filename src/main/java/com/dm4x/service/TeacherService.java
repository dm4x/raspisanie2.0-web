package com.dm4x.service;

import com.dm4x.Model.Teacher;

import java.util.List;

/**
 * Created by kiselev on 22.02.17.
 */
public interface TeacherService {
    void save (Teacher teacher);

    void delete (Teacher teacher);

    Teacher getTeacherById(Long id);

    List<Teacher> listTeachers();
}
