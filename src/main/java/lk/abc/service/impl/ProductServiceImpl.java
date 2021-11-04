package lk.abc.service.impl;

import lk.abc.dto.ProductDTO;
import lk.abc.entity.Product;
import lk.abc.repo.ProductRepo;
import lk.abc.service.ProductService;
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
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public boolean addProduct(ProductDTO dto) {
        if (productRepo.existsById(dto.getProductID())) {
            return false;
        }
        productRepo.save(mapper.map(dto, Product.class));
        return true;
    }

    @Override
    public boolean deleteProduct(String productID) {
        if (!productRepo.existsById(productID)) {
            return false;
        }
        productRepo.deleteById(productID);
        return true;
    }

    @Override
    public boolean updateProduct(ProductDTO dto) {
        if (!productRepo.existsById(dto.getProductID())){
            return false;
        }
        productRepo.save(mapper.map(dto, Product.class));
        return true;
    }

    @Override
    public ProductDTO searchProduct(String productID) {
        Optional<Product> product = productRepo.findById(productID);
        if (product.isPresent()){
            return mapper.map(product.get(), ProductDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<ProductDTO> getAllProducts() {
        List<Product> all = productRepo.findAll();
        return mapper.map(all, new TypeToken<ArrayList<ProductDTO>>(){}.getType());
    }

    @Override
    public ArrayList<ProductDTO> findProductByCategory(String category, String status) {
        ArrayList<Product> products = productRepo.findProductByCategoryAndStatus(category,status);
        return mapper.map(products,new TypeToken<ArrayList<ProductDTO>>(){}.getType());
    }

    @Override
    public ArrayList<ProductDTO> findProductByStatus(String status) {
        ArrayList<Product> products = productRepo.findProductByStatus(status);
        return mapper.map(products,new TypeToken<ArrayList<ProductDTO>>(){}.getType());
    }
}
