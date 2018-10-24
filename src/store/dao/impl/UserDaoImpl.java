package store.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import store.dao.UserDao;
import store.domain.User;
import store.utils.JDBCUtils;

public class UserDaoImpl implements UserDao {
    @Override
    public void userRegist(User user)throws Exception {
        String sql = "";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        Object[] params = {user.getUid(),
                user.getUsername(),
                user.getPassword(),
                user.getName(),
                user.getEmail(),
                user.getEmail(),
                user.getTelephone(),
                user.getCode(),
                user.getSex(),
                user.getState(),
                user.getCode()
        };
        queryRunner.update(sql,params);
    }

    @Override
    public User userLogin(User user) throws Exception {
        String sql = "select * from user where username= ? and password= ?";
        QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
        return  queryRunner.query(sql,new BeanHandler<>(User.class),user.getUsername(),user.getPassword());

    }
}
