package lk.abc.controller;

import lk.abc.dto.CategoryDTO;
import lk.abc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveCategory(@RequestBody CategoryDTO dto) {
        boolean flag = service.addCategory(dto);
        System.out.println(flag + " category saved");
        return flag;
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteCategory(@RequestBody CategoryDTO dto) {
        System.out.println(dto.getCategoryID());
        boolean flag = service.deleteCategory(dto.getCategoryID());
        System.out.println( " category deleted");
        return flag;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateCategory(@RequestBody CategoryDTO dto) {
        boolean flag = service.updateCategory(dto);
        System.out.println(" category updated");
        return flag;
    }

    @GetMapping(params = {"id"} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public CategoryDTO searchCategory(@RequestParam String id) {
        CategoryDTO categoryDTO = service.searchCategory(id);
        System.out.println(categoryDTO.toString());
        return categoryDTO;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<CategoryDTO> getAllCategory() {
        ArrayList<CategoryDTO> allCategory = service.getAllCategory();
        for (CategoryDTO allCate : allCategory) {
            System.out.println(allCate.toString());
        }
        return allCategory;
    }
    @GetMapping(params = {"type","status"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CategoryDTO>  searchCategoryByType(String type,String status ){
        ArrayList<CategoryDTO> categoryByType = service.findCategoryByType(type,status);
        for (CategoryDTO categoryDTO : categoryByType) {
            System.out.println(categoryDTO.toString());
        }
        return categoryByType;
    }
    @GetMapping(params = {"category","status"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CategoryDTO>  searchCategoryByCategory(String category,String status){
        ArrayList<CategoryDTO> categoryByCategory= service.findCategoryByCategory(category,status);
        for (CategoryDTO categoryDTO : categoryByCategory) {
            System.out.println(categoryDTO.toString());
        }
        return categoryByCategory;
    }

    @GetMapping(params = {"status"} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<CategoryDTO>  searchCategoryByAvailability(String status){
        ArrayList<CategoryDTO> categoryByStatus = service.findCategoryByStatus(status);
        for (CategoryDTO categoryDTO : categoryByStatus) {
            System.out.println(categoryDTO.toString());
        }
        return categoryByStatus;
    }

}
