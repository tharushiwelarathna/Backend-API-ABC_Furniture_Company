package lk.abc.repo;

import lk.abc.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
public interface ProductRepo extends JpaRepository<Product,String> {
    ArrayList<Product> findProductByCategoryAndStatus(String category, String status);

    ArrayList<Product> findProductByStatus(String status);
}
