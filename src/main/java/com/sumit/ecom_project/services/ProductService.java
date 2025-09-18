package com.sumit.ecom_project.services;

import com.sumit.ecom_project.model.Product;
import com.sumit.ecom_project.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;


    public List<Product> getAllProduct() {
        return repo.findAll();
    }

    public Product getProductById(int prodId) {
        return repo.findById(prodId).orElse(null);
    }

    public Product addProduct(Product product, MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
       return repo.save(product);
    }

    public Product updateProduct(int id, Product product, MultipartFile imageFile) throws IOException {
        return repo.findById(id).map(exist ->{
           exist.setName(product.getName());
           exist.setDescription(product.getDescription());
           exist.setBrand(product.getBrand());
           exist.setPrice(product.getPrice());
           exist.setCategory(product.getCategory());
           exist.setReleaseDate(product.getReleaseDate());
           exist.setProductAvailable(product.isProductAvailable());
           exist.setStockQuantity(product.getStockQuantity());

               if (imageFile != null && !imageFile.isEmpty()) {
                   try {
                       exist.setImageData(imageFile.getBytes());
                       exist.setImageName(imageFile.getOriginalFilename()); // fixed
                       exist.setImageType(imageFile.getContentType());
                   } catch (IOException e) {
                       throw new RuntimeException("Error reading image file", e);
                   }
               }
           return repo.save(exist);
        }).orElse(null);

    }


    public boolean deleteProduct(int id) {
       if(repo.existsById(id)){
           repo.deleteById(id);
       }
        return false;
    }

    public List<Product> searchProducts(String keyword) {
        return repo.searchProducts(keyword);
    }
}
