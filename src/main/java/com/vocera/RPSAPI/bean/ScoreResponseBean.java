package com.vocera.RPSAPI.bean;

public class ScoreResponseBean {
	private String response;
	private int yourScore;
	private int systemScore;
	
	
	
	public ScoreResponseBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ScoreResponseBean(String response, int yourScore, int systemScore) {
		super();
		this.response = response;
		this.yourScore = yourScore;
		this.systemScore = systemScore;
	}
	
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getYourScore() {
		return yourScore;
	}
	public void setYourScore(int yourScore) {
		this.yourScore = yourScore;
	}
	public int getSystemScore() {
		return systemScore;
	}
	public void setSystemScore(int systemScore) {
		this.systemScore = systemScore;
	}
	
	@Override
	public String toString() {
		return "ScoreResponseBean [response=" + response + ", yourScore=" + yourScore + ", systemScore=" + systemScore
				+ "]";
	}
	
}
