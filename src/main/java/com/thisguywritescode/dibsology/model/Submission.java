package com.thisguywritescode.dibsology.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "game")
public class Submission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "title")
    private String title;
    
    @Column(name = "text")
    private String text;
    
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
    
    @Column(name = "created_at")
    private Date created_at;
    
    @Column(name = "updated_at")
    private Date updated_at;
    
    public Submission() {
        this.title = "temp title";
        this.text = "temp text";
        this.user = new User();
        this.created_at = new Date();
        this.updated_at = new Date();
    }
    
    public Submission(final String titleIn, final String textIn, final User userIn) {
        this.title = titleIn;
        this.text = textIn;
        this.user = userIn;
        this.created_at = new Date();
        this.updated_at = new Date();
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(final String title) {
        this.title = title;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(final String text) {
        this.text = text;
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

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

}
