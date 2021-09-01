package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
// Produto TV com preço unitário de 1000.00
		Product p = new Product("TV", 1000.00);

// Objeto oi1 do tipo OrderItem recebe quantidade 1, preço 1000.00 e associação com o produto p
		OrderItem oi1 = new OrderItem(1, 1000.00, p);

		System.out.println(oi1.getProduct().getName());

		System.out.println(oi1);
		
		Client cli = new Client("Maria", "maria@gmail.com", sdf.parse("29/01/1957"));
		
		System.out.println(cli);
		
		sc.close();
	}

}
