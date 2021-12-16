package Lessons.Lesson13.HW13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    @Autowired
    Cart cart;


    public void createOrderFromCurrentCart(){
        System.out.println("ваш заказ");
        List<Product> products = cart.getContainer();
        for (Product p : products){
            System.out.println(p.getTitle());
        }
        System.out.println("Cумма заказа : " +products.stream().mapToInt(Product::getCost).sum());
    }

}
