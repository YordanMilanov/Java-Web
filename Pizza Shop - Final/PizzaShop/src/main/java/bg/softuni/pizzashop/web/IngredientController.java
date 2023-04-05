package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.model.binding.IngredientAddBindingModel;
import bg.softuni.pizzashop.model.service.IngredientServiceModel;
import bg.softuni.pizzashop.service.IngredientService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private final ModelMapper modelMapper;
    private final IngredientService ingredientService;

    public IngredientController(ModelMapper modelMapper, IngredientService ingredientService) {
        this.modelMapper = modelMapper;
        this.ingredientService = ingredientService;
    }


    @GetMapping("/add")
    public String addIngredient() {
        return "add-ingredient";
    }

    @PostMapping("/add")
    public String addIngredientConfirm(@Valid IngredientAddBindingModel ingredientAddBindingModel,
                                       BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes) throws IOException {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("ingredientAddBindingModel", ingredientAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.ingredientAddBindingModel", bindingResult);

           return "redirect:/ingredient/add";
        }

        ingredientService.saveIngredient(modelMapper.map(ingredientAddBindingModel, IngredientServiceModel.class));

        return "redirect:/";
    }

    @ModelAttribute
    public IngredientAddBindingModel ingredientAddBindingModel() {
        return new IngredientAddBindingModel();
    }
}
