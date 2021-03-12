package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/***
 * 支付凭据（回单）
 */
@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "payments")
public class Payment {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private PaymentMethods paymentMethod;

    /***
     * 数据源
     */
    private final String source;

    /**
     * 交易号
     */
    private final String transitionId;

    /***
     * 商家号
     */
    private final String merchantNumber;

    /***
     * 支付人姓名
     */
    private final String payer;

    /***
     * 支付金额
     */
    private final Float amount;

    /***
     * 备注
     */
    private String memo;

    /***
     * 创建日期
     */
    private Date createdAt;

    /***
     * 支付日期
     */
    private Date payDate;

    /***
     * 最后修改日期
     */
    private Date latestModified;

    @ManyToOne
    private final Order order;

    /**
     * 银行回单图片地址
     */
    private final String imgUrl;

    public static enum PaymentMethods {
        /***
         * 现金
         */
        CASH,
        /***
         * 微信支付
         */
        WECHAT,
        /***
         * 支付宝
         */
        ALIPAY,
        /***
         * 云闪付
         */
        UNION_PAY,
        /***
         * 其它银行
         */
        ONLINE_BANKING;
    }

    @PrePersist
    void setPreValues() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }

        this.latestModified = new Date();
    }

}
