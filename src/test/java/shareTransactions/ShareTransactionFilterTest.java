package shareTransactions;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ShareTransactionFilterTest {

    @Test
    public void shouldReturnOnlyTransfers() {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/08/2017", 2000));
        shareTransactions.add(new ShareTransactions("Bob", "Bob",
                TransactionType.Acquisition, "01/09/2017", 2000));


        List<ShareTransactions> filteredList = new ShareTransactionFilter(shareTransactions).filterTransfersOnDateNameAndNoOfShares();

        assertEquals(1, filteredList.size());
    }


    @Test
    public void shouldReturnOnly1000SharesOrMore() {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/08/2017", 5000));
        shareTransactions.add(new ShareTransactions("Bob", "Bob",
                TransactionType.Transfer, "01/09/2017", 900));


        List<ShareTransactions> filteredList = new ShareTransactionFilter(shareTransactions).filterTransfersOnDateNameAndNoOfShares();

        assertEquals(1, filteredList.size());
    }

    @Test
    public void shouldReturnOnlySharesBetweenAandB() {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/08/2017", 5000));
        shareTransactions.add(new ShareTransactions("Bob", "Cat",
                TransactionType.Transfer, "01/09/2017", 5000));

        List<ShareTransactions> filteredList = new ShareTransactionFilter(shareTransactions).filterTransfersOnDateNameAndNoOfShares();

        assertEquals(1, filteredList.size());
    }


    @Test
    public void shouldReturnOnlySharesTransferredAfterApril1st() {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/04/2017", 1000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "31/03/2017", 1000));

        List<ShareTransactions> filteredList = new ShareTransactionFilter(shareTransactions).filterTransfersOnDateNameAndNoOfShares();

        assertEquals(1, filteredList.size());
    }

    @Test
    public void shouldReturnOnlySharesTransferredBeforeMarch31st() {
        List<ShareTransactions> shareTransactions = new LinkedList<>();
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "31/03/2018", 1000));
        shareTransactions.add(new ShareTransactions("Alex", "Bob",
                TransactionType.Transfer, "01/04/2018", 1000));

        List<ShareTransactions> filteredList = new ShareTransactionFilter(shareTransactions).filterTransfersOnDateNameAndNoOfShares();

        assertEquals(1, filteredList.size());
    }
}