package com.codingshuffle.jpaTutorial.jpaTuts;

import com.codingshuffle.jpaTutorial.jpaTuts.entities.ProductEntity;
import com.codingshuffle.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialApplicationTests {

    @Autowired
    ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

    @Test
    void testRepository(){
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle234")
                .title("Nestle Chocolate")
                .price(BigDecimal.valueOf(23.45))
                .quantity(4)
                .build();

        ProductEntity savedProductEntity = productRepository.save(productEntity);
        System.out.println(savedProductEntity);

    }

    @Test
    void getRepository() {
//        List<ProductEntity> entities = productRepository
//                .findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));

       // List<ProductEntity> entities = productRepository.findByQuantityAndPrice(4, BigDecimal.valueOf(23.45));
       // List<ProductEntity> entities = productRepository.findByQuantityGreaterThanOrPriceLessThan(4, BigDecimal.valueOf(23.45));
        // List<ProductEntity> entities = productRepository.findByTitleLike("%Choco%");
      //  List<ProductEntity> entities = productRepository.findByTitleContaining("Choco");
        List<ProductEntity> entities = productRepository.findByTitleContainingIgnoreCase("CHOco");
        System.out.println(entities);
    }

    @Test
    void getSingleFromRepository() {
        Optional<ProductEntity> productEntity = productRepository
                .findByTitleAndPrice("pepsi", BigDecimal.valueOf(14.4));

        productEntity.ifPresent(System.out::println);
    }

    @Test
    void usingKeywords(){
       // List<ProductEntity> entities = productRepository.findByCreatedAtBefore(LocalDateTime.of(2024,1,1,0,0,0));
     //   List<ProductEntity> entities = productRepository.findBypriceBetween(20.0,25.1);
      //  List<ProductEntity> entities = productRepository.findBytitleEndingWith("late");

        System.out.println(entities);
    }



}
