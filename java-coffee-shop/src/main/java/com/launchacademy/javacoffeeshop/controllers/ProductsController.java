package com.launchacademy.javacoffeeshop.controllers;

import com.launchacademy.javacoffeeshop.models.Product;
import com.launchacademy.javacoffeeshop.services.ProductSessionRelatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductSessionRelatedService productSessionRelatedService;

    @Autowired
    public ProductsController(ProductSessionRelatedService productSessionRelatedService) {
        this.productSessionRelatedService = productSessionRelatedService;
    }

    @GetMapping
    public String getProduct(Model model) {
        List<Product> products = productSessionRelatedService.findAll();
        model.addAttribute("products", products);
        return "products/index";
    }

    @GetMapping("/show/{id}")
    public String showProduct(@PathVariable Integer id, Model model) {
        Product product = productSessionRelatedService.get(id);
        model.addAttribute("product", product);
        return "products/show";
    }

    @PostMapping
    @RequestMapping(value="/products/show/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id ) {
        List<Product> products = productSessionRelatedService.findAll();
        Product thisProduct = null;
        for(Product eachProduct : products) {
            if(eachProduct.getId().equals(id)) {
                thisProduct = eachProduct;
            }
        }
            productSessionRelatedService.removeFromList(thisProduct);
        return "redirect:/products";
    }

    @GetMapping("/new")
    public String getNewForm(@ModelAttribute Product product, Model model) {
        model.addAttribute("productSessionRelatedService", productSessionRelatedService);
        return "products/form";
    }

    @PostMapping
    public String createProduct(@ModelAttribute Product product) {
        int nextAvailableID = productSessionRelatedService.findAll().size() + 1;
        product.setId(nextAvailableID);
        productSessionRelatedService.addToList(product);
        return "redirect:/products";
    }
}
