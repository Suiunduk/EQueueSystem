package kg.inai.equeuesystem.services.servicesImpl;

import kg.inai.equeuesystem.entities.Category;
import kg.inai.equeuesystem.exeptions.RecordNotFoundException;
import kg.inai.equeuesystem.models.CategoryModel;
import kg.inai.equeuesystem.repositories.CategoryRepository;
import kg.inai.equeuesystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category create(CategoryModel categoryModel) {
        Category category = Category.builder()
                .name(categoryModel.getName())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category update(CategoryModel categoryModel) {
        return categoryRepository.findById(categoryModel.getId())
                .map(newCategory -> {
                    newCategory.setName(categoryModel.getName());
                    return categoryRepository.save(newCategory);
                }).orElseThrow(() -> new RecordNotFoundException("Record not found with id: " + categoryModel.getId()));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryRepository.findById(id).get();
    }
}
