package name.genese.salathiel.kata.service.internal;

import name.genese.salathiel.kata.service.AccountService;
import name.genese.salathiel.kata.domain.Operation;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class AccountServiceDefault implements AccountService {
    private final List<Operation> statement = new LinkedList<>();
    private BigDecimal balance;

    public AccountServiceDefault(BigDecimal initial) {
        Objects.requireNonNull(initial, "balance is null");
        if (initial.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("negative balance");

        this.balance = initial;
        statement.add(new Operation.Initial(balance, initial));
    }

    public AccountServiceDefault() {
        this(BigDecimal.ZERO);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("negative amount");
        final var val = BigDecimal.valueOf(amount);
        balance = balance.add(val);
        statement.add(new Operation.Deposit(balance, val));
    }

    @Override
    public void withdraw(double amount) {
        final var val = BigDecimal.valueOf(amount);
        if (amount <= 0)
            throw new IllegalArgumentException("negative amount");
        if (0 < val.compareTo(balance))
            throw new IllegalArgumentException("insufficient balance");
        balance = balance.subtract(val);
        statement.add(new Operation.Withdrawal(balance, val));
    }

    @Override
    public List<Operation> getStatement() {
        return List.copyOf(statement);
    }

    @Override
    public BigDecimal getBalance() {
        return balance;
    }
}
