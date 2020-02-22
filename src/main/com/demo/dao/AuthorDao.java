package demo.dao;

import demo.entity.Author;

public interface AuthorDao {
    //根据_id寻找对应的Author
    Author findAuthorById(String _id);
}
