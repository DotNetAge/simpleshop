package com.example.simpleshop.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 地址
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "addresses")
public class Address {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 国家
     */
    private final String country;

    /**
     * 省
     */
    private final String state;

    /**
     * 市
     */
    private final String city;

    /**
     * 区
     */
    private final String region;

    /**
     * 街道
     */
    private final String street;

    /**
     * 邮政编码
     */
    private final String zipCode;

    /**
     * 经度
     */
    private final Float lat;

    /**
     * 纬度
     */
    private final Float lon;

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
