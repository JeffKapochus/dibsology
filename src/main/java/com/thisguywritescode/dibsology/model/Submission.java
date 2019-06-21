package com.thisguywritescode.dibsology.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name = "submissions")
public class Submission {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String text;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable=false)
	@JsonIgnoreProperties("submissions")
	private User user;

	@OneToMany(mappedBy="submission")
	@JsonIgnoreProperties("submission")
	private List<Party> parties;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "updated_at")
	private Date updatedAt;

	public int getId() {
		return id;
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
	
	public User getUser() {
	    return user;
	}
	
	public void setUser(final User user) {
	    this.user = user;
	}
	
	public List<Party> getParties() {
        return parties;
    }
    
    public void setParties(final List<Party> parties) {
        this.parties = parties;
    }

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(final Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(final Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
