package com.example.simpleshop.models;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@RequiredArgsConstructor
@Table(name = "users")
public class User implements UserDetails {
    private static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private final String username;

    private final String password;

    private final String fullName;

    private final String mobile;

    @ManyToMany(targetEntity = Role.class)
    private List<Role> roles = new ArrayList<>();

    /***
     * 创建日期
     */
    private Date createdAt;

    /***
     * 最后修改日期
     */
    private Date latestModified;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        /*
        TODO: SimpleGrantedAUthority 是什么类？这里应该怎么用呢？
        Authority 就是Spring中的权限类，可以理解为Permissions
        为什么是实体类内获取Permissions呢 ？
        Authority 到底对应的是Role还是Permission?
        注意: Spring 中的 Authority 就是权限管理，需要好好了解Authority 是怎么实现的
        */
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
        // 从代码上看 Authority 就是 Role
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    void setPreValues() {
        if (this.createdAt == null) {
            this.createdAt = new Date();
        }

        this.latestModified = new Date();
    }

}
