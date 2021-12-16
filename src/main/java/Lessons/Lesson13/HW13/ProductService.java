package Lessons.Lesson13.HW13;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductService {
    private List<Product> products;

    @PostConstruct
    public void init(){
        products = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            products.add(new Product((long) (i + 1),"product #" + (i + 1),10*i));
        }
    }

    public Product findByTitle(String title){
        return products.stream().filter(p -> p.getTitle().equals(title)).findFirst().get();
    }

    public void printAll(){
        for(Product p : products){
            System.out.println(p.getId() + " " + p.getTitle() + " " + p.getCost());
        }
    }


}
