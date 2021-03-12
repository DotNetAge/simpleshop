package com.example.simpleshop.models;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 发货单细项
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "shipping_order_items")
public class ShippingOrderItem {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /***
     * 产品描述
     */
    @NotNull
    private final String name;

    /***
     * 图片地址
     * */
    private final String imgUrl;

    /***
     * 产品项编号
     * 按需使用
     */
    private final String itemNumber;

    /***
     * 数量
     */
    private final Float quantity;

    @OneToOne
    private final OrderItem orderItem;

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
