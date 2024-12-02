import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.Date;

public class Transaction {
	
    // The single instance of the Transaction class
    private static Transaction instance;

    // Private constructor to prevent instantiation
    private Transaction() {}

    // Method to get the singleton instance of Transaction
    public static Transaction getTransaction() {
        if (instance == null) {
            instance = new Transaction();
        }
        return instance;
    }
    
    public void  saveTransaction(String str) {
    	try (BufferedWriter writer = new BufferedWriter(new FileWriter("transactions.txt", true))) {
            writer.write(str);
            writer.newLine();  // Ensure each transaction is on a new line
        } catch (IOException e) {
            System.out.println("An error occurred while saving the transaction: " + e.getMessage());
        }
    }
    
    public void  displayTransactionHistory() {
    	System.out.println("---- Transaction History ----");
        try (BufferedReader reader = new BufferedReader(new FileReader("transactions.txt"))) {
            String transaction;
            while ((transaction = reader.readLine()) != null) {
                System.out.println(transaction);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the transaction history: " + e.getMessage());
        }
    }

    // Perform the borrowing of a book
    public boolean borrowBook(Book book, Member member) {
        if (book.isAvailable()) {
        	
            book.borrowBook();
            member.borrowBook(book); 
            String transactionDetails = getCurrentDateTime() + " - Borrowing: " + member.getName() + " borrowed " + book.getTitle();
            saveTransaction(transactionDetails);
            System.out.println(transactionDetails);
            return true;
        } else {
            System.out.println("The book is not available.");
            return false;
        }
    }

    // Perform the returning of a book
    public void returnBook(Book book, Member member) {
        if (member.getBorrowedBooks().contains(book)) {
            member.returnBook(book);
            book.returnBook();
            String transactionDetails = getCurrentDateTime() + " - Returning: " + member.getName() + " returned " + book.getTitle();
            saveTransaction(transactionDetails);
            System.out.println(transactionDetails);
        } else {
            System.out.println("This book was not borrowed by the member.");
        }
    }

    // Get the current date and time in a readable format
    private static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}