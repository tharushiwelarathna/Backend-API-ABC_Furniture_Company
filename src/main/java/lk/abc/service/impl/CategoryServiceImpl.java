package lk.abc.service.impl;

import lk.abc.dto.CategoryDTO;
import lk.abc.entity.Category;
import lk.abc.repo.CategoryRepo;
import lk.abc.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@Service
@Transactional
public class CategoryServiceImpl  implements CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public boolean addCategory(CategoryDTO dto) {
        if (categoryRepo.existsById(dto.getCategoryID())) {
            return false;
        }
        categoryRepo.save(mapper.map(dto, Category.class));
        return true;
    }

    @Override
    public boolean deleteCategory(String categoryID) {
        if (!categoryRepo.existsById(categoryID)) {
            return false;
        }
        categoryRepo.deleteById(categoryID);
        return true;
    }

    @Override
    public boolean updateCategory(CategoryDTO dto) {
        if (!categoryRepo.existsById(dto.getCategoryID())){
            return false;
        }
        categoryRepo.save(mapper.map(dto, Category.class));
        return true;
    }

    @Override
    public CategoryDTO searchCategory(String categoryID) {
        Optional<Category> category = categoryRepo.findById(categoryID);
        if (category.isPresent()){
            return mapper.map(category.get(), CategoryDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CategoryDTO> getAllCategory() {
        List<Category> all = categoryRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<CategoryDTO>>(){}.getType());
    }

    @Override
    public ArrayList<CategoryDTO> findCategoryByType(String type, String status) {
        ArrayList<Category> categorys = categoryRepo.findCategoryByCategoryTypeAndStatus(type,status);
        return mapper.map(categorys,new TypeToken<ArrayList<CategoryDTO>>(){}.getType());
    }

    @Override
    public ArrayList<CategoryDTO> findCategoryByCategory(String category, String status) {
        ArrayList<Category> categorys = categoryRepo.findCategoryByCategoryAndStatus(category,status);
        return mapper.map(categorys,new TypeToken<ArrayList<CategoryDTO>>(){}.getType());
    }

    @Override
    public ArrayList<CategoryDTO> findCategoryByStatus(String status) {
        ArrayList<Category> categorys = categoryRepo.findCategoryByStatus(status);
        return mapper.map(categorys,new TypeToken<ArrayList<CategoryDTO>>(){}.getType());
    }
}
