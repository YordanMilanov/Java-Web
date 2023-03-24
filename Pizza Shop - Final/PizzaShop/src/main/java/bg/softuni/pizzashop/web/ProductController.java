package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.ProductAddBindingModel;
import bg.softuni.pizzashop.model.service.ProductServiceModel;
import bg.softuni.pizzashop.service.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.HashMap;

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
    public String addProduct(Model model) {
        return "add-product";
    }

    @GetMapping("/add/ingredients")
    public String addProductIngredients() {
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

        return "redirect:/";
    }

    @PostMapping("/add/ingredients")
    public String addProductIngredientsConfirm(@Valid ProductAddBindingModel productAddBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:/product/add/ingredients";
        }

        Integer ingredientsCount = productAddBindingModel.getIngredientsCount();

        productService.saveProduct(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }


    @ModelAttribute
    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }

    @ModelAttribute
    public HashMap<String, Integer> ingredientMap () {
    return new HashMap<String, Integer>();
    }
}
