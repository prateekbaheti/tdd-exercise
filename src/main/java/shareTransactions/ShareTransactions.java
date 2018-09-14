package shareTransactions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShareTransactions {
    public static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private String firstParty;
    private String secondParty;
    private TransactionType transactionType;
    private LocalDate dateOfTransaction;
    private int numberOfShares;

    public ShareTransactions(String firstParty, String secondParty, TransactionType transactionType,
                             String dateOfTransaction, int numberOfShares) {
        this.firstParty = firstParty;
        this.secondParty = secondParty;
        this.transactionType = transactionType;
        this.dateOfTransaction = LocalDate.parse(dateOfTransaction, FORMAT);
        this.numberOfShares = numberOfShares;
    }

    public String getFirstParty() {
        return firstParty;
    }

    public String getSecondParty() {
        return secondParty;
    }

    public LocalDate getDateOfTransaction() {
        return dateOfTransaction;
    }

    public int getNumberOfShares() {
        return numberOfShares;
    }

}
