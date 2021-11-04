package lk.abc.controller;

import lk.abc.dto.ProductDTO;
import lk.abc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tharushi Welarathna <nirmanitharushi1@gmail.com>
 * @since 10/25/2021
 */
@CrossOrigin
@RestController
@RequestMapping("api/v1/product")
public class ProductController {
   @Autowired
     private ProductService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveProduct(@RequestBody ProductDTO dto) {
        boolean flag = service.addProduct(dto);
        System.out.println(flag + " product saved");
        return flag;
    }

    @DeleteMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean deleteProduct(@RequestBody ProductDTO dto) {
        System.out.println(dto.getProductID());
        boolean flag = service.deleteProduct(dto.getProductID());
        System.out.println( " product deleted");
        return flag;
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateProduct(@RequestBody ProductDTO dto) {
        boolean flag = service.updateProduct(dto);
        System.out.println(" Product updated");
        return flag;
    }

    @GetMapping(params = {"id"} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO searchProduct(@RequestParam String id) {
        ProductDTO productDTO = service.searchProduct(id);
        System.out.println(productDTO.toString());
        return productDTO;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<ProductDTO> getAllProducts() {
        ArrayList<ProductDTO> allProducts = service.getAllProducts();
        for (ProductDTO allProd : allProducts) {
            System.out.println(allProd.toString());
        }
        return allProducts;
    }
    @GetMapping(params = {"category","status"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ProductDTO>  searchProductByCategory(String category,String status ){
        ArrayList<ProductDTO> productByCategory = service.findProductByCategory(category,status);
        for (ProductDTO productDTO : productByCategory) {
            System.out.println(productDTO.toString());
        }
        return productByCategory;
    }

    @GetMapping(params = {"status"} ,produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrayList<ProductDTO>  searchProductByAvailability(String status){
        ArrayList<ProductDTO> productByStatus = service.findProductByStatus(status);
        for (ProductDTO productDTO : productByStatus) {
            System.out.println(productDTO.toString());
        }
        return productByStatus;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean savePhotos(@RequestPart("photo") MultipartFile photo, @RequestPart("photo2") MultipartFile photo2 ,@RequestPart("photo3") MultipartFile photo3,@RequestPart("photo4") MultipartFile photo4,@RequestPart("photo5") MultipartFile photo5) {
        try {
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            File uploadsDir = new File(projectPath + "/product");
            uploadsDir.mkdir();
            photo.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + photo.getOriginalFilename()));
            photo2.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + photo2.getOriginalFilename()));
            photo3.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + photo3.getOriginalFilename()));
            photo4.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + photo4.getOriginalFilename()));
            photo5.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + photo5.getOriginalFilename()));
            System.out.println(photo.getOriginalFilename());
            System.out.println(photo2.getOriginalFilename());
            System.out.println(photo3.getOriginalFilename());
            System.out.println(photo4.getOriginalFilename());
            System.out.println(photo5.getOriginalFilename());
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


}
