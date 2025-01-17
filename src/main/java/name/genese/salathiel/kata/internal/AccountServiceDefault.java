package name.genese.salathiel.kata.internal;

import name.genese.salathiel.kata.AccountService;

public record AccountServiceDefault() implements AccountService {
    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
