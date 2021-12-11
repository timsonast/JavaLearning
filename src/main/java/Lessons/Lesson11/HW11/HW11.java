package Lessons.Lesson11.HW11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class HW11 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderKey.class)
                .buildSessionFactory();

        Session session = null;

        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter command: ");

            while(sc.hasNext()){
                String command = sc.nextLine();
                if(command.equals("exit")){
                    break;
                }
                String[] commandParts = command.split(" ");

                switch (commandParts[0]){
                    case "/buy":
                        System.out.println("/buy");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        Person person = (Person) session
                                .createQuery("FROM Person p WHERE p.name = :name")
                                .setParameter("name", commandParts[1]).getSingleResult();
                        Product product = (Product) session
                                .createQuery("FROM Product p WHERE p.name = :name")
                                .setParameter("name", commandParts[2]).getSingleResult();

                        OrderKey orderKey = new OrderKey();
                        orderKey.setPersonId(person.getId());
                        orderKey.setProductId(product.getId());

                        Order order = new Order();
                        order.setOrderKey(orderKey);
                        order.setPrice(product.getPrice());

                        session.save(order);

                        session.getTransaction().commit();
                        System.out.println("Saved the next order: " + order.toString());
                        System.out.println("Enter new command: ");
                        break;

                    case "/ShowProductsByPerson":
                        System.out.println("/ShowProductsByPerson");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        person = (Person) session
                                .createQuery("FROM Person p WHERE p.name = :name")
                                .setParameter("name", commandParts[1]).getSingleResult();
                        List<Order> orders = person.getOrders();
                        orders.forEach(o -> System.out.println("Products for " + person.getName() + ": " + o.getProduct().toString()));

                        session.getTransaction().commit();
                        System.out.println("Enter new command: ");
                        break;

                    case "/FindPersonsByProductTitle":
                        System.out.println("/FindPersonsByProductTitle");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        product = (Product) session
                                .createQuery("FROM Product p WHERE p.name = :name")
                                .setParameter("name", commandParts[1]).getSingleResult();

                        orders = product.getOrders();
                        orders.forEach(o -> System.out.println("Persons for " + product.getName() + ": " + o.getPerson().toString()));

                        session.getTransaction().commit();
                        System.out.println("Enter new command: ");
                        break;

                    case "/RemovePerson":
                        System.out.println("/RemovePerson");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        person = (Person) session
                                .createQuery("FROM Person p WHERE p.name = :name")
                                .setParameter("name", commandParts[1]).getSingleResult();

                        session.delete(person);
                        System.out.println("Removed - " + person.toString());

                        session.getTransaction().commit();
                        System.out.println("Enter new command: ");
                        break;

                    case "/RemoveProduct":
                        System.out.println("/RemoveProduct");
                        session = factory.getCurrentSession();
                        session.beginTransaction();

                        product = (Product) session
                                .createQuery("FROM Product p WHERE p.name = :name")
                                .setParameter("name", commandParts[1]).getSingleResult();

                        session.delete(product);
                        System.out.println("Removed - " + product.toString());

                        session.getTransaction().commit();
                        System.out.println("Enter new command: ");
                        break;

                    default:
                        break;
                }
            }
        } finally {
            factory.close();
            session.close();
        }
    }
}
