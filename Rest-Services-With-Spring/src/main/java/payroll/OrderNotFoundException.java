package payroll;

public class OrderNotFoundException extends RuntimeException{
	
	public OrderNotFoundException(Long id) {
		super("Coud not find order "+ id);
	}

}
