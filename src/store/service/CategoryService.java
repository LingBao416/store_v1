package store.service;

import store.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll() throws Exception;
}
