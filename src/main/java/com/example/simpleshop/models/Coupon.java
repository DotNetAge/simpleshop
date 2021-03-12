package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/***
 * 优惠券
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "coupons")
public class Coupon {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String name;

    /**
     * 折扣
     */
    private final Float discount;

    /**
     * 返现金额
     */
    private final Float payBack;

    /**
     * 启用时间
     */
    private final Date availabled;

    /**
     * 过期时间
     */
    private final Date expired;

    /**
     * 应用类别
     */
    @OneToMany
    private List<Category> categories;

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
