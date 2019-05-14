
public class NegativeOrNullDepositException extends Exception {
	
	public NegativeOrNullDepositException() {
		super("Deposit can't be negative or zero");
	}
	
	public NegativeOrNullDepositException(String s) {
		super(s);
	}
}
