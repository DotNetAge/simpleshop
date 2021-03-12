package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 商品类目
 * */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "categories")
public class Category {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 父分类
     * */
    private Long parentId;

    /**
     * 类目名称
     * */
    private final String name;

    /**
     * 类目描述
     * */
    private String description;

    /**
     * 类目路径
     * */
    private String path;

    @OneToMany(targetEntity = CategoryItem.class)
    private List<CategoryItem> categoryItems = new ArrayList<>();

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
