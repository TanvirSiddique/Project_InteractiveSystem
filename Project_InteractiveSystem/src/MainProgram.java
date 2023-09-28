import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainProgram {

   //1. User interface: Should display a menu
   //2. When tickets for an activity  are ordered(input):
   //   - check whether the customer is a valid customer.
   //   - check whether the activity is on the list of the available activities.
   //   - if NOT for both the above there should be an error message printed.
   //   - if the request is a valid one, the program should check whether there are enough tickets left for the ordered activity.
   //   - can assume that in one transaction a customer orders tickets for one activity.
   //   - if the tickets are not available (or there are not enough tickets), a note(in the form of a letter) should be printed
   //     to a file informing the customer that the tickets are not available;no other errors should be logged to letters.txt.
    //  - may assume that the order is either fully satisfied or not carried out at all.
   //   - if the ordered number of tickets is available, the transaction should be processed and the stored information
   //     should be updated accordingly.
   // 3. Do general input validation.
   // 4. When tickets/(a ticket) are(/is) is cancelled by a customer:
   //   - check whether the customer is a valid customer.
   //   - check whether the activity specified by the tickets is on the list of activities.
   //   - check whether the tickets have been purchased by this customer.
   //   - if NOT, an appropriate message should be displayed on the screen.
   //   - if the request is a valid one, the stored information should be updated accordingly.
   //   - can assume that a customer can cancel tickets for only one activity per one transaction.
   //   - if a customer has tickets for an activity, they should be able to cancel one,some or all of their
   //     tickets for that activity in a single transaction(your program should ask them how many tickets they want to cancel).
   //   - assume that the ticket office only sells the tickets initially allocated to it;
   //   - assume that the ticket office serves only its registered customers and processes transactions sequentially.
   //   - assume no tickets has been sold so far when the program first starts.

    static SortedArrayList<Customer> hotelCustomers = new SortedArrayList<Customer>();
    static SortedArrayList<Activity> hotelActivities = new SortedArrayList<Activity>();


    public static void main(String[] args) throws IOException {

        //Read the input file
        readFile();

        //Input for the consule
        Scanner scanner = new Scanner(System.in);

        PrintWriter outfile = null;
        try{
          File f = new File("letters.txt");
          if (f.exists() == false) {
              System.out.println("Output file letters.txt not found!");
              System.out.println("Creating letters.txt ...");
              f.createNewFile();

          } else {
              System.out.println("Output file letter.txt found!");
          }
            outfile = new PrintWriter("letters.txt");
        } catch (Exception e) {
            throw e;
        }

        boolean programExits = false;
        while (programExits == false) {
            printMainMenu();
            try {
                String letterInput = scanner.nextLine();
                switch(letterInput) {
                    case "f" :
                        programExits = true;
                        break;
                    case "a" :
                        printActivities();
                        break;
                    case "c":
                        printCustomers();
                        break;
                    case "t":
                        buyTickets(scanner);
                        break;
                    case "r":
                        cancelTicket(scanner);
                        break;

                }

            } catch ( Exception e) {};


        }


    //Main Menu
        /*

        The program should display a menu on the screen. The list is as follows:
        - f : to finish running the program.
           -> Exit the program
        - a : to display on the screen information about all the activities.
           -> Print all the activities ( activities name, noOfTickets available for each activity )
        - c : to display on the screen information about all the customers.
           -> Print all information about customers (customers' firstName & lastName; Also no of activities selected and the purchased tickets for each activity)
        - t : to update the stored data when tickets are bought by one of the registered customers.
           -> Input of customer firstName & lastName
           -> Input of chosen activity name that is available
           -> Input of intended purchase of tickets by the customer for the chosen activity
           -> Do stored data validation - customer & activity (compare with their respective arraylist)
           -> check the available tickets of the chosen activity
           -> Update the ticketCount - addActivity for the respective customers (SortedArrayList<Customer> customers)
           -> Update the ticketCount - SortedArrayList<Activity> activities.
        - r : to update the stored data when a registered customer cancels tickets for a booking.
           -> Input of customer firstName & lastName
           -> Input of chosen activity
           -> Input of tickets for cancellation by the customer for the chosen activity
           -> Do stored data validation - customer & activity (compare with their respective arraylist)
           -> check the purchase tickets of customers for the chosen activity
           -> Update the ticketCount - removeActivity for the respective customers (SortedArrayList<Customer> customers)
           -> Update the ticketCount - SortedArrayList<Activity> activities.
         */

    }
    private static void printActivities() {
        System.out.println(hotelActivities);
    }

    private static void printCustomers() {
        System.out.println(hotelCustomers);
    }

    private static void buyTickets(Scanner scanner) {
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String activityName = scanner.nextLine();
        int noOfTickets = scanner.nextInt();
        //int abc = Integer.parseInt(scanner.nextLine());

        //Data validation for the customer
        Customer tempCustomer = new Customer(firstName, lastName);
        boolean customerFound = false;
        //Customer is the object type of the object c
        for (Customer c: hotelCustomers) {
            if (c.compareTo(tempCustomer) == 0 ) {
                tempCustomer = c;
                customerFound = true;
            }
        }
        if (customerFound == false) {
            System.out.println("Customer NOT FOUND");
        }

        // Data validation for the activity
        Activity tempActivity = new Activity(activityName, noOfTickets);
        boolean activityFound = false;
        for (Activity a: hotelActivities) {
            if (a.compareTo(tempActivity) == 0) {
                tempActivity = a;
                activityFound = true;
            }
        }
        if (activityFound == false) {
            System.out.println("Activity NOT FOUND");
        }

        if(tempActivity.getTickets() >= noOfTickets) {
            // Update the ticketCount for customer - addActivity for the respective customers (SortedArrayList<Customer> customers)
            tempCustomer.addActivity(new Activity(activityName, noOfTickets));
            // Update the ticketCount for hotel....
            tempActivity.setTickets(tempActivity.getTickets() - noOfTickets);
        } else {
            System.out.println("NOT enough tickets available");
        }
    }

    private static void cancelTicket (Scanner scanner) {
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String activityName = scanner.nextLine();
        int numberedTickets = scanner.nextInt();
        //int anotherWay = Integer.parseInt(scanner.nextLine());

        //Data validation for the customer
        Customer tempObjCustomer = new Customer(firstName, lastName);
        boolean customerExists = false;
        //Customer is the object type of the object c
        for (Customer c: hotelCustomers) {
            if (c.compareTo(tempObjCustomer) == 0) {
                tempObjCustomer = c;
                customerExists = true;
            }
        }
        if (customerExists == false) {
            System.out.println("Customer NOT FOUND");
        }

        //Data validation for the hotel activity
        Activity tempObjActivity = new Activity(activityName, numberedTickets);
        boolean activityExists = false;
        for (Activity a: hotelActivities) {
            if (a.compareTo(tempObjActivity) == 0) {
                tempObjActivity = a;
                activityExists = true;
            }
        }
        if (activityExists == false) {
           System.out.println("Hotel Activity NOT FOUND");
        }

        //Data validation for the Customer activity
        Activity customerSideActivity = new Activity(activityName, numberedTickets);
        boolean customerActivityExists = false;
        for (Activity a: tempObjCustomer.getActivities()) {
            if (a.compareTo(customerSideActivity) == 0) {
                customerSideActivity = a;
                customerActivityExists = true;
            }
        }
        if (customerActivityExists = false) {
            System.out.println("Customer Activity NOT FOUND");
        }

        if(customerSideActivity.getTickets() >= numberedTickets) {
            //Update the ticketCount for customer
            tempObjCustomer.removeActivity(new Activity(activityName, numberedTickets));
            // Update the ticketCount for hotel....
            tempObjActivity.setTickets(tempObjActivity.getTickets() + numberedTickets);

        } else {
            System.out.println("Error!!");
        }

    }

    private static void readFile() {
        try {
            Scanner sc = new Scanner(new File("input.txt"));
            //In the input.txt file:
            //First Line represents No. of activities;
            //Next few are Activtiy Names followed by their respective ticket count;
            //After all the activities listed (with their ticket count) we have the total customer count;
            //Last few are the Customer Names;
            int noOfActivities = Integer.parseInt(sc.nextLine());
            System.out.println(noOfActivities);
            for ( int i = 0; i < noOfActivities; i++ ) {
                String activityName = sc.nextLine();
//                int activityTickets = sc.nextInt();
                String activityTickets = sc.nextLine();
                Activity newObjActivity = new Activity(activityName, Integer.parseInt(activityTickets));
                hotelActivities.add(newObjActivity);
            }
            int noOfCustomers = Integer.parseInt(sc.nextLine());
            System.out.println(noOfCustomers);
            for (int i = 0; i < noOfCustomers; i++) {
                String fullName = sc.nextLine();
                //String[] known as array of strings...
                String[] fn = fullName.split(" ");
                String firstName = fn[0];
                String lastName = fn[1];
                Customer newObjCustomer = new Customer(firstName, lastName);
                hotelCustomers.add(newObjCustomer);
            }
            hotelActivities.insertionSort();
            hotelCustomers.insertionSort();
        } catch (Exception e) {};
    }

    private static void printMainMenu() {
        System.out.println("\n------------------------------------------------------");
        System.out.println("Type the letter to choose from the option below: ");
        System.out.println(" f - finish running the program");
        System.out.println(" a - print activity list ");
        System.out.println(" c - print customer list and their information");
        System.out.println(" t - purchase ticket for an activity");
        System.out.println(" r - refund ticket for an activity");
        System.out.println("------------------------------------------------------");
        System.out.print("Enter a letter> ");

    }












}
