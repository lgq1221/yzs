package com.statistics.yzs.entity;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Lgq
 * @Desc
 * @create 2019-01-15 10:35
 **/
@Entity
@Data
@Table(name="sys_user")
public class SysUserEntity implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private int sex;

    @Column(name = "email")
    private String email;

    @Column(name = "date_created")
    private LocalDate dateCreated = LocalDate.now();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
