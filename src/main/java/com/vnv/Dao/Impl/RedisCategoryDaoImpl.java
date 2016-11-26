package com.vnv.Dao.Impl;

import com.vnv.Dao.CategoryDao;
import com.vnv.Entity.Category;
import com.vnv.Model.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import redis.clients.johm.JOhm;

import java.util.Collection;
import java.util.List;

@Repository
@Qualifier("redis")
@Profile("prod")
public class RedisCategoryDaoImpl implements CategoryDao {

    @Autowired
    Database db;

    @Override
    public Category insertCategory(Category category) {
        return JOhm.save(category);
    }

        @Override
    public Collection<Category> getAllCategories() {
        return JOhm.getAll(Category.class);
    }

    @Override
    public Category getCategoryByName(String name) {
        List<Category> categories = JOhm.find(Category.class, "name", name);
        if (categories.isEmpty())
            return null;
        return categories.get(0);
    }
}
