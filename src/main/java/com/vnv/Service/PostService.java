package com.vnv.Service;

import com.vnv.Dao.PostDao;
import com.vnv.Entity.Post;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private static Logger log = LoggerFactory.getLogger(PostService.class);

    @Autowired
    PostDao postDao;

    public JSONObject insertPost(Post post) {
        log.debug("Inserting post {} to database", post);
        return postDao.insertPost(post).toJSON();
    }


}
