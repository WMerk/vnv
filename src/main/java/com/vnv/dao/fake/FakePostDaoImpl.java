package com.vnv.dao.fake;

import com.vnv.dao.PostDao;
import com.vnv.entity.Category;
import com.vnv.entity.Post;
import com.vnv.entity.User;
import com.vnv.model.Password;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
@Qualifier("fakeData")
@Profile("debug")
public class FakePostDaoImpl implements PostDao{

    private static Map<Long,Post> posts;
    private static long id = 2;

    private static String[] demoHashPw = Password.hashPassword("test");

    static {
        posts = new HashMap<Long, Post>() {
            {
                put(1L, new Post() {
                    {
                        setId(1L);
                        setUser(new User(){{
                            setUid(1L);
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
                        setStatus("Verfügbar");
                        setPeriod("42.13.1970");
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
        Collection<Post> result = new ArrayList<>();
        long uid = user.getUid();
        for (int i=1; i<id; i++) {
            Post p = getPostById(i);
            if (uid == p.getUser().getUid()) {
                p.setUser(p.getUser().toPublic());
                p.setCreationDate(df.format(new Date(p.getCreationTime())));
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Collection<Post> getOffersForUser(User user) {
        Collection<Post> result = new ArrayList<>();
        long uid = user.getUid();
        for (int i=1; i<id; i++) {
            Post p = getPostById(i);
            if (uid == p.getUser().getUid() && "offer".equals(p.getType())) {
                p.setUser(p.getUser().toPublic());
                p.setCreationDate(df.format(new Date(p.getCreationTime())));
                result.add(p);
            }
        }
        return result;
    }

    @Override
    public Collection<Post> getRequestsForUser(User user) {
        Collection<Post> result = new ArrayList<>();
        long uid = user.getUid();
        for (int i=1; i<id; i++) {
            Post p = getPostById(i);
            if (uid == p.getUser().getUid() && "request".equals(p.getType())) {
                p.setUser(p.getUser().toPublic());
                p.setCreationDate(df.format(new Date(p.getCreationTime())));
                result.add(p);
            }
        }
        return result;
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
