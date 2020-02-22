package demo.service;

import demo.entity.AuthorEntity;

public interface AuthorService {
    //根据_id寻找对应的Author
    AuthorEntity findAuthorById(String _id);
}
