package lk.abc.service;

import lk.abc.dto.ProductDTO;

import java.util.ArrayList;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
public interface ProductService {

    boolean addProduct(ProductDTO dto);
    boolean deleteProduct(String productID);
    boolean updateProduct(ProductDTO dto);
    ProductDTO searchProduct(String productID);
    ArrayList<ProductDTO> getAllProducts();
    ArrayList<ProductDTO> findProductByCategory(String category,String status);
    ArrayList<ProductDTO> findProductByStatus(String status);
}
