package application;

import java.util.Locale;

import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
// Produto TV com preço unitário de 1000.00
		Product p = new Product("TV", 1000.00);

// Objeto oi1 do tipo OrderItem recebe quantidade 1, preço 1000.00 e associação com o produto p
		OrderItem oi1 = new OrderItem(1, 1000.00, p);

		System.out.println(oi1.getProduct().getName());

		System.out.println(oi1);
	}

}
