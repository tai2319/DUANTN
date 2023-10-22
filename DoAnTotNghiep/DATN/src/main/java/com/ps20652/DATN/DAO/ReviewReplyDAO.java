package com.ps20652.DATN.DAO;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ps20652.DATN.entity.ReviewReply;

public interface ReviewReplyDAO extends JpaRepository<ReviewReply, Integer> {

	List<ReviewReply> findByCustomerFeedbackFeedbackId(int replyId);
	
}
