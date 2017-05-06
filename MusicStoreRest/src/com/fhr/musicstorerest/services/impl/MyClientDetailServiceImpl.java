package com.fhr.musicstorerest.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import com.fhr.musicstorerest.models.Oauthclient;
import com.fhr.musicstorerest.services.IClientService;
/**
 * 客户端服务实现
 * 每个客户端都需要像用户那样进行对待！
 * 客户端包括clientId,ClientSecret,GrantTypes三个信息，这儿ClientId、ClientSecret是数据库取出来
 * GrantTypes可以硬编码
 * @author fhr
 * @date 2017/05/05 
 */
public class MyClientDetailServiceImpl implements ClientDetailsService {
	
	@Autowired
	private IClientService clientService=null;
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {
		Oauthclient oauthclient=null;
		if ((oauthclient=clientService.findByClientId(clientId))!=null) {
			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(oauthclient.getClientId());
			clientDetails.setClientSecret(oauthclient.getClientSecret());
			List<String> authorizedGrantTypes = createGrantTypes();
			clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
			return clientDetails;
		} else {
			throw new NoSuchClientException("No client recognized with id: " + clientId);
		}
	}

	private List<String> createGrantTypes() {
		List<String> authorizedGrantTypes = new ArrayList<String>();
		authorizedGrantTypes.add("password");
		authorizedGrantTypes.add("refresh_token");
		authorizedGrantTypes.add("client_credentials");
		return authorizedGrantTypes;
	}
}
