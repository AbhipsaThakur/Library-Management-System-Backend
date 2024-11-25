package com.example.springsecurity.test.librarymanagementsystembackend.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "userid", length = 10)
    private int userid;

    @Column(name = "username", length = 50)
    private String username;

    @Column(name = "useremail", length = 50)
    private String useremail;

    @OneToMany(mappedBy = "user")
    private Set<Borrow> borrows;

    public User(int userid, String username, String useremail) {
        this.userid = userid;
        this.username = username;
        this.useremail = useremail;
    }

    public User(String username, String useremail) {
        this.username = username;
        this.useremail = useremail;
    }
    public User() {

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                '}';
    }
}
