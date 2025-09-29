package lesson03;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
class BankSystem {
    private String accountNumber;
    private String fio;
    private double balance;

    private static List<BankSystem> accounts = new ArrayList<>();


    public void replenishAccount(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(amount + " was deposited. New balance: " + balance);
        } else {
            System.out.println("Error: invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(amount + " was withdrawn. New balance: " + balance);
        } else {
            System.out.println("Error: insufficient funds or invalid amount");
        }
    }

    public static void addAccount(BankSystem account) {
        accounts.add(account);
        System.out.println("Account added: " + account.getAccountNumber());
    }

    public static void deleteAccount(String accountNumber) {
        accounts.removeIf(acc -> acc.getAccountNumber().equals(accountNumber));
        System.out.println("Account deleted: " + accountNumber);
    }

    public static BankSystem getAccountInfo(String accountNumber) {
        for (BankSystem acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                System.out.println("Account info: " + acc);
                return acc;
            }
        }
        System.out.println("Account not found: " + accountNumber);
        return null;
    }

    public static void transferMoneyBetweenAccounts(String fromAcc, String toAcc, double amount) {
        BankSystem sender = getAccountInfo(fromAcc);
        BankSystem receiver = getAccountInfo(toAcc);

        if (sender != null && receiver != null) {
            if (sender.getBalance() >= amount) {
                sender.withdraw(amount);
                receiver.replenishAccount(amount);
                System.out.println(amount + " was transferred from " + fromAcc + " to " + toAcc);
            } else {
                System.out.println("Error: insufficient funds!");
            }
        }
    }

    public static void getAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (BankSystem acc : accounts) {
                System.out.println(acc);
            }
        }
    }

    @Override
    public String toString() {
        return "AccountNumber: " + accountNumber +
            ", FIO: " + fio +
            ", Balance: " + balance;
    }
}
