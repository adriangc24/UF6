import java.util.Scanner;

public class AutomatedTellerMachine {
	
	private static void writeMenu() {
		System.out.println("Please select an option");
		System.out.println("---------------------------------------");
		System.out.println("1 - Create account");
		System.out.println("2 - Create account with initial deposit");
		System.out.println("3 - Deposit");
		System.out.println("4 - Withdraw");
		System.out.println("5 - Check balance");
		System.out.println("6 - Exit");
	}
	
	private static Account createAccount() {
		Account a = new Account();
		System.out.println("Account created");
		return a;
	}
	
	private static Account createAccountWithDeposit(float c) throws NegativeOrNullDepositException {
		Account a = new Account(c);
		System.out.println("Account created with initial deposit of " + c + " €.");
		return a;
	}
	
	private static void deposit(Account a, float c) throws NegativeOrNullDepositException {
		a.deposit(c);
		System.out.println("Deposited " + c + " € into account.");
	}
	
	private static void withdraw(Account a, float c) throws InsufficientBalanceException, NegativeOrNullDepositException {
		a.withdrawal(c);
		System.out.println(c + "€ withdrawed from account.");
	}
	
	private static float checkBalance(Account a) {
		return a.getBalance();
	}
	
	private static void noAccount() {
		System.out.println("You don't have an account yet");
	}
	
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		Account a = null;
		int option = 0;
		
		System.out.println("Welcome to Mr.Thwaite's ATM");
		while (option != 6) {
			writeMenu();
			option = sc.nextInt();
			try {
				switch(option) {
				case 1:
					a = createAccount();
					break;
				case 2:
					System.out.println("Deposit amount: ");
					float c = sc.nextFloat();
					a = createAccountWithDeposit(c);
					break;
				case 3:
					if (a == null) {
						noAccount();
					} else {
						System.out.println("Deposit amount: ");
						float c1 = sc.nextFloat();
						deposit(a, c1);
					}
					break;
				case 4:
					if (a == null) {
						noAccount();
					} else {
						System.out.println("Withdraw amount: ");
						float c2 = sc.nextFloat();
						withdraw(a, c2);
					}
					break;
				case 5:
					if (a == null) {
						noAccount();
					} else {
						System.out.println("You have " + checkBalance(a) + " in your account");
					}
					break;
				case 6:
					break;
				default:
					System.out.println("The option you have selected does not exist");
				} 
			} catch (NegativeOrNullDepositException e) {
				System.out.println(e.getMessage());
			} catch (InsufficientBalanceException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("See you again soon!");
		sc.close();
	}
}
