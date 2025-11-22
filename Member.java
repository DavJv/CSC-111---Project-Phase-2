/*
Member.java
CSC 111 – Computer Programming I
Project Phase 2
Group Members:
1. Muath Almutairi (ID: 446170719)
2. Saud Albaltan (ID: 446104249)
3. Omar Alshehri (ID: 446102706)
*/

// Github repository: https://github.com/DavJv/CSC-111---Project-Phase-2

public class Member {

    // Member info
    private int id;
    private String name;
    private int borrowedCount;

    // Session counters
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;

    // Library totals
    public static double TotalRevenue = 0;
    public static int TotalViewBorrowed = 0;
    public static int TotalBorrows = 0;
    public static int TotalReturns = 0;

    // Constructor for initializing member information
    public Member(int id, String name, int borrowedCount) {
        this.id = id;
        this.name = name;
        this.borrowedCount = borrowedCount;
    }

    // Check if borrowing is allowed (limit: 5 books)
    private boolean canBorrow() {
        return borrowedCount < 5;
    }

    // Check if returning is allowed
    private boolean canReturn() {
        return borrowedCount > 0;
    }

    // View number of borrowed books
    public void viewBorrowedCount() {
        System.out.println("\n"+ name + " currently has " + borrowedCount + " book(s) borrowed.\n");
        numViewBorrowed++;
        TotalViewBorrowed++;
    }

    // Borrowing a book
    public boolean borrowOne() {
        if (!canBorrow()) {
            System.out.println("\nYou cannot borrow more than 5 books.\n");
            return false;
        }

        borrowedCount++;
        numBorrows++;
        TotalBorrows++;

        sessionFees += 0.50;
        TotalRevenue += 0.50;

        System.out.println("\nBook borrowed successfully! (Fee: 0.50)\n");
        return true;
    }

    // Returning a book
    public boolean returnOne() {
        if (!canReturn()) {
            System.out.println("\nNo books to return.\n");
            return false;
        }

        borrowedCount--;
        numReturns++;
        TotalReturns++;

        System.out.println("\nBook returned successfully!\n");
        return true;
    }

    // Display session summary for current user
    public void displayStatistics() {
        System.out.println("\n===== Session Summary (" + name + ") =====");
        System.out.println("Viewed count:\t" + numViewBorrowed);
        System.out.println("Borrows:\t" + numBorrows);
        System.out.println("Returns:\t" + numReturns);
        System.out.printf("Fees:\t\t%.2f\n", sessionFees);
    }

    // Reset counters for new session
    public void reset() {
        numViewBorrowed = 0;
        numBorrows = 0;
        numReturns = 0;
        sessionFees = 0;
    }

    // Getters
    public String getName() {
        return name;
    }
    
    public int getId() {
    	return id;
    }

}



