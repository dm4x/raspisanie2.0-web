package com.dm4x.Model;

import javax.persistence.*;

/**
 * Created by dm4x on 19.02.17.
 */
@Entity
@Table(name="teachers")
public class Teacher {
    @Id
    @Column(name="record_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="teacher_name")
    private String name;

    @Column(name="teacher_full_name")
    private String fullName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
