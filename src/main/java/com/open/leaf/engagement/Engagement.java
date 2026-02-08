package com.open.leaf.engagement;

import java.time.LocalDate;

public class Engagement {
	
	
	private String id;
	private String userId;
	private String engagementType;
	private LocalDate startAt;
	private LocalDate endAt;
	private String status;
	private String pdfUrl;

	public Engagement(String id, String userId, String engagementType, LocalDate startAt, LocalDate endAt,
			String status, String pdfUrl) {
		super();
		this.id = id;
		this.userId = userId;
		this.engagementType = engagementType;
		this.startAt = startAt;
		this.endAt = endAt;
		this.status = status;
		this.pdfUrl = pdfUrl;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}





	public void setUserId(String userId) {
		this.userId = userId;
	}





	public String getEngagementType() {
		return engagementType;
	}





	public void setEngagementType(String engagementType) {
		this.engagementType = engagementType;
	}





	public LocalDate getStartAt() {
		return startAt;
	}





	public void setStartAt(LocalDate startAt) {
		this.startAt = startAt;
	}





	public LocalDate getEndAt() {
		return endAt;
	}





	public void setEndAt(LocalDate endAt) {
		this.endAt = endAt;
	}





	public String getStatus() {
		return status;
	}





	public void setStatus(String status) {
		this.status = status;
	}





	public String getPdfUrl() {
		return pdfUrl;
	}





	public void setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
	}





	
	
	
	@Override
	public String toString() {
		return "Engagement [id=" + id + ", userId=" + userId + ", engagementType=" + engagementType + ", startAt="
				+ startAt + ", endAt=" + endAt + ", status=" + status + ", pdfUrl=" + pdfUrl + "]";
	}


}
