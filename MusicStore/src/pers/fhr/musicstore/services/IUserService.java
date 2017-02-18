package pers.fhr.musicstore.services;

public interface IUserService {
	String findUser(String userName,String password);
	boolean insertUser(String userName,String password); 
}
