package com.fhr.musicstorerest.services;

import java.util.List;

import com.fhr.musicstorerest.models.Oauthclient;

public interface IClientService {
	
	List<Oauthclient> findAll();
	
	Oauthclient findById(int id);
	
	Oauthclient findByClientId(String clientId);
	
	Oauthclient save(Oauthclient oauthclient);
	
	Oauthclient update(Oauthclient oauthclient);
	
	void delete(int id);
}
