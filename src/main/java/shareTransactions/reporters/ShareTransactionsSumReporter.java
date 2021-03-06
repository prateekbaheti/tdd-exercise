package shareTransactions.reporters;

import shareTransactions.ShareTransactionFilter;
import shareTransactions.ShareTransactions;
import shareTransactions.TransactionType;

import java.util.LinkedList;
import java.util.List;

public class ShareTransactionsSumReporter {

    public int report(List<ShareTransactions> shareTransactions) {
        return new ShareTransactionFilter(shareTransactions)
                .filterTransfersOnDateNameAndNoOfShares()
                .stream()
                .mapToInt(ShareTransactions::getNumberOfShares)
                .sum();
    }

    public static void main(String[] args) {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "03/04/2018", 2000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/06/2018", 5000));

        int sumOfShares = new ShareTransactionsSumReporter().report(shareTransactions);

        System.out.println("Sum of shares transferred between Alex and Bob in financial year = "+sumOfShares);
    }
}
