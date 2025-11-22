/*
LibrarySimulator.java
CSC 111 – Computer Programming I
Project Phase 2
Group Members:
1. Muath Almutairi (ID: 446170719)
2. Saud Albaltan (ID: 446104249)
3. Omar Alshehri (ID: 446102706)
*/

// Github repository: https://github.com/DavJv/CSC-111---Project-Phase-2

import java.util.Scanner;

public class LibrarySimulator {

  public static void main(String[] args) {
	  
    Scanner input = new Scanner(System.in);

    // Predefined Users (Member)
    
    Member user1 = new Member(101, "Muath", 0);
    Member user2 = new Member(102, "Omar", 0);
    Member user3 = new Member(103, "Saud", 0);

    boolean running = true;

    // Account Selection Menu (Member)
    
    while (running) {
      System.out.println("\n===== Welcome to the KSL Library Simulator =====\n");
      System.out.println("\t1. Login as Muath (ID: 101)");
      System.out.println("\t2. Login as Omar (ID: 102)");
      System.out.println("\t3. Login as Saud (ID: 103)");
      System.out.println("\t4. Login as Administrator");
      System.out.println("\t5. Exit program\n");
      System.out.print("Select an option: ");

      int choice = input.nextInt();
      Member currentUser = null;

      // User Selection (Member) - Selecting user account
      
      if (choice == 1) currentUser = user1;
      else if (choice == 2) currentUser = user2;
      else if (choice == 3) currentUser = user3;

      // User session (Member)
      if (currentUser != null) {
    	
    	// Start a new session
    	currentUser.reset(); 
    	
    	System.out.println("\nLogged in as: " + currentUser.getName() + " (ID: " + currentUser.getId() + ")");
    	
        boolean sessionActive = true;

        while (sessionActive) {
          System.out.println("\n===== User Menu (" + currentUser.getName() + ") =====\n");
          System.out.println("\t1. View Borrowed Books Count");
          System.out.println("\t2. Borrow Book");
          System.out.println("\t3. Return Book");
          System.out.println("\t4. View Session Summary");
          System.out.println("\t5. Exit to Main Menu\n");
          System.out.print("Select an option: ");

          int userChoice = input.nextInt();

          switch (userChoice) {

            case 1:
              currentUser.viewBorrowedCount();
              break;

            case 2:
              currentUser.borrowOne();
              break;

            case 3:
              currentUser.returnOne();
              break;

            case 4:
              currentUser.displayStatistics();
              break;

            case 5:
              sessionActive = false;
              System.out.println("\nExiting to Main Menu...\n");
              break;

            default:
              System.out.println("\nInvalid choice. Try again.\n");
          }
          
        }

      }
      
      // Administrator Menu 
      
      else if (choice == 4) {
        
        boolean adminActive = true;
        
        while (adminActive) {

          System.out.println("\n===== Administrator Menu =====\n");
          System.out.println("\t1. View Total Revenue");
          System.out.println("\t2. View Total Operations");
          System.out.println("\t3. Most Frequent Operation");
          System.out.println("\t4. Exit to Main Menu\n");
          System.out.print("Select an option: ");
          
          int adminOption = input.nextInt();

          switch (adminOption) {

            case 1:
				  
            	System.out.printf("\nTotal Revenue:\t%.2f\n", Member.TotalRevenue);
                break;

            case 2:
				  
            	System.out.println("\nTotal View Borrowed Count:\t" + Member.TotalViewBorrowed);
            	System.out.println("Total Borrows:\t\t\t" + Member.TotalBorrows);
            	System.out.println("Total Returns:\t\t\t" + Member.TotalReturns);
            	break;
            	
            case 3:
				  
              if (Member.TotalBorrows > Member.TotalReturns)
                System.out.println("\nMost Frequent Operation: Borrow\n");
              else if (Member.TotalReturns > Member.TotalBorrows)
                System.out.println("\nMost Frequent Operation: Return\n");
              else
                System.out.println("\nBoth operations are equally frequent.\n");
              break;

             case 4:
				  
            	 adminActive = false;
                 System.out.println("\nExiting to Main Menu...\n");
                 break;

            default:
				  
              System.out.println("\nInvalid choice. Try again.\n");
          }
          
        }
        
      }

      // Exit program 
      else if (choice == 5) {
        System.out.println("\nThank you for using the KSL Library Simulator. Have a great day!\n");
        running = false;
      }

      else {
        System.out.println("\nInvalid choice. Try again.\n");
      }
      
    }

    input.close();
    
  }
  
}
