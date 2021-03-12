package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 店铺
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "shops")
public class Shop {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 店铺名
     */
    private final String name;

    /**
     * 店铺介绍
     */
    private String description;

    /**
     * 所有者
     */
    @ManyToOne
    private User owner;

    /**
     * 评分
     */
    private Float ratings;

    /**
     * 地址位置
     */
    private String location;

    /**
     * 联系人
     */
    @OneToOne
    private Contract contract;

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
