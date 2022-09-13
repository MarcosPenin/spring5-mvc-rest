package guru.springfamework.services;

import guru.springfamework.domain.Category;

import java.util.List;



public interface CategoryService {

    List<Category> getAllCategories();
    Category getCategoryByName(String name);
}
