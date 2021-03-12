package com.example.simpleshop.models;


import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
//@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "permissions")
public class Permission {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String title;

    private String description;

    private int flag;

    @ManyToMany(targetEntity = Role.class)
    private List<Role> roles = new ArrayList<>();

    /***
     * 创建日期
     */
    private Date createdAt;

    /***
     * 最后修改日期
     */
    private Date latestModified;

    @PrePersist
    void setPreValues() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }

        this.latestModified = new Date();
    }

}
