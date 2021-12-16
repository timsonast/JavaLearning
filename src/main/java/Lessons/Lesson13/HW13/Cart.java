package Lessons.Lesson13.HW13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<Product> container;

    public List<Product> getContainer() {
        return container;
    }

    @PostConstruct
    public void init(){
        container = new ArrayList<>();
    }

    public void add(Product product){
        container.add(product);
    }
}
