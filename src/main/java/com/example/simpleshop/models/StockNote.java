package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 进出仓单
 */
@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "stock_notes")
public class StockNote {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 单号
     */
    private final String code;

    /**
     * 仓库
     */
    @ManyToOne
    private final Warehouse warehouse;

    /**
     * 司机
     */
    @OneToOne
    private final Contract driver;

    /**
     * 车牌号
     */
    private final String carNumber;

    /**
     * 载重
     */
    private final Float weight;

    /**
     * 净重
     */
    private final Float netWeight;

    /**
     * 备注
     */
    private String memo;


    /**
     * 入库时间
     */
    private Date inStockDate;

    /**
     * 时间
     */
    private Date createdOn;

    /**
     * 经手人
     */
    @ManyToOne
    private User handler;

    @OneToMany
    private List<StockItem> items = new ArrayList<>();

    private Directions direction;

    /***
     * 创建日期
     */
    private Date createdAt;

    /***
     * 最后修改日期
     */
    private Date latestModified;

    public static enum Directions {
        IN,
        OUT;
    }

    @PrePersist
    void setPreValues() {
        this.direction = Directions.IN;

        if (this.createdAt == null) {
            this.createdAt = new Date();
        }

        this.latestModified = new Date();
    }

}
