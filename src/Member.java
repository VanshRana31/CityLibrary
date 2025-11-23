import java.util.*;

class Member {
    int memberId;
    String name, email;
    List<Integer> issuedBooks = new ArrayList<>();

    Member(int id, String n, String e) {
        memberId = id;
        name = n;
        email = e;
    }

    void addIssuedBook(int bookId) {
        issuedBooks.add(bookId);
    }

    void returnIssuedBook(int bookId) {
        issuedBooks.remove(Integer.valueOf(bookId));
    }

    void displayMemberDetails() {
        System.out.println(memberId + " | " + name + " | " + email + " | Books: " + issuedBooks);
    }
}
