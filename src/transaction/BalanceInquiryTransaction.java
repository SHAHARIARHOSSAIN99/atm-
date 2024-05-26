package transaction;

import account.Account;

public class BalanceInquiryTransaction extends Transaction {
    public BalanceInquiryTransaction(Account account) {
        super(account);
    }

    @Override
    public void execute() {
        System.out.println("Current balance: " + account.getBalance());
    }
}
