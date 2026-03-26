package it.corso.AccademiJava.Repository;

import it.corso.AccademiJava.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {



    Product findByName(String name);

  //  List<Product> findByCategory(String category);

    List<Product> findByPriceGreaterThan(Double price);

    List<Product> findByQuantityLessThan(Integer quantity);


    // JPQL

    @Query("SELECT p FROM Product p WHERE p.name = ?1")
    Product findByNameCustom(String name);

    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findByPriceRange(Double min, Double max);
/*
    @Query("SELECT p FROM Product p WHERE p.category LIKE %?1%")
    List<Product> searchByCategory(String keyword);
*/

    // Native

    @Query(value = "SELECT * FROM Product p WHERE p.name = ?1", nativeQuery = true)
    Product nativeFindByName(String name);

    @Query(value = "SELECT * FROM Product p WHERE p.price > ?1", nativeQuery = true)
    List<Product> nativeFindExpensive(Double price);

    @Query(value = "SELECT * FROM Product p WHERE p.quantity = 0", nativeQuery = true)
    List<Product> findOutOfStock();
}