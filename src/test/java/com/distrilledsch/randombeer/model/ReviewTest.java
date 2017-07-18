package com.distrilledsch.randombeer.model;

import org.junit.Test;

import com.distrilledsch.randombeer.models.Review;

import org.junit.Assert;

public class ReviewTest {
	@Test
	public void testReview(){
		Review review = ObjectCreationFactory.createReview();
		Assert.assertEquals(review.getReviewer(), ObjectCreationFactory.reviewer);
		Assert.assertEquals(review.getReview(), ObjectCreationFactory.review);
	}
	
	@Test
	public void testNullReviewer(){
		Review review = new Review();
		review.setReviewer(null);
		review.setReview(ObjectCreationFactory.review);
		Assert.assertEquals(review.getReviewer(), Review.ANONYMOUS);
		Assert.assertEquals(review.getReview(), ObjectCreationFactory.review);
	}
	
	@Test
	public void testEmptyReviewer(){
		Review review = new Review();
		review.setReviewer("");
		review.setReview(ObjectCreationFactory.review);
		Assert.assertEquals(review.getReviewer(), Review.ANONYMOUS);
		Assert.assertEquals(review.getReview(), ObjectCreationFactory.review);
	}	
}
