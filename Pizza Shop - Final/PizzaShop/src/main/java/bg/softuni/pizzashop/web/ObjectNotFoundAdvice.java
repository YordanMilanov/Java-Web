package bg.softuni.pizzashop.web;

import bg.softuni.pizzashop.errorHandling.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ObjectNotFoundAdvice {

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ObjectNotFoundException.class)
    public ModelAndView onProductNotFound(ObjectNotFoundException onfe) {
        ModelAndView modelAndView = new ModelAndView("object-not-found-error");

        modelAndView.addObject("objectId", onfe.getObjectId());
        modelAndView.addObject("objectType", onfe.getObjectType());

        return modelAndView;
    }
}
