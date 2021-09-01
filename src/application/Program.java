package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
//Objeto do tipo client recebe dados informados pelo usuário
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		
		System.out.print("Order Status: ");
//OrderStatus.valueOf(sc.next()) ---- Converte a string digitada pelo usuário para valor de tipo Enum
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		System.out.println("How many items to this order?: ");
		int n = sc.nextInt();

		
// Pedido instanciado com horário atual do sistema
		Order order = new Order(new Date(), status, client);
		
		
		for (int i = 0; i<n; i++) {
			System.out.println("Enter #"+(i+1)+" data: ");
			System.out.print("Product name: ");
			
			sc.nextLine();
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Product quantity: ");
			int quantity = sc.nextInt();
			//Produto Instanciado
			Product product = new Product(productName, productPrice);
//Objeto it do tipo Order Item recebe quantidade, preço, e recebe objeto product como parâmetro.
// Objeto product contém nome e preço.
			OrderItem it = new OrderItem(quantity, productPrice, product);
//	Adiciona a ordem de pedido na lista de pedidos 		
			order.addItem(it);
		}
		
		System.out.println(order);
		
		sc.close();
	}

}
