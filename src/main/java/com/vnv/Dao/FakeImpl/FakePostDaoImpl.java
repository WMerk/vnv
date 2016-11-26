package com.vnv.Dao.FakeImpl;

import com.vnv.Dao.PostDao;
import com.vnv.Entity.Category;
import com.vnv.Entity.Post;
import com.vnv.Entity.User;
import com.vnv.Model.Password;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
@Profile("debug")
public class FakePostDaoImpl implements PostDao{

    public static Map<Long,Post> posts;
    private static long id = 2;

    private static String[] demoHashPw = Password.hashPassword("test");

    static {
        posts = new HashMap<Long, Post>() {
            {
                put(1L, new Post() {
                    {
                        setId(1L);
                        setUser(new User(){{
                            setId(1L);
                            setFirstName("test");
                            setLastName("user");
                            setMail("test@test.de");
                            setTime(0);
                            setHashedPw(demoHashPw[0]);
                            setSalt(demoHashPw[1]);
                        }});
                        setType("offer");
                        setFlavour("verschenken");
                        setCategory(new Category(){{setId(0L);setName("TestCategory");}});
                        setPostName("Test");
                        setDescription("This is a test offer");
                    }
                });


            }
        };
    }

    @Override
    public Post getPostById(long id) {
        return posts.get(id);
    }

    @Override
    public Collection<Post> getAllPosts() {
        return posts.values();
    }

    @Override
    public Collection<Post> getPostsForUser(User user) {
        Collection<Post> posts = Collections.EMPTY_LIST;
        long uid = user.getUid();
        for (int i=1; i<id; i++) {
            Post p = getPostById(i);
            if (uid != p.getUser().getUid()) {
                posts.add(p);
            }
        }
        return posts;
    }

    @Override
    public Collection<Post> getOffersForUser(User user) {
        Collection<Post> posts = Collections.EMPTY_LIST;
        long uid = user.getUid();
        for (int i=1; i<id; i++) {
            Post p = getPostById(i);
            if (uid != p.getUser().getUid() && "offer".equals(p.getType())) {
                posts.add(p);
            }
        }
        return posts;
    }

    @Override
    public Collection<Post> getRequestsForUser(User user) {
        Collection<Post> posts = Collections.EMPTY_LIST;
        long uid = user.getUid();
        for (int i=1; i<id; i++) {
            Post p = getPostById(i);
            if (uid != p.getUser().getUid() && "request".equals(p.getType())) {
                posts.add(p);
            }
        }
        return posts;
    }

    @Override
    public Post insertPost(Post post) {
        post.setId(id);
        id++;
        posts.put(post.getId(), post);
        return getPostById(post.getId());
    }

    @Override
    public Post updatePost(Post post) {
        posts.put(post.getId(), post);
        return getPostById(post.getId());
    }

    @Override
    public boolean deletePost(long id) {
        posts.remove(id);
        return true;
    }
}
