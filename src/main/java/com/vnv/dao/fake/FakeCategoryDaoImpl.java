package com.vnv.dao.fake;

import com.vnv.dao.CategoryDao;
import com.vnv.entity.Category;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
@Profile("debug")
public class FakeCategoryDaoImpl implements CategoryDao {

    public static Map<Long, Category> categories = new HashMap<Long, Category>();
    private static long id = 1;

    @Override
    public Category insertCategory(Category category) {
        category.setId(id);
        id++;
        categories.put(category.getId(), category);
        return categories.get(category.getId());
    }

    @Override
    public Collection<Category> getAllCategories() {
        return categories.values();
    }

    @Override
    public Category getCategoryByName(String name) {
        for (int i=1; i<id; i++) {
            Category c= categories.get(i);
            if (c!= null && c.getName().equals(name))
                return c;
        }
        return null;
    }
}
