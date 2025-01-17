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
        balance = balance.add(BigDecimal.valueOf(amount));
    }

    @Override
    public void withdraw(double amount) {
        balance = balance.subtract(BigDecimal.valueOf(amount));
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}
