package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
	
	private Date moment;
	private OrderStatus status;

//Cada pedido é associado a um cliente	
	private Client client;

//Cada pedido podem ter vários itens, portanto, é preciso criar uma coleção (lista) de pedidos
//			Lista de objetos do tipo OrderItem	
	private List<OrderItem> items = new ArrayList<OrderItem>();

	public Order() {
	}
// Quando um objeto é do tipo coleção, ele deve ter seu proprio campo de addItem e removeItem
// Sendo assim, nunca utilize um objeto de coleção em "Generate constructors using Fields"

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
// Adiciona um novo elemento "item" na lista de objetos do tipo OrderItem
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
// Remove um elemento "item" da lista de objetos do tipo OrderItem
		items.remove(item);
	}
// Retorna o valor total de todos os pedidos (soma de todas as funções subTotal)	
	public Double total() {
		double sum = 0.0;
		for (OrderItem it : items) {//Para cada item da lista Items, realizar o calculo abaixo
			sum += it.subTotal();
		}
		return sum;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: ");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Order status: ");
		sb.append(status + "\n");
		sb.append("Client: ");
		sb.append(client + "\n");
		sb.append("Order items:\n");
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $");
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}	
}
