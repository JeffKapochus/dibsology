package com.thisguywritescode.dibsology.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "hashed_password")
    private String hashed_password;
    
    @OneToMany(mappedBy="submission")
    private List<Submission> submissions;
    
    @Column(name = "created_at")
    private Date created_at;
    
    @Column(name = "updated_at")
    private Date updated_at;
    
    public User() {
        this.name = "temp name";
        this.email = "temp email";
        this.submissions = new ArrayList<Submission>();
        this.created_at = new Date();
        this.updated_at = new Date();
    }
    
    public User(final String nameIn, final String emailIn) {
        this.name = nameIn;
        this.email = emailIn;
        this.submissions = new ArrayList<Submission>();
        this.created_at = new Date();
        this.updated_at = new Date();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(final String email) {
        this.email = email;
    }
    
    public String getHashed_password() {
        return hashed_password;
    }
    
    public void setHashed_password(final String hashed_password) {
        this.hashed_password = hashed_password;
    }
    
    public List<Submission> getSubmissions() {
        return submissions;
    }
    
    public void setSubmissions(final List<Submission> submissions) {
        this.submissions = submissions;
    }
    
    public Date getCreated_at() {
        return created_at;
    }
    
    public void setCreated_at(final Date created_at) {
        this.created_at = created_at;
    }
    
    public Date getUpdated_at() {
        return updated_at;
    }
    
    public void setUpdated_at(final Date updated_at) {
        this.updated_at = updated_at;
    }

}
