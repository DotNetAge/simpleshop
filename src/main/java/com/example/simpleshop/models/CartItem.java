package com.example.simpleshop.models;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 购物车项
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "cartItems")
public class CartItem {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /***
     * 购物车所有者编号
     */
    private final Long ownerId;
    /***
     * 产品描述
     */
    @NotNull
    private final String name;
    /***
     * 产品别名
     */
    private final String alternateName;
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
     * 产品编号(SKU)
     */
    private final Long productId;

    /***
     * 数量
     */
    private final Float quantity;
    /***
     * 单价
     * 加入购物车时的单价
     */
    private final Float unitPrice;
    /***
     * 原价
     * 加入购物车时的单价
     */
    private final Float oldUnitPrice;

    /***
     * 单品折扣
     */
    private final Float discount;
    /***
     * 总价
     */
    private final Float amount;
    /***
     * 附加描述
     */
    private final String description;
    /***
     * 产品是否已失效
     * 商品已下架或已经被删除
     */
    private final Boolean unavailable;

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


    public OrderItem toOrderItem() {
        return new OrderItem(name,
                alternateName,
                imgUrl,
                itemNumber,
                quantity,
                unitPrice,
                discount,
                amount,
                description);
    }
}
