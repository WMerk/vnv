package com.vnv.dao;


import com.vnv.entity.Category;

import java.util.Collection;

public interface CategoryDao {

    public Category insertCategory(Category category);
    public Collection<Category> getAllCategories();
    public Category getCategoryByName(String name);

}
