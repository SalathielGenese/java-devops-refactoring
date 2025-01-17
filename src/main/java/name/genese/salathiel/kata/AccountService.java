package name.genese.salathiel.kata;

import name.genese.salathiel.kata.domain.Operation;

import java.math.BigDecimal;
import java.util.List;

public interface AccountService {
    void deposit(double amount);

    void withdraw(double amount);

    BigDecimal getBalance();

    List<Operation> getStatement();
}
