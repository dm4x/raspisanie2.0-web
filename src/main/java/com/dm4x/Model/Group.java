package com.dm4x.Model;

import javax.persistence.*;

/**
 * Created by dm4x on 19.02.17.
 */
@Entity
@Table(name="groups")
public class Group {
    @Id
    @Column(name="record_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="group_name")
    private String name;

    @Column(name="group_number")
    private String number;

    @Column(name="management")
    private String management;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getManagement() {
        return management;
    }

    public void setManagement(String management) {
        this.management = management;
    }
}
