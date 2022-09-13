package guru.springfamework.services;

import guru.springfamework.domain.Category;
import guru.springfamework.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public Category getCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }
}
