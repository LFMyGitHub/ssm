package demo.dao;

import demo.entity.AuthorEntity;

public interface AuthorDao {
    //根据_id寻找对应的Author
    AuthorEntity findAuthorById(String _id);
}
