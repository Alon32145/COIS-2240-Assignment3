import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Member> members = new ArrayList<Member>();
    private List<Book> books = new ArrayList<Book>();

    // Add a new member to the library
    public boolean addMember(Member member) {
    	if(findMemberById(member.getId()) == null ) { // if ID is unique a new member will form.
    		members.add(member);
    		return true;
    	}
    	else { // otherwise an error will show
    		return false;
    	}
    }
    
    // Add a new book to the library
    public boolean addBook(Book book) {
    	if(findBookById(book.getId()) == null ) { // if ID is unique a new book will form.
    		books.add(book);
    		return true;
    	}
    	else { // otherwise an error will show
    		return false;
    	}
        
    }

    // Find a member by ID
    public Member findMemberById(int id) {
        for (Member member : members) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }

    // Find a book by ID
    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    // Get the list of members
    public List<Member> getMembers() {
        return members;
    }
    
    // Get the list of books
    public List<Book> getBooks() {
        return books;
    }
}
