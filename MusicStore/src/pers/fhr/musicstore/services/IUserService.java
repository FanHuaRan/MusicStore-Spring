package pers.fhr.musicstore.services;

public interface IUserService {
	String findUserRole(String userName,String password);
	String findUserPassword(String userName);
	boolean insertUser(String userName, String password, String role); 
}
