package com.fhr.musicstorerest.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fhr.musicstorerest.daos.OauthclientDAO;
import com.fhr.musicstorerest.models.Oauthclient;
import com.fhr.musicstorerest.services.IClientService;
@Service
public class ClientServiceClass implements IClientService {
	
	@Autowired
	private OauthclientDAO oauthClientDAO=null;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Oauthclient> findAll() {
		return oauthClientDAO.findAll();
	}

	@Override
	public Oauthclient findById(int id) {
		return oauthClientDAO.findById(id);
	}

	@Override
	public Oauthclient findByClientId(String clientId) {
		return (Oauthclient)oauthClientDAO.findByClientId(clientId).stream().findFirst().get();
	}

	@Override
	public Oauthclient save(Oauthclient oauthclient) {
		oauthClientDAO.save(oauthclient);
		return oauthclient;
	}

	@Override
	public Oauthclient update(Oauthclient oauthclient) {
		oauthClientDAO.update(oauthclient);
		return oauthclient;
	}

	@Override
	public void delete(int id) {
		oauthClientDAO.delete(id);
	}

}
