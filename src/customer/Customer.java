package customer;

import account.Account;
import bank.Bank;

public class Customer implements ICustomer {
    private int accountNumber;
    private int pin;
    private Bank bank;

    public Customer(int accountNumber, int pin, Bank bank) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.bank = bank;
    }

    @Override
    public boolean login(int inputAccountNumber, int inputPin) {
        Account account = bank.getAccount(inputAccountNumber);
        return account != null && account.validatePin(inputPin);
    }

    public Account getAccount() {
        return bank.getAccount(accountNumber);
    }
}
