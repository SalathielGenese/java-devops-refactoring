package name.genese.salathiel.kata.internal;

import name.genese.salathiel.kata.AccountService;

import java.math.BigDecimal;

public final class AccountServiceDefault implements AccountService {
    private BigDecimal balance;

    public AccountServiceDefault(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountServiceDefault() {
        this(BigDecimal.ZERO);
    }

    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}
