package com.fhr.musicstorerest.models;

/**
 * Oauthclient entity. @author MyEclipse Persistence Tools
 */

public class Oauthclient implements java.io.Serializable {

	// Fields

	private Integer oauthClientId;
	private String clientId;
	private String clientSecret;

	// Constructors

	/** default constructor */
	public Oauthclient() {
	}

	/** full constructor */
	public Oauthclient(String clientId, String clientSecret) {
		this.clientId = clientId;
		this.clientSecret = clientSecret;
	}

	// Property accessors

	public Integer getOauthClientId() {
		return this.oauthClientId;
	}

	public void setOauthClientId(Integer oauthClientId) {
		this.oauthClientId = oauthClientId;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return this.clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

}