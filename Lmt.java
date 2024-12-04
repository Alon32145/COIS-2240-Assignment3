import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

public class Lmt {
	
	private Book validBook;
	
	@Before
	public void setUp() throws Exception {
	    validBook = new Book(150, "Valid Book");
	}


    @Test
    public void testValidId() {
        try {
            Book book = new Book(150, "Valid Book");
            assertEquals(150, book.getId());
            assertEquals("Valid Book", book.getTitle());
        } catch (Exception e) {
            fail("Exception should not be thrown for a valid ID");
        }
    }

    @Test
    public void testInvalidId() {
        try {
            new Book(50, "Invalid Book");
            fail("Exception should be thrown for an invalid ID");
        } catch (Exception e) {
            assertEquals("Invalid book ID: 50", e.getMessage());
        }

        try {
            new Book(1000, "Invalid Book");
            fail("Exception should be thrown for an invalid ID");
        } catch (Exception e) {
            assertEquals("Invalid book ID: 1000", e.getMessage());
        }
    }
    
    @Test
    public void testBorrowReturn() {
    	
    		
    
    		assertTrue(validBook.isAvailable()); //Initially set the book to available
    		
    		// Pursue to borrow the book
    		validBook.borrowBook();
    		assertFalse(validBook.isAvailable());
    		
    		//Pursue to return the book
    		validBook.returnBook();
    		assertTrue(validBook.isAvailable());
    		
    	
    }
    
}
