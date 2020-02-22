package demo.service;

import demo.entity.Author;

public interface AuthorService {
    //根据_id寻找对应的Author
    public Author findAuthorById(String _id);
}
