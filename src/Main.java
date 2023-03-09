import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<OrderItem> orderItemList = new ArrayList<>();
        Client client = new Client("Alex Green", "alex@gmail.com", new Date(85, 2, 15));
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Product product = new Product("TV", 1000.0);
        Product product1 = new Product("Mouse", 40.0);
        OrderItem orderItem = new OrderItem(1, 1000.0, product);
        OrderItem orderItem2 = new OrderItem(2, 40.0, product1);

        orderItemList.add(orderItem);
        orderItemList.add(orderItem2);

        Order order = new Order(new Date(), OrderStatus.DELIVERED, client, orderItemList);

        System.out.println("Entre com os dados do cliente: ");
        System.out.println("Name: " + client.getName());
        System.out.println("Email: " + client.getEmail());
        System.out.println("Data de Nascimento: " + dateFormat.format(client.getBirthDate()));
        System.out.println("\nEntre com os dados do pedido: ");
        System.out.println("Status: " + OrderStatus.PROCESSING);
        System.out.print("Quantos items para este pedido? ");
        int a = 0;
        for (int i = 0; i < orderItemList.size(); i++) {
            a = (i + 1);
        }
        System.out.print(a);

        System.out.println();
        int i = 1;
        for (OrderItem d : orderItemList) {
            System.out.println("\nEntre com os dados do produto #" + i++);
            System.out.println("Nome: " + d.getProduct().getName());
            System.out.println("Preço: " + d.getProduct().getPrice());
            System.out.println("Quantidade: " + d.getQuantity());
        }

        System.out.println("\nSumário da Ordem: \n"  + order.getMoment() +
                                                "\n" + order.getStatus()+
                                                "\n" + order.getClient().getName() + "(" + dateFormat.format(order.getClient().getBirthDate())+") - " + order.getClient().getEmail() +
                                                "\nOrder Items: \n" );

            for (OrderItem d : orderItemList) {

                System.out.print( d.getProduct().getName() + ", ");
                System.out.print("$" + d.getProduct().getPrice()+ ", ");
                System.out.print("Qtde.:" + d.getQuantity()+ ", ");
                System.out.println("Subtotal: "+ d.getPrice()+"\n");
            };
        System.out.println("Total: $" + order.total());
    }
}