import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        LibraryManager lm = new LibraryManager();

        while (true) {
            System.out.println("\n1. Add Book\n2. Add Member\n3. Issue Book\n4. Return Book\n5. Search Book\n6. Sort Books\n7. Exit");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Book ID: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("Title: "); String t = sc.nextLine();
                System.out.print("Author: "); String a = sc.nextLine();
                System.out.print("Category: "); String c = sc.nextLine();
                lm.addBook(new Book(id, t, a, c));
            }

            else if (ch == 2) {
                System.out.print("Member ID: "); int id = sc.nextInt(); sc.nextLine();
                System.out.print("Name: "); String n = sc.nextLine();
                System.out.print("Email: "); String e = sc.nextLine();
                lm.addMember(new Member(id, n, e));
            }

            else if (ch == 3) {
                System.out.print("Book ID: "); int b = sc.nextInt();
                System.out.print("Member ID: "); int m = sc.nextInt();
                lm.issueBook(b, m);
            }

            else if (ch == 4) {
                System.out.print("Book ID: "); int b = sc.nextInt();
                System.out.print("Member ID: "); int m = sc.nextInt();
                lm.returnBook(b, m);
            }

            else if (ch == 5) {
                sc.nextLine();
                System.out.print("Enter title: "); String t = sc.nextLine();
                lm.searchBook(t);
            }

            else if (ch == 6) {
                lm.sortBooks();
            }

            else break;
        }
        sc.close();
    }
}
