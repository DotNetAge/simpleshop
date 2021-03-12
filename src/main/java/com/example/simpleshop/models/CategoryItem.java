package com.example.simpleshop.models;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.*;

/**
 * 类目商品（SKU)
 * 用于描述产品的销售属性与实际上架的库存属性
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "category_items")
public class CategoryItem {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 商品编号
     */
    private final String itemNumber;

    /**
     * 所属分类
     */
    @ManyToOne(targetEntity = Category.class)
    private final Category category;

    /**
     * 名称
     */
    private final String name;

    /**
     * 描述
     */
    private final String description;

    /**
     * 售价
     */
    private final Float price;

    /**
     * 规格
     */
    private final String size;

    /**
     * 商品主图
     */
    private final String imgUrl;

    /**
     * 相关图片
     */
    @ElementCollection
    private Set<String> imgUrls = new HashSet<>();

    /**
     * 品牌
     */
    @OneToOne(targetEntity = Brand.class)
    private final Brand brand;

    /**
     * 产品
     */
    @OneToOne
    private final Product product;

    /**
     * 实际库存
     */
    private Integer availableStock;

    /**
     * 库存警戒线
     */
    private Integer reStockThreshold;

    /**
     * 最大库存量
     */
    private Integer maxStockThreshold;

    /**
     * 上架时间
     */
    private Date upSellingDate;

    /**
     * 已下架
     */
    private boolean isDown;

    /**
     * 调价记录
     */
    @OneToMany(targetEntity = PriceChangedLog.class)
    private List<PriceChangedLog> changedHistory = new ArrayList<>();

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
