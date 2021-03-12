package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 包装
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "packings")
public class Packing {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private final String name;

    /**
     * 包装单位
     * 如: 箱，代，框等
     */
    private final String unit;

    /**
     * 单位存储量
     */
    private final Long quantity;

    /**
     * 规格/尺寸
     */
    private final String size;

    /**
     * 长度
     */
    private final Float length;

    /**
     * 宽度
     */
    private final Float width;

    /**
     * 高度
     */
    private final Float height;

    /**
     * 净重
     */
    private final Float netWeight;

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
