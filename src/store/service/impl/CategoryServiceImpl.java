package store.service.impl;

import store.dao.CategoryDao;
import store.dao.impl.CategoryDaoImpl;
import store.domain.Category;
import store.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<Category> findAll() throws Exception{
        CategoryDao categoryDao = new CategoryDaoImpl();
        return categoryDao.findAll();

    }
}
