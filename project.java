
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private long accountNo;
    private String name;
    private double balance;

    Account(long accountNo, String name, double balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    long getAccountNo() {
        return accountNo;
    }

    double getBalance() {
        return balance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    void display() {
        System.out.println("Account No: " + accountNo);
        System.out.println("Name: " + name);
        System.out.printf("Balance: Rs. %.2f%n", balance);
    }
}

public class project {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Display Account");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.nextLine();
                continue;
            }

            int choice = sc.nextInt();

            switch (choice) {

                case 1: {
                    System.out.print("Enter Account No: ");

                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.nextLine();
                        break;
                    }

                    long no = sc.nextLong();
                    boolean exists = false;

                    for (Account a : accounts) {
                        if (a.getAccountNo() == no) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Account already exists!");
                        break;
                    }

                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                        break;
                    }

                    System.out.print("Enter Initial Balance: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid balance!");
                        sc.nextLine();
                        break;
                    }

                    double balance = sc.nextDouble();

                    if (!Double.isFinite(balance) || balance < 0) {
                        System.out.println("Invalid balance!");
                        break;
                    }

                    accounts.add(new Account(no, name, balance));
                    System.out.println("Account created successfully!");
                    break;
                }

                case 2: {
                    System.out.print("Enter Account No: ");

                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.nextLine();
                        break;
                    }

                    long no = sc.nextLong();

                    System.out.print("Enter Amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        sc.nextLine();
                        break;
                    }

                    double amount = sc.nextDouble();

                    if (!Double.isFinite(amount) || amount <= 0) {
                        System.out.println("Invalid deposit amount!");
                        break;
                    }

                    boolean found = false;

                    for (Account a : accounts) {
                        if (a.getAccountNo() == no) {
                            a.deposit(amount);
                            System.out.println("Amount deposited successfully!");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account not found!");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter Account No: ");

                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.nextLine();
                        break;
                    }

                    long no = sc.nextLong();

                    System.out.print("Enter Amount: ");

                    if (!sc.hasNextDouble()) {
                        System.out.println("Invalid amount!");
                        sc.nextLine();
                        break;
                    }

                    double amount = sc.nextDouble();
                    boolean found = false;

                    for (Account a : accounts) {
                        if (a.getAccountNo() == no) {

                            if (a.withdraw(amount)) {
                                System.out.println("Amount withdrawn successfully!");
                            } else {
                                System.out.println(
                                    "Invalid amount or insufficient balance!"
                                );
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account not found!");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter Account No: ");

                    if (!sc.hasNextLong()) {
                        System.out.println("Invalid account number!");
                        sc.nextLine();
                        break;
                    }

                    long no = sc.nextLong();
                    boolean found = false;

                    for (Account a : accounts) {
                        if (a.getAccountNo() == no) {
                            System.out.printf(
                                "Current Balance: Rs. %.2f%n",
                                a.getBalance()
                            );
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Account not found!");
                    }
                    break;
                }

                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available!");
                    } else {
                        for (Account a : accounts) {
                            a.display();
                            System.out.println("--------------------");
                        }
                    }
                    break;

                case 6:
                    System.out.println(
                        "Thank you for using Bank Management System!"
                    );
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
