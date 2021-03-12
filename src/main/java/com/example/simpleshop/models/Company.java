package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 公司
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name="companies")
public class Company {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private final Organization organization;

    /**
     * 公司名称
     */
    private final String name;

    /**
     * 公司介绍
     */
    private final String description;

    /**
     * 税号
     */
    private final String taxNum;

    /**
     * 营业执照
     */
    private final String licenseImgUrl;

    /**
     * 营业执照副本
     */
    private final String licenseCopyImgUrl;

    /**
     * 银行账号
     */
    private final String bankAccount;

    /**
     * 开户银行
     */
    @OneToOne
    private final Bank bank;

    /**
     * 法人
     */
    private String owner;

    /**
     * 地址
     */
    @OneToOne
    private Address address;

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
