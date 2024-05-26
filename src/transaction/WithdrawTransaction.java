package transaction;

import account.Account;

public class WithdrawTransaction extends Transaction {
    private double amount;

    public WithdrawTransaction(Account account, double amount) {
        super(account);
        this.amount = amount;
    }

    @Override
    public void execute() {
        if (!account.withdraw(amount)) {
            System.out.println("Insufficient funds!");
        }
    }
}
