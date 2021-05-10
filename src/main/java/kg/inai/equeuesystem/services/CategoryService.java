package kg.inai.equeuesystem.services;

import kg.inai.equeuesystem.entities.Category;
import kg.inai.equeuesystem.models.CategoryModel;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category create(CategoryModel categoryModel);

    Category update(CategoryModel categoryModel);

    Category getById(Long id);
}
