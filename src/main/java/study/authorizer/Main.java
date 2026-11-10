package study.authorizer;

import study.authorizer.domain.Account;
import study.authorizer.domain.Transaction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Initiating the setup of the Authorizer...");

        //Create a Transaction for setup
        var tx = new Transaction("Uber", 30, LocalDateTime.now());

        //Create an Account
        var acc = Account.create(true, 200);
        var updatedAccount = acc.recordTransaction(tx);

        System.out.println("Account with transaction created with success!");
        System.out.println("Ativa: " + updatedAccount.active());
        System.out.println("Limite Disponível: " + updatedAccount.availableLimit());
        System.out.println("Histórico de Transações: " + updatedAccount.history().size());
    }
}
