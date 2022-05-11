package ArrayList;

public class BookStoreRunner {
	public static void main(String[] args) {
		OrderProcessor orderProcessor = new OrderProcessor();
		//orderProcessor.getOrderFromTheCustomer();
		orderProcessor.printOrderDetails(orderProcessor.getOrderFromTheCustomer());
	}
}
