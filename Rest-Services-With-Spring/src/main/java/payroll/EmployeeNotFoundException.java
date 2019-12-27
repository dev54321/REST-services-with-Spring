package payroll;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException(Long id) {
		super("Coud not find employee "+ id);
	}

}
