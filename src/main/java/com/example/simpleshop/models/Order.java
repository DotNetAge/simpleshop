package com.example.simpleshop.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "orders")
public class Order {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /***
     * 单号
     */
    @NotNull
    private final String orderNumber;

    /***
     * 订单日期
     */
    private Date orderDate;

    /**
     * 订单有效期
     * 这个有效期过了之后订单则需要被视为作废
     */
    private Date paymentDueDate;

    /***
     * 创建日期
     */
    private Date createdAt;

    /***
     * 最后修改日期
     */
    private Date latestModified;

    /***
     * 处理人ID
     */
    private final Long handlerId;

    /***
     * 订单总额
     */
    private final Float amount;

    /**
     * 折扣
     */
    private Float discount;

    /**
     * 是否礼物单
     */
    private Boolean isGift;

    /**
     * 订单状态
     */
    private Status orderStatus;

    /**
     * 开票日期
     */
    private Date invoiceDate;

    /**
     * 发票号
     */
    private String invoiceNumber;

    /**
     * 支付凭据号
     * 当收订单被确认支付后收到支付单获取到支付凭据代码
     */
    private String confirmationNumber;

    /**
     * 备注
     */
    private String memo;

    /**
     * 运费
     */
    private Float freight;

    /**
     * 客户编号
     */
    private final Long customerId;

    /**
     * 客户姓名
     */
    private final String customerName;

    /**
     * 送货地址
     */
    private final String address;

    /**
     * 订单项
     */
    @OneToMany(targetEntity = OrderItem.class)
    private List<OrderItem> items = new ArrayList<>();

    public static enum Status {
        /**
         * 创建订单 (等待付款)
         */
        SUBMITTED,
        AWAITING_VALIDATION,
        /**
         *
         */
        STOCK_CONFIRMED,
        /**
         * 已付款
         */
        PAID,
        /**
         * 已发货
         * */
        SHIPPED,
        /**
         * 已取消
         */
        CANCELED;
    }


    @PrePersist
    void setPreValues() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }

        if (this.orderDate == null) {
            this.orderDate = new Date();
        }

        this.latestModified = new Date();
    }

}