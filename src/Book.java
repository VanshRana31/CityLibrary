class Book implements Comparable<Book> {
    int bookId;
    String title, author, category;
    boolean isIssued;

    Book(int id, String t, String a, String c) {
        bookId = id;
        title = t;
        author = a;
        category = c;
        isIssued = false;
    }

    void markAsIssued() { isIssued = true; }

    void markAsReturned() { isIssued = false; }

    void displayBookDetails() {
        System.out.println(bookId + " | " + title + " | " + author + " | " + category + " | Issued: " + isIssued);
    }

    public int compareTo(Book b) {
        return this.title.compareTo(b.title); // sort by title
    }
}
