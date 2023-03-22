package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.IngredientAddBindingModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/add/ingredient")
    public String addIngredient() {
        return "add-ingredient";
    }

    @PostMapping("/add/ingredient")
    public String addIngredientConfirm(@Valid IngredientAddBindingModel ingredientAddBindingModel,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("ingredientAddBindingModel", ingredientAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ingredientAddBindingModel", bindingResult);

            return "redirect:/product/add/ingredient";
        }

        return "redirect:/";
    }

    @ModelAttribute
    public IngredientAddBindingModel ingredientAddBindingModel() {
        return new IngredientAddBindingModel();
    }
}
