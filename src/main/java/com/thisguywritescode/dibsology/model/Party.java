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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@Entity
@Table(name = "parties")
public class Party {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	@ManyToOne
    @JoinColumn(name = "submission_id")
    @JsonIgnoreProperties("parties")
    private Submission submission;
	
	//TODO: Add votes
	
    @Column(name = "created_at")
    private Date createdAt;
    
    @Column(name = "updated_at")
    private Date updatedAt;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Submission getSubmission() {
		return submission;
	}

	public void setSubmission(final Submission submission) {
		this.submission = submission;
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
