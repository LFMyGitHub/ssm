package demo.service.impl;

import demo.dao.AuthorDao;
import demo.entity.AuthorEntity;
import demo.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {
    @Resource
    private AuthorDao authorDao;

    @Override
    public AuthorEntity findAuthorById(String _id) {
        return authorDao.findAuthorById(_id);
    }
}
