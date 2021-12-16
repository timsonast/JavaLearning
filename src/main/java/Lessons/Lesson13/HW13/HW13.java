package Lessons.Lesson13.HW13;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HW13 {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        ProductService productService = context.getBean("productService",ProductService.class);
        Cart cart = context.getBean("cart", Cart.class);
        OrderService orderService = context.getBean("orderService", OrderService.class);

        cart.add(productService.findByTitle("product #1"));
        cart.add(productService.findByTitle("product #5"));
        cart.add(productService.findByTitle("product #3"));
        orderService.createOrderFromCurrentCart();

        ((AnnotationConfigApplicationContext)context).close();
    }
}
