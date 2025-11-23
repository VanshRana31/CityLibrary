import java.io.*;
import java.util.*;

class LibraryManager {

    Map<Integer, Book> books = new HashMap<>();
    Map<Integer, Member> members = new HashMap<>();

    // save books
    void saveBooks() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("books.txt"));
        for (Book b : books.values()) {
            bw.write(b.bookId + "," + b.title + "," + b.author + "," + b.category + "," + b.isIssued);
            bw.newLine();
        }
        bw.close();
    }

    // save members
    void saveMembers() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("members.txt"));
        for (Member m : members.values()) {
            bw.write(m.memberId + "," + m.name + "," + m.email + "," + m.issuedBooks);
            bw.newLine();
        }
        bw.close();
    }

    void addBook(Book b) throws Exception {
        books.put(b.bookId, b);
        saveBooks();
    }

    void addMember(Member m) throws Exception {
        members.put(m.memberId, m);
        saveMembers();
    }

    void issueBook(int bookId, int memberId) throws Exception {
        Book b = books.get(bookId);
        Member m = members.get(memberId);

        if (!b.isIssued) {
            b.markAsIssued();
            m.addIssuedBook(bookId);
            saveBooks();
            saveMembers();
        }
    }

    void returnBook(int bookId, int memberId) throws Exception {
        Book b = books.get(bookId);
        Member m = members.get(memberId);

        if (b.isIssued) {
            b.markAsReturned();
            m.returnIssuedBook(bookId);
            saveBooks();
            saveMembers();
        }
    }

    void searchBook(String title) {
        for (Book b : books.values()) {
            if (b.title.toLowerCase().contains(title.toLowerCase()))
                b.displayBookDetails();
        }
    }

    void sortBooks() {
        List<Book> list = new ArrayList<>(books.values());
        Collections.sort(list); // using Comparable
        list.forEach(Book::displayBookDetails);
    }
}
