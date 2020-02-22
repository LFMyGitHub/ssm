import demo.dao.AuthorDao;
import demo.entity.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class AuthorDaoTest {
    @Autowired
    private AuthorDao authorDao;

    @Test
    public void testFindUserById() {
        String id = "测试8";
        Author author = authorDao.findAuthorById(id);
        System.out.println(author.get_id() + ":" + author.getHeadImageUrl());
    }
}
