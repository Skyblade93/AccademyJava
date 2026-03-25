package it.corso.AccademiJava.Service;

import it.corso.AccademiJava.DTO.ProductDto;
import it.corso.AccademiJava.Mapper.Converter;
import it.corso.AccademiJava.Mapper.ProductMapper;
import it.corso.AccademiJava.Model.Product;
import it.corso.AccademiJava.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractService<Product, ProductDto> {

    @Autowired
    private final  ProductMapper productMapper;

    @Autowired
    private final  ProductRepository productRepository;

    protected ProductService(JpaRepository<Product, Integer> repository, Converter<Product, ProductDto> converter, ProductMapper productMapper, ProductRepository productRepository) {
        super(repository, converter);
        this.productMapper = productMapper;
        this.productRepository = productRepository;
    }


    public ProductDto findByName(String name){
        return productMapper.toDTO(productRepository.findByName(name));
    }

    public List<ProductDto> findByCategory(String category){
        return productMapper.toDTOList(productRepository.findByCategory(category));
    }

    public List<ProductDto> findByPriceGreaterThan(Double price){
        return productMapper.toDTOList(productRepository.findByPriceGreaterThan(price));
    }

    public List<ProductDto> findByQuantityLessThan(Integer quantity){
        return productMapper.toDTOList(productRepository.findByQuantityLessThan(quantity));
    }


    // JPQL

    public ProductDto findByNameCustom(String name){
        return productMapper.toDTO(productRepository.findByNameCustom(name));
    }

    public List<ProductDto> findByPriceRange(Double min, Double max){
        return productMapper.toDTOList(productRepository.findByPriceRange(min, max));
    }

    public List<ProductDto> searchByCategory(String keyword){
        return productMapper.toDTOList(productRepository.searchByCategory(keyword));
    }


    // Native

    public ProductDto nativeFindByName(String name){
        return productMapper.toDTO(productRepository.nativeFindByName(name));
    }

    public List<ProductDto> nativeFindExpensive(Double price){
        return productMapper.toDTOList(productRepository.nativeFindExpensive(price));
    }

    public List<ProductDto> findOutOfStock(){
        return productMapper.toDTOList(productRepository.findOutOfStock());
    }
}