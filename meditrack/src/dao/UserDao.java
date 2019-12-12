package dao;

import model.User;

public interface UserDao {
	public int addUser(User user);
	public int authenticate(String login, String password);
	public User getUser(int userId);
	public void addId(int assId, int id);
	
}
