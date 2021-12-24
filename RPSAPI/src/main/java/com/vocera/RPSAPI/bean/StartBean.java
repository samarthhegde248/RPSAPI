package com.vocera.RPSAPI.bean;

public class StartBean {
	private String response;
	private String token;
	
	
	public StartBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StartBean(String response, String token) {
		super();
		this.response = response;
		this.token = token;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	@Override
	public String toString() {
		return "StartBean [response=" + response + ", token=" + token + "]";
	}
	
}
