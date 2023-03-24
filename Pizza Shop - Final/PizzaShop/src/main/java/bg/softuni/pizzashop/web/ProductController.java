package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.ProductAddBindingModel;
import bg.softuni.pizzashop.model.binding.ProductIngredientsAddBindingModel;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.service.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ModelMapper modelMapper;
    private final ProductService productService;

    public ProductController(ModelMapper modelMapper, ProductService productService) {
        this.modelMapper = modelMapper;
        this.productService = productService;
    }

    @GetMapping("/add")
    public String addProduct() {
        return "add-product";
    }

    @GetMapping("/add/ingredients/{id}")
    public String addProductIngredients(@PathVariable Long id, Model model) {

        model.addAttribute("product", productService.findProductById(id));
        return "add-product-ingredients";
    }

    @PostMapping("/add")
    public String addProductConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:/product/add";
        }

        productService.saveProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        Long productId = productService.findLastAddedProduct().getId();


        return "redirect:/product/add/ingredients/" + productId;
    }

    @PostMapping("/add/ingredients")
    public String addProductIngredientsConfirm(@Valid ProductIngredientsAddBindingModel productIngredientsAddBindingModel,
                                               BindingResult bindingResult,
                                               RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productIngredientsAddBindingModel", productIngredientsAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productIngredientsAddBindingModel", bindingResult);

            return "redirect:/product/add/ingredients";
        }

        productService.findProductById()


        productService.saveProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));
        return "redirect:/";
    }

    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }

    @ModelAttribute
    public Integer ingredientCount(Integer count) {
        Integer ingredientsCount = count;
        return count;
    }

    @ModelAttribute
    public ProductIngredientsAddBindingModel productIngredientsAddBindingModel() {
        return new ProductIngredientsAddBindingModel();
    }
}
