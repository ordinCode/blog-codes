package blog.ordincode.controller;

import blog.ordincode.domain.bothway.ImageBothWay;
import blog.ordincode.domain.bothway.ProductBothWay;
import blog.ordincode.domain.embed.ImageEm;
import blog.ordincode.domain.embed.ProductEm;
import blog.ordincode.domain.oneway.ImageOneWay;
import blog.ordincode.domain.oneway.ProductOneWay;
import blog.ordincode.repository.ImageBothWayRepository;
import blog.ordincode.repository.ProductBothWayRepository;
import blog.ordincode.repository.ProductEmRepository;
import blog.ordincode.repository.ProductOneWayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DataController {
    @Autowired
    private ProductEmRepository productEmRepository;

    @Autowired
    private ProductOneWayRepository productOneWayRepository;

    @Autowired
    private ProductBothWayRepository productBothWayRepository;

    @Autowired
    private ImageBothWayRepository imageBothWayRepository;

    @GetMapping("/insert/embed")
    public String insertEmbeddable() {
        System.out.println("--------insertEmbeddable--------");
        ProductEm product = getProductEm("newProduct1");
        ProductEm product2 = getProductEm("newProduct2");
        ProductEm product3 = getProductEm("newProduct3");

        productEmRepository.saveAll(Arrays.asList(product, product2, product3));
        return "ok";
    }

    private ProductEm getProductEm(String productName) {
        List<ImageEm> images = Arrays.asList(
                new ImageEm("image1"),
                new ImageEm("image2"),
                new ImageEm("image3"),
                new ImageEm("image4")
        );
        return new ProductEm(productName, images);
    }

    @GetMapping("/insert/oneway")
    public String insertOneWay() {
        System.out.println("--------insertOneWay--------");
        ProductOneWay product = getProductOneWay("productOneWay1");
        ProductOneWay product2 = getProductOneWay("productOneWay2");
        ProductOneWay product3 = getProductOneWay("productOneWay3");
        productOneWayRepository.saveAll(Arrays.asList(product, product2, product3));
        return "ok";
    }

    private ProductOneWay getProductOneWay(String productName) {
        List<ImageOneWay> images = Arrays.asList(
                new ImageOneWay("image1"),
                new ImageOneWay("image2"),
                new ImageOneWay("image3"),
                new ImageOneWay("image4")
        );
        return new ProductOneWay(productName, images);
    }

    @GetMapping("/insert/bothway")
    public String insertBothWay() {
        System.out.println("--------insertBothWay--------");
        ProductBothWay product = getProductBothWay("newProduct");
        ProductBothWay product2 = getProductBothWay("newProduct2");
        ProductBothWay product3 = getProductBothWay("newProduct3");
        productBothWayRepository.saveAll(Arrays.asList(product, product2, product3));
        return "ok";
    }

    private ProductBothWay getProductBothWay(String newProduct) {
        ProductBothWay product = new ProductBothWay(newProduct, new ArrayList<>());
        product.addImage(new ImageBothWay("image1"));
        product.addImage(new ImageBothWay("image2"));
        product.addImage(new ImageBothWay("image3"));
        product.addImage(new ImageBothWay("image4"));
        return product;
    }

    @DeleteMapping("/delete/embed")
    public String deleteEmbed() {
        System.out.println("--------deleteEmbed--------");
        productEmRepository.deleteAll(productEmRepository.findAll());
        return "ok";
    }

    @DeleteMapping("/delete/oneway")
    public String deleteOneway() {
        System.out.println("--------deleteOneway--------");
        productOneWayRepository.deleteAll(productOneWayRepository.findAll());
        return "ok";
    }

    @DeleteMapping("/delete/bothway")
    public String deleteBothway() {
        System.out.println("--------deleteBothway--------");
        productBothWayRepository.deleteAll(productBothWayRepository.findAll());
        return "ok";
    }

    @DeleteMapping("/delete/bothway-fetch")
    public String deleteBothwayFetch() {
        System.out.println("--------deleteBothway fetch & deleteInIds--------");
        List<ProductBothWay> allFetch = productBothWayRepository.findAllFetch();
        List<Long> productIds = allFetch.stream()
                .mapToLong(ProductBothWay::getProductId)
                .distinct()
                .boxed().collect(Collectors.toList());
        List<Long> imageIds = allFetch.stream()
                .map(ProductBothWay::getImages)
                .flatMap(Collection::stream)
                .mapToLong(ImageBothWay::getImageId)
                .distinct()
                .boxed().collect(Collectors.toList());
        imageBothWayRepository.deleteAllByIdInQuery(imageIds);
        productBothWayRepository.deleteAllByIdInQuery(productIds);
        return "ok";
    }
}
