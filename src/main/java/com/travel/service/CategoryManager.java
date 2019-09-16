package com.travel.service;

import java.util.List;

import com.travel.model.Category;

public interface CategoryManager {
    public List<Category> getAllCategories();

    public Category getCategoryById(int cid);

    public int addCategory(String cname);

    public int updateCategoryById(int cid, String cname);

    public int deleteCategoryById(int cid);
}

