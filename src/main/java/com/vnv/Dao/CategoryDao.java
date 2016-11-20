package com.vnv.Dao;


import com.vnv.Entity.Category;

import java.util.Collection;

public interface CategoryDao {

    public Category insertCategory(Category category);
    public Collection<Category> getAllCategories();
    public Category getCategoryByName(String name);

}
