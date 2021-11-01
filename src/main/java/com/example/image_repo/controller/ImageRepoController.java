package com.example.image_repo.controller;

import com.example.image_repo.models.Image;
import com.example.image_repo.service.ImageService;
import com.example.image_repo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
@RequestMapping(value = "/images")
public class ImageRepoController {
    public static final String IMAGE_DOES_NOT_EXIST_ERROR_MESSAGE = "This image does not exist in the database.";

    private ImageService imageService;
    private UserService userService;

    @Autowired
    public ImageRepoController(final ImageService imageService, final UserService userService){
        this.userService = userService;
        this.imageService = imageService;
    }


    @GetMapping("permissionOnly")
    public List<Image> getPublicImages(@RequestParam(required = false, defaultValue = "false") final boolean isPublic){
        if (isPublic) return imageService.getAllAccessedImage();
        else return getAllImage();
    }

    @GetMapping()
    public List<Image> getAllImage(){
        return imageService.getAllImage();
    }

    @GetMapping(params = "imageTitle")
    public List<Image> getImageByTitle(@RequestParam(required = false) final String imageTitle){
        // todo: check if the string is null or blank string
        return imageService.getImagesByTitle(imageTitle);
    }

    @GetMapping("{imageId}")
    public Image viewImage(@PathVariable final UUID imageId){
        Optional<Image> image = imageService.ViewImage(imageId);
        if (!image.isPresent()) throw new IllegalArgumentException(IMAGE_DOES_NOT_EXIST_ERROR_MESSAGE);
        return image.get();
    }
//    @GetMapping("{imageTag}")
//    public Image viewImageByTag(@PathVariable final UUID imageId){
//
//    }

//    @PostMapping
//    public Image createImage(@RequestBody(required = false) Image){
//
//    }
//
//    @PostMapping
//    public Cart createCart(@RequestBody(requsired = false) CreateCart createCart) {
//        if (Objects.isNull(createCart)) return cartService.createNewCart();
//
//        List<Product> productsInCart = createCart.getProductIds()
//                .stream()
//                .map(productService::getProductById)
//                .filter(Optional::isPresent) // Filter out all products that do not exist
//                .map(Optional::get)
//                .filter(Product::inStock) // Filter out all products that are not in-stock
//                .collect(Collectors.toList());
//
//        return cartService.createNewCart(productsInCart);
//    }
//
//    @PutMapping("{cartId}/products/{productId}")
//    public Cart addProductToCart(@PathVariable final Integer cartId, @PathVariable final Integer productId) {
//        final Optional<Product> productToAdd = productService.getProductById(productId);
//        if (!productToAdd.isPresent()) throw new IllegalArgumentException(ProductsController.PRODUCT_DOES_NOT_EXIST_ERROR_MESSAGE);
//        if (!productToAdd.get().inStock()) throw new IllegalArgumentException(Product.STOCK_RUN_OUT_EXCEPTION_MESSAGE);
//
//        return cartService.addNewProductsToCart(cartId, productToAdd.get());
//    }
//
//    @PutMapping("{cartId}/complete")
//    public void completePurchase(@PathVariable final Integer cartId) {
//        cartService.completeCartPurchase(cartId);
//    }
}