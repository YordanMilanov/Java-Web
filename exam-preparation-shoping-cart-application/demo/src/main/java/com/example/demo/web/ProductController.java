package com.example.demo.web;

import com.example.demo.model.binding.ProductAddBindingModel;
import com.example.demo.model.service.ProductServiceModel;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    private final ModelMapper modelMapper;

    public ProductController(ProductService productService, ModelMapper modelMapper) {
        this.productService = productService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add(Model model) {
        if(!model.containsAttribute("productAddBindingModel")) {
            model.addAttribute(productAddBindingModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String addConfirm(
            @Valid ProductAddBindingModel productAddBindingModel,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("productAddBindingModel", productAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.productAddBindingModel", bindingResult);

            return "redirect:add";
        }

        //todo save in db
        productService.add(modelMapper.map(productAddBindingModel, ProductServiceModel.class));

        return "redirect:/";
    }

    public ProductAddBindingModel productAddBindingModel() {
        return new ProductAddBindingModel();
    }
}
