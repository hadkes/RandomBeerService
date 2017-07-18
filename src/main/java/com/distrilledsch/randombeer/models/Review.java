package com.distrilledsch.randombeer.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table (name = "review")
public final class Review{
	public static final String ANONYMOUS = "Anonymous";
	
	@Id
	@Column (name = "id")
	private String id;
	
	@Column(name = "reviewer")
	private String reviewer;
	
	@Column(name = "review")
	private String review;
	
	public Review() {
		// default constructor
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		// validate review
		if (id == null) {
			throw new IllegalArgumentException("Beer review id cannot be null.");
		}
		if (id.trim().length() == 0) {
			throw new IllegalArgumentException("Beer review id cannot be empty.");
		}
		this.id = id;
	}



	public void setReviewer(String inReviewer) {
		inReviewer = inReviewer == null ? ANONYMOUS : inReviewer;
		inReviewer = inReviewer.trim().length() == 0 ? ANONYMOUS : inReviewer;
		
		this.reviewer = inReviewer;
	}
	public String getReviewer() {
		return reviewer;
	}
	
	public void setReview(String review) {
		// validate review
		if (review == null) {
			throw new IllegalArgumentException("Product review cannot be null.");
		}
		if (review.trim().length() == 0) {
			throw new IllegalArgumentException("Product review cannot be empty.");
		}

		this.review = review;
	}
	public String getReview() {
		return review;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + ((reviewer == null) ? 0 : reviewer.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (reviewer == null) {
			if (other.reviewer != null)
				return false;
		} else if (!reviewer.equals(other.reviewer))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [reviewer=" + reviewer + ", review=" + review + "]";
	}
}
