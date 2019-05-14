
public class Account {
	
	private float balance;
	
	public Account() {
		this.balance = 0;
	}
	
	public Account(float c) throws NegativeOrNullDepositException {
		if (c <= 0) {
			throw new NegativeOrNullDepositException();
		}
		this.balance = c;
	}
	
	public void deposit(float c) throws NegativeOrNullDepositException {
		if (c <= 0) {
			throw new NegativeOrNullDepositException();
		}
		this.balance += c;
	}
	
	public void withdrawal(float c) throws InsufficientBalanceException, NegativeOrNullDepositException {
		if (this.balance < c) {
			throw new InsufficientBalanceException();
		} else if (c <= 0) {
			throw new NegativeOrNullDepositException("Cannot withdraw a negative or null ammount");
		}
		this.balance -= c;
	}

	public float getBalance() {
		return balance;
	}
}
