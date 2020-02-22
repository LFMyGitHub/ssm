package demo.service.impl;

import demo.dao.UserDao;
import demo.entity.UserEntity;
import demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public int registered(UserEntity userEntity) {
        return  userDao.registered(userEntity);
    }

    @Override
    public UserEntity selectUser(UserEntity userEntity) {
        return userDao.selectUser(userEntity);
    }
}
