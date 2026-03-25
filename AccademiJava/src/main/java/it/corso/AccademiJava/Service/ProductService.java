package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.ProductDto;
import it.corso.AccademiJava.Mapper.ProductMapper;
import it.corso.AccademiJava.Model.Product;
import it.corso.AccademiJava.Repository.ProductRepository;
import it.corso.AccademiJava.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractService<Product, ProductDto> {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository,
                          ProductMapper productMapper,
                          UserRepository userRepository) {

        super(productRepository, productMapper);
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.productMapper = productMapper;
    }

    public ProductDto findByName(String name){
        Product product = productRepository.findByName(name);
        return productMapper.toDTO(product);
    }

    public List<ProductDto> findByCategory(String category){
        List<Product> products = productRepository.findByCategory(category);
        return productMapper.toDTOList(products);
    }

    public List<ProductDto> findByPriceGreaterThan(Double price){
        return productMapper.toDTOList(
                productRepository.findByPriceGreaterThan(price)
        );
    }

    public List<ProductDto> findByQuantityLessThan(Integer quantity){
        return productMapper.toDTOList(
                productRepository.findByQuantityLessThan(quantity)
        );
    }

    // ------------------ JPQL ------------------

    public ProductDto findByNameCustom(String name){
        return productMapper.toDTO(
                productRepository.findByNameCustom(name)
        );
    }

    public List<ProductDto> findByPriceRange(Double min, Double max){
        return productMapper.toDTOList(
                productRepository.findByPriceRange(min, max)
        );
    }

    public List<ProductDto> searchByCategory(String keyword){
        return productMapper.toDTOList(
                productRepository.searchByCategory(keyword)
        );
    }

    // ------------------ NATIVE ------------------

    public ProductDto nativeFindByName(String name){
        return productMapper.toDTO(
                productRepository.nativeFindByName(name)
        );
    }

    public List<ProductDto> nativeFindExpensive(Double price){
        return productMapper.toDTOList(
                productRepository.nativeFindExpensive(price)
        );
    }

    public List<ProductDto> findOutOfStock(){
        return productMapper.toDTOList(
                productRepository.findOutOfStock()
        );
    }
}