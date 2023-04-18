package bg.softuni.pizzashop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PizzaShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaShopApplication.class, args);
    }

}
