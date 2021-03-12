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
 * 发货单
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "shipping_orders")
public class ShippingOrder {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 承运方
     */
    private final String shipper;

    /**
     * 发货地址
     */
    @OneToOne
    private final Address senderAddress;

    /**
     * 收货地址
     */
    @OneToOne
    private final Address receiverAddress;

    /**
     * 发货方
     */
    @OneToOne
    private final Contract sender;

    /**
     * 收货方
     */
    @OneToOne
    private final Contract recipient;

    /**
     * 源订单
     */
    @ManyToOne
    private final Order order;

    /**
     * 重量
     */
    private final Float weight;

    /**
     * 备注
     */
    private final String memo;

    /**
     * 保价费
     */
    private final Float insurance;

    /***
     * 创建日期
     */
    private Date createdAt;

    /***
     * 最后修改日期
     */
    private Date latestModified;

    @OneToMany
    private List<ShippingOrderItem> items = new ArrayList<>();

    @PrePersist
    void setPreValues() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }

        this.latestModified = new Date();
    }
}
