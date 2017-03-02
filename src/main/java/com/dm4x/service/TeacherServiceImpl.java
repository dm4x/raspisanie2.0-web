package com.dm4x.service;

import com.dm4x.DAO.TeacherDao;
import com.dm4x.Model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kiselev on 22.02.17.
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherDao teacherDao;

    @Override
    @Transactional
    public void save(Teacher teacher) {
        teacherDao.save(teacher);
    }

    @Override
    @Transactional
    public void delete(Teacher teacher){
        teacherDao.delete(teacher);
    }

    @Override
    @Transactional
    public Teacher getTeacherById(Long id){
        return teacherDao.getTeacherById(id);
    }

    @Override
    @Transactional
    public List<Teacher> listTeachers(){
        return teacherDao.findAll();
    }
}
