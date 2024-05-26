package atm;

import account.Account;
import bank.Bank;
import customer.Customer;
import transaction.BalanceInquiryTransaction;
import transaction.DepositTransaction;
import transaction.Transaction;
import transaction.WithdrawTransaction;

import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Customer currentCustomer;

    public ATM(Bank bank) {
        this.bank = bank;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();

        currentCustomer = new Customer(accountNumber, pin, bank);

        if (currentCustomer.login(accountNumber, pin)) {
            System.out.println("Login successful.");
            showMenu();
        } else {
            System.out.println("Login failed. Incorrect account number or PIN.");
        }
    }

    private void showMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            Transaction transaction = null;

            switch (choice) {
                case 1:
                    transaction = new BalanceInquiryTransaction(currentCustomer.getAccount());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    transaction = new DepositTransaction(currentCustomer.getAccount(), depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    transaction = new WithdrawTransaction(currentCustomer.getAccount(), withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            if (transaction != null) {
                transaction.execute();
            }
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addAccount(new Account(123456, 1234, 500.0));
        bank.addAccount(new Account(654321, 4321, 1000.0));

        ATM atm = new ATM(bank);
        atm.start();
    }
}
