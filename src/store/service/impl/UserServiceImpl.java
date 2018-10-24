package store.service.impl;

import store.dao.UserDao;
import store.dao.impl.UserDaoImpl;
import store.domain.User;
import store.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void userRegist(User user) throws Exception{
        UserDao userDao = new UserDaoImpl();
        userDao.userRegist(user);
    }

    @Override
    public User userLogin(User user) throws Exception {
        UserDao userDao = new UserDaoImpl();
        User user01 = userDao.userLogin(user);

        if(null==user01){
            throw new RuntimeException("密码有误！");
        }else if (user01.getState() == 0){
            throw new RuntimeException("用户未激活");
        }else{
            return user01;
        }
    }
}
