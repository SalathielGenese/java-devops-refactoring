package name.genese.salathiel.kata;

import java.math.BigDecimal;

public interface AccountService {
    void deposit(double amount);

    void withdraw(double amount);

    BigDecimal getBalance();
}
