package lt.web.demo.services;

import lt.web.demo.controller.CategoriesNotFoundException;
import lt.web.demo.entities.Categories;
import lt.web.demo.repositories.CategoriesRepository;
import lt.web.demo.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesService {

    private CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    public Categories getCategories(Long id) {
        return categoriesRepository.findById(id)
                .orElseThrow(() -> new CategoriesNotFoundException("Category was not found"));
    }

    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }
}
