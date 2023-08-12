package first;

import java.util.Scanner;

class BankAc {
	
	String name;
	String userName;
	String password;
	String accountNo;
	float balance = 100000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nENTER YOUR FULL NAME:- ");
		this.name = sc.nextLine();
		System.out.print("\nENTER YOUR USER NAME:- ");
		this.userName = sc.nextLine();
		System.out.print("\nENTER YOUR PASSWORD:- ");
		this.password = sc.nextLine();
		System.out.print("\nCONFIRM YOUR PASSWORD:- ");
		this.password = sc.nextLine();
		System.out.print("\nENTER YOUR A/C NUMBER:- ");
		this.accountNo = sc.nextLine();
		System.out.println("\nREGISTERED SUCCESSFULLY...LOGIN");
	}
	
	public boolean login() {
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) {
			System.out.print("\nENTER YOUR USER NAME:- ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !isLogin ) {
					System.out.print("\nENTER YOUR PASSWORD:- ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print("LOGIN SUCCESS!!!");
						isLogin = true;
					}
					else {
						System.out.println("\nINCORRECT PASSWORD...");
					}
				}
			}
			else {
				System.out.println("\nUSER NOT FOUND...");
			}
		}
		return isLogin;
	}
	
	public void withdraw() {
		
		System.out.print("\nENTER YOUR AMOUNT TO WITHDRAW:-");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				transactions++;
				balance -= amount;
				System.out.println("\nWITHDRAWN SUCCESSFULLY...");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else {
				System.out.println("\nINSUFFICIENT BALANCE...");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		
		System.out.print("\nENTER AMOUNT TO MAKE DEPOSIT:-");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transactions++;
				balance += amount;
				System.out.println("\nSUCCESSFULLY DEPOSITED...");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("\nSORRY...YOUR TRANSACTION LIMIT IS 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nENTER RECEIPENT NAME:-");
		String receipent = sc.nextLine();
		System.out.print("\nENTER THE AMOUNT TRANSFER:-");
		float amount = sc.nextFloat();
		
		try {
			if ( balance >= amount ) {
				if ( amount <= 50000f ) {
					transactions++;
					balance -= amount;
					System.out.println("\nSUCCESSFULLY TRANSFERRED TO " + receipent);
					String str = amount + " Rs transfered to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println("\nSORRY...YOUR TRANSACTION LIMIT IS 50000.00");
				}
			}
			else {
				System.out.println("\nINSUFFICIENT BALANCE...");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}
	
	public void transHistory() {
		if ( transactions == 0 ) {
			System.out.println("\nEMPTY...");
		}
		else {
			System.out.println("\n" + transactionHistory);
		}
	}
}
public class BankAccount {
	
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while ( !flag ) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) {
					System.out.println("CHOOSE YOUR NUMBER 1 TO " + limit);
					flag = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("ENTER ONLY INTEGER VALUE");
				flag = false;
			}
		};
		return input;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("\n**********WELCOME TO THE  ATM SYSTEM**********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("ENTER YOUR CHOICE:- ");
		int choice = takeIntegerInput(2);
		
		if ( choice == 1 ) {
			BankAc b = new BankAc();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("ENTER YOUR CHOICE:- ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
					if (b.login()) {
						System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
						boolean isFinished = false;
						while (!isFinished) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nENTER YOUR CHOICE:- ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
		
		
		
	}
}	