package com.vnv.Service;

import com.vnv.Dao.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    PostDao postDao;

    
}
