package com.dm4x.Model;

import javax.persistence.*;

/**
 * Created by dm4x on 19.02.17.
 */
@Entity
@Table(name="subjects")
public class Subject {

    @Id
    @Column(name="record_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="subject_name")
    private String name;

    @Column(name="exam")
    private int exam;

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

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position='" + exam + '\'' +
                '}';
    }

}
