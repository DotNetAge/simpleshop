package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 组织
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "organizations")
public class Organization {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     * 名称
     */
    private final String name;
    /**
     * 描述
     */
    private String description;
    /**
     * 联系方式
     */
    @OneToOne
    private Contract contract;
    /**
     * 地址
     */
    @OneToOne
    private Address address;
    /**
     * 创办人
     */
    private String founder;
    /**
     * 创办时间
     */
    private Date foundingDate;
    /**
     * 网站
     */
    private String webSite;
    /**
     * Logo 地址
     */
    private String logoUrl;

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
