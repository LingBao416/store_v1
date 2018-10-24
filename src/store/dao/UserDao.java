package store.dao;

import store.domain.User;

public interface UserDao {
    void userRegist(User user) throws Exception;

    User userLogin(User user) throws  Exception;
}
