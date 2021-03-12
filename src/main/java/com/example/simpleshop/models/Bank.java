package com.example.simpleshop.models;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * 银行
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "banks")
public class Bank {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private final String name;

    /**
     * 地址
     */
    @OneToOne
    private final Address address;

    /**
     * 联系方式
     */
    @OneToOne
    private final Contract contract;

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
