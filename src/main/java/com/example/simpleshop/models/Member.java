package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * 会员
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "members")
public class Member {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private final User user;

    private final String name;

    /***
     * 积分
     */
    private final Long score;

    @OneToOne
    private MemberLevel level;

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
