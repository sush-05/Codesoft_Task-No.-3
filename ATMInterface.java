import java.util.Scanner;

// BankAccount class
class BankAccount {
    private double balance;
    private String accountNumber;
    private String accountHolderName;

    public BankAccount(String accountNumber, String name, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = name;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}

// ATM class
class ATM {
    private BankAccount account;
    private Scanner input;

    public ATM(BankAccount account) {
        this.account = account;
        this.input = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=====================================");
        System.out.println("      Welcome to ABC Bank ATM");
        System.out.println("=====================================");
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println();

        boolean running = true;
        while (running) {
            showMenu();
            int choice = getChoice();

            switch (choice) {
                case 1:
                    displayBalance();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    running = false;
                    System.out.println("\nThank you for banking with us!");
                    System.out.println("Have a wonderful day!");
                    System.out.println("=====================================");
                    break;
                default:
                    System.out.println("\nInvalid selection. Please choose 1-4.\n");
            }
        }
        input.close();
    }

    private void showMenu() {
        System.out.println("Main Menu");
        System.out.println("---------");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Cash");
        System.out.println("3. Withdraw Cash");
        System.out.println("4. Exit");
        System.out.print("Please select an option: ");
    }

    private int getChoice() {
        try {
            return input.nextInt();
        } catch (Exception e) {
            input.nextLine(); // clear buffer
            return -1;
        }
    }

    private void displayBalance() {
        System.out.println("\n========== Balance Inquiry ==========");
        System.out.println("Account Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Available Balance: $" + String.format("%.2f", account.getBalance()));
        System.out.println("=====================================\n");
    }

    private void depositMoney() {
        System.out.println("\n========== Deposit Cash ==========");
        System.out.print("Enter deposit amount: $");

        try {
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("Error: Amount must be greater than zero.\n");
                return;
            }
            if (amount > 10000) {
                System.out.println("Error: Maximum deposit limit is $10,000.\n");
                return;
            }

            account.deposit(amount);
            System.out.println("\nTransaction successful!");
            System.out.println("Deposited Amount: $" + String.format("%.2f", amount));
            System.out.println("New Balance: $" + String.format("%.2f", account.getBalance()));
            System.out.println("==================================\n");

        } catch (Exception e) {
            input.nextLine(); // clear buffer
            System.out.println("Error: Invalid amount entered.\n");
        }
    }

    private void withdrawMoney() {
        System.out.println("\n========== Withdraw Cash ==========");
        System.out.println("Available Balance: $" + String.format("%.2f", account.getBalance()));
        System.out.print("Enter withdrawal amount: $");

        try {
            double amount = input.nextDouble();

            if (amount <= 0) {
                System.out.println("Error: Amount must be greater than zero.\n");
                return;
            }
            if (amount > 1000) {
                System.out.println("Error: Maximum withdrawal limit is $1,000.\n");
                return;
            }

            if (account.withdraw(amount)) {
                System.out.println("\nTransaction successful!");
                System.out.println("Withdrawn Amount: $" + String.format("%.2f", amount));
                System.out.println("Remaining Balance: $" + String.format("%.2f", account.getBalance()));
                System.out.println("===================================\n");
            } else {
                System.out.println("\nTransaction failed! Insufficient funds.");
                System.out.println("Your Balance: $" + String.format("%.2f", account.getBalance()));
                System.out.println("===================================\n");
            }

        } catch (Exception e) {
            input.nextLine(); // clear buffer
            System.out.println("Error: Invalid amount entered.\n");
        }
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount user = new BankAccount("ACC123456789", "John Smith", 1000.00);
        ATM atm = new ATM(user);
        atm.start();
    }
}
