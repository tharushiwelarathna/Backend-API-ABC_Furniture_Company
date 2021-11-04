package lk.abc.service;

import lk.abc.dto.CategoryDTO;

import java.util.ArrayList;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
public interface CategoryService {
    boolean addCategory(CategoryDTO dto);
    boolean deleteCategory(String categoryID);
    boolean updateCategory(CategoryDTO dto);
    CategoryDTO searchCategory(String categoryID);
    ArrayList<CategoryDTO> getAllCategory();
    ArrayList<CategoryDTO> findCategoryByType(String type,String status);
    ArrayList<CategoryDTO> findCategoryByCategory(String category,String status);
    ArrayList<CategoryDTO> findCategoryByStatus(String status);

}
