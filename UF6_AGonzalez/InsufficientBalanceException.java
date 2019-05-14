
public class InsufficientBalanceException extends Exception{
	
	public InsufficientBalanceException() {
		
		super("Not enough balance");
	
	}
	
	public InsufficientBalanceException(String s) {
		
		super(s);
	}
}
