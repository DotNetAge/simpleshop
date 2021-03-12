package com.example.simpleshop.models;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "orderItems")
public class OrderItem {
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
     * 产品
     */
    @OneToOne
    private CategoryItem categoryItem;

    /***
     * 数量
     */
    private final Float quantity;

    /***
     * 单价
     */
    private final Float price;

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
