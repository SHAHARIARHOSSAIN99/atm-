package account;

public interface IAccount {
    int getAccountNumber();
    boolean validatePin(int inputPin);
    double getBalance();
    void deposit(double amount);
    boolean withdraw(double amount);
}
