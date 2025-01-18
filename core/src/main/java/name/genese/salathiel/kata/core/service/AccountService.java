package name.genese.salathiel.kata.core.service;

import name.genese.salathiel.kata.core.domain.Operation;
import name.genese.salathiel.kata.core.service.internal.AccountServiceDefault;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void deposit(double amount);

    void withdraw(double amount);

    BigDecimal getBalance();

    List<Operation> getStatement();

    static AccountService from(BigDecimal initial) {
        return new AccountServiceDefault(initial);
    }

    static AccountService from() {
        return new AccountServiceDefault();
    }
}
