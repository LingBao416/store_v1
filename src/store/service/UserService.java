package store.service;

import store.domain.User;

public interface UserService {
    void userRegist(User user) throws Exception;

    User userLogin(User user) throws Exception;
}
