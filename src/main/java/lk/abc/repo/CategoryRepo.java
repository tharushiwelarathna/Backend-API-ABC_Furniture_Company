package lk.abc.repo;

import lk.abc.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
public interface CategoryRepo  extends JpaRepository<Category,String> {
    ArrayList<Category> findCategoryByCategoryTypeAndStatus(String type, String status);
    ArrayList<Category> findCategoryByCategoryAndStatus(String category,String status);
    ArrayList<Category> findCategoryByStatus(String status);
}
