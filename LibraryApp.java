import java.sql.*;
import java.util.Scanner;

public class LibraryApp {

    static final String URL = "jdbc:mysql://localhost:3306/LibraryDB";
    static final String USER = "root";
    static final String PASS = "S@meer123"; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            while (true) {
                System.out.println("\n--- Library Menu ---");
                System.out.println("1. View Books");
                System.out.println("2. Add Member");
                System.out.println("3. Issue Book");
                System.out.println("4. View Issued Books");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        viewBooks(con);
                        break;
                    case 2:
                        addMember(con, sc);
                        break;
                    case 3:
                        issueBook(con, sc);
                        break;
                    case 4:
                        viewIssuedBooks(con);
                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void viewBooks(Connection con) throws Exception {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT isbn, book_title, author FROM books");

        System.out.println("\nBooks List:");
        while (rs.next()) {
            System.out.println(
                rs.getString("isbn") + " | " +
                rs.getString("book_title") + " | " +
                rs.getString("author")
            );
        }
    }

    static void addMember(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Member ID: ");
        String id = sc.next();

        System.out.print("Enter Name: ");
        String name = sc.next();

        System.out.print("Enter Address: ");
        String address = sc.next();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO members(member_id, member_name, member_address, reg_date) VALUES (?, ?, ?, CURDATE())"
        );

        ps.setString(1, id);
        ps.setString(2, name);
        ps.setString(3, address);

        ps.executeUpdate();
        System.out.println("✅ Member added successfully!");
    }

    static void issueBook(Connection con, Scanner sc) throws Exception {
        System.out.print("Enter Issue ID: ");
        String iid = sc.next();

        System.out.print("Enter Member ID: ");
        String mid = sc.next();

        System.out.print("Enter Book ISBN: ");
        String isbn = sc.next();

        System.out.print("Enter Employee ID: ");
        String emp = sc.next();

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO issued_status (issued_id, issued_member_id, issued_book_name, issued_date, issued_book_isbn, issued_emp_id) VALUES (?, ?, (SELECT book_title FROM books WHERE isbn=?), CURDATE(), ?, ?)"
        );

        ps.setString(1, iid);
        ps.setString(2, mid);
        ps.setString(3, isbn);
        ps.setString(4, isbn);
        ps.setString(5, emp);

        ps.executeUpdate();
        System.out.println("✅ Book issued successfully!");
    }

    static void viewIssuedBooks(Connection con) throws Exception {
        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery(
            "SELECT i.issued_id, m.member_name, b.book_title, i.issued_date " +
            "FROM issued_status i " +
            "JOIN members m ON i.issued_member_id = m.member_id " +
            "JOIN books b ON i.issued_book_isbn = b.isbn"
        );

        System.out.println("\nIssued Books:");
        while (rs.next()) {
            System.out.println(
                rs.getString("issued_id") + " | " +
                rs.getString("member_name") + " | " +
                rs.getString("book_title") + " | " +
                rs.getDate("issued_date")
            );
        }
    }
}