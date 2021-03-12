package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 库存
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name="inventories")
public class Inventory {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 批次号
     */
    private final String batchCode;

    /**
     * 位置编号
     */
    private final String location;

    /**
     * 存放的仓库
     */
    @ManyToOne(targetEntity = Warehouse.class)
    private final Warehouse warehouse;

    /**
     * 包装
     */
    @OneToOne(targetEntity = Packing.class)
    private final Packing packing;

    @OneToOne(targetEntity = Product.class)
    private final Product product;

    /**
     * 数量
     */
    private final Integer quantity;

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
