package demo.dao;

import demo.entity.UserEntity;

/**
 * 用户相关操作
 */
public interface UserDao {
    //登录
    //注册
    int registered(UserEntity userEntity);
    //忘记密码
    //发短信修改密码
    //旧密码改新密码
    //用户查询
    UserEntity selectUser(UserEntity userEntity);
}
