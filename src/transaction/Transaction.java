package transaction;

import account.Account;

public abstract class Transaction implements ITransaction {
    protected Account account;

    public Transaction(Account account) {
        this.account = account;
    }

    @Override
    public abstract void execute();
}
