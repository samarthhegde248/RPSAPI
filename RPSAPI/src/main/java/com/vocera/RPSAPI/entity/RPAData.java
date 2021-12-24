package com.vocera.RPSAPI.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rpadata")
public class RPAData {
	@Id
	private String tokenId;
	private int userScore=0;
	private int systemScore=0;
	private boolean status=true;
	
	
	public RPAData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RPAData(String tokenId, int userScore, int systemScore, boolean status) {
		super();
		this.tokenId = tokenId;
		this.userScore = userScore;
		this.systemScore = systemScore;
		this.status = status;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public int getUserScore() {
		return userScore;
	}

	public void setUserScore(int userScore) {
		this.userScore = userScore;
	}

	public int getSystemScore() {
		return systemScore;
	}

	public void setSystemScore(int systemScore) {
		this.systemScore = systemScore;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RPAData [tokenId=" + tokenId + ", userScore=" + userScore + ", systemScore=" + systemScore + ", status="
				+ status + "]";
	}
	
	
}
