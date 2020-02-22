import demo.dao.AuthorDao;
import demo.dao.UserDao;
import demo.entity.AuthorEntity;
import demo.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class AuthorEntityDaoTest {
    @Autowired
    private AuthorDao authorDao;
    @Autowired
    private UserDao userDao;

    @Test
    public void testFindUserById() {
        String id = "测试8";
        AuthorEntity authorEntity = authorDao.findAuthorById(id);
        System.out.println(authorEntity.get_id() + ":" + authorEntity.getHeadImageUrl());
    }

    @Test
    public void selectUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("测试");
        UserEntity usss = userDao.selectUser(userEntity);
        System.out.println(usss.getPassword());
    }

    @Test
    public void registered() {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername("测试");
        userEntity.setPassword("sdasdasd");
        userDao.registered(userEntity);
    }
}
