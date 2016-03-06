package datanucleus.dao;
import datanucleus.dao.ress.User;

public interface UserDAO extends DAO<User>{
    
    boolean login(String username, String password);

}