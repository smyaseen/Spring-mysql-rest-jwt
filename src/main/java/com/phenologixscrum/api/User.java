package com.phenologixscrum.api;

import com.sun.istack.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="users")
@EntityListeners(AuditingEntityListener.class)

public class User implements Serializable {

    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column
    private String user_firstname;
    @NotNull
    @Column
    private String user_lastname;
    @NotNull
    @Column
    private String user_email;
    @NotNull
    @Column
    private String user_password;
    @NotNull
    @Column
    private String user_isenable;
    @NotNull
    @Column
    private String user_dateofbirth;
    @NotNull
    @Column
    private String user_expirationlink;





    public Long getId() {
        return id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_secondname) {
        this.user_lastname = user_secondname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_isenable() {
        return user_isenable;
    }

    public void setUser_isenable(String user_isenable) {
        this.user_isenable = user_isenable;
    }

    public String getUser_dateofbirth() {
        return user_dateofbirth;
    }

    public void setUser_dateofbirth(String user_dateofbirth) {
        this.user_dateofbirth = user_dateofbirth;
    }

    public String getUser_expirationlink() {
        return user_expirationlink;
    }

    public void setUser_expirationlink(String user_expirationlink) {
        this.user_expirationlink = user_expirationlink;
    }

    public void setId(Long id) {
        this.id = id;
    }



}
