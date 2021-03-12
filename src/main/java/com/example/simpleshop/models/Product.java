package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 商品
 * 用于描述一个实际的商品的资料信息
 * */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "products")
public class Product {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 产品名称
     * */
    private final String name;

    /**
     * 商品标签
     * */
    @ElementCollection
    private Set<String> tags = new HashSet<>();

    /**
     * 商品别名
     * */
    @ElementCollection
    private Set<String> alternateNames = new HashSet<>();

    /**
     * 颜色
     */
    @ElementCollection
    private Set<String> colors = new HashSet<>();

    /**
     * 描述
     * */
    private final String description;

    /**
     * 商品图片地址（主图）
     * */
    private String imgUrl;

    /**
     * 相关图片
     */
    @ElementCollection
    private Set<String> imgUrls = new HashSet<>();

    /**
     * 参考销售价
     * */
    private final Float price;

    /**
     * 品牌
     * */
    private String brand;

    /**
     * 规格
     * */
    private String size;

    /**
     * 制造商
     * */
    private String manufacturer;

    /**
     * 材质
     * */
    private String material;

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
