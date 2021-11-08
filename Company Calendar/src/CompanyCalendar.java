// This program will help customers pick out a delivery date  (Jade Park - 6/21/2021)

import java.util.Scanner;

public class CompanyCalendar { 
   public static void main(String[] args) {
      
      // Declaring the flag variable that will change values depending on the user input & if the loop must be repeated
      boolean flag = true;
      
      // Declaring variables that will eventually be assigned to what the user inputs
      int deliveryDay;
      int deliveryMonth;
      int deliveryYear;
      
      int productSelection;
      char firstDecision;
      char secondDecision = 'Y';
      char thirdDecision;
      
      Scanner input = new Scanner(System.in);
   
      // Creating a do-while loop
      do {
         // The initial message given to the user displaying the options on what they can purchase
         System.out.println("\nWelcome to Starr! You will be prompted to enter the product you'd like to purchase along with your requested delivery date. \nHere are the products you may purchase below.");
         System.out.println("\n1 - Unlimited Review Access: $30");
         System.out.println("2 - No Ads: $15");
         System.out.println("3 - Profile and Layout Customization: $10");
         System.out.println("4 - Annual Membership: $45");
         
         // Letting the user input a number that refers to the product they want to purchase
         System.out.print("\nPlease make your first selection from the options provided above (ex. 1): ");
         // Storing that input value to a variable we declared at the start
         productSelection = input.nextInt();
         
         // Creating a while loop that forces the user to input a valid value if they didn't earlier
         while (productSelection > 4 || productSelection < 1) {
            System.out.print("\nYour selection was not valid. Please re-enter: ");
            productSelection = input.nextInt();
         }
         
         // Assigning the user inputs for the delivery date to pre-declared variables
         System.out.print("\nPlease enter the delivery month (a number betweeen 1-12): ");
         deliveryMonth = input.nextInt();
         
         while (deliveryMonth > 12 || deliveryMonth < 1) {
            System.out.print("\nYour input was not valid. Please re-enter: ");
            deliveryMonth = input.nextInt();
         }
         
         System.out.print("\nPlease enter the delivery day (a number betweeen 1-31): ");
         deliveryDay = input.nextInt();
         
         while (deliveryDay > 31 || deliveryMonth < 1) {
            System.out.print("\nYour input was not valid. Please re-enter: ");
            deliveryDay = input.nextInt();
         }

         System.out.print("\nPlease enter the delivery year: ");
         deliveryYear = input.nextInt();
         
         // Confirming they want to move on or re-enter a new date with the help of an if-else statement
         System.out.print("\nDo you want to continue or enter a new date? Y - Continue; N - New Date: ");
         firstDecision = input.next().charAt(0);
         
         if (firstDecision == 'Y') {
            flag = false;
         } else {
            flag = true;
         }
         
         // Accounting for block-out dates and letting the user re-enter a new date or quit the program if this occurs
         if (deliveryDay == 1 && deliveryMonth == 1 || deliveryDay == 20 && deliveryMonth == 3 || deliveryDay == 22 && deliveryMonth == 4 || deliveryDay == 1 && deliveryMonth == 5 || deliveryDay == 5 && deliveryMonth == 6 || deliveryDay == 2 && deliveryMonth == 8 || deliveryDay == 31 && deliveryMonth == 12) {
            System.out.println("\nWe are unable to process your order because you have selected a block out date.");
            System.out.print("Press Y to enter a new date or N to quit the program: ");
            secondDecision = input.next().charAt(0);
            
            if (secondDecision == 'N') {
               flag = false;
               System.exit(0);
            } else {
               flag = true;
            }
         }
         
         // Declaring new variables that'll help with the order summary
         String selectedProductName = "";
         String deliveryMonthStatement = "";
         
         // Switch statement assigning a value to selectedProductName
         switch (productSelection) {
            case 1:
               selectedProductName = "Unlimited Review Access: $30";
               break;
            case 2:
               selectedProductName = "No Ads";
               break;
            case 3:
               selectedProductName = "Profile and Layout Customization";
               break;   
            case 4:
               selectedProductName = "Annual Membership";
               break;   
         }
         
         // Switch statement assigning a value to deliveryMonthStatement
         switch (deliveryMonth) {
            case 1:
               deliveryMonthStatement = "January";
               break;
            case 2:
               deliveryMonthStatement = "February";
               break;
            case 3:
               deliveryMonthStatement = "March";
               break;   
            case 4:
               deliveryMonthStatement = "April";
               break;  
            case 5:
               deliveryMonthStatement = "May";
               break;  
            case 6:
               deliveryMonthStatement = "June";
               break;  
            case 7:
               deliveryMonthStatement = "July";
               break;
            case 8:
               deliveryMonthStatement = "August";
               break;
            case 9:
               deliveryMonthStatement = "September";
               break;   
            case 10:
               deliveryMonthStatement = "October";
               break;  
            case 11:
               deliveryMonthStatement = "November";
               break;  
            case 12:
               deliveryMonthStatement = "December";
               break;  
         }
         
         // Outputting to the user a summary and a chance to confirm or restart
         if (flag == false) {
             System.out.println("\nSummary: You selected the " + selectedProductName + " package to be delivered on " + deliveryMonthStatement + " " + deliveryDay + ", " + deliveryYear);
            System.out.print("\nDo you want to proceed or enter a new date? Y - Proceed; N - New Date: ");
            thirdDecision = input.next().charAt(0);
            
            // Final statements that only executed once there are no errors and if the user previously confirmed to continue to this step
            if (thirdDecision == 'Y') {
               flag = false;
               System.out.println("\nYou chose the " + selectedProductName + " package to be delivered on " + deliveryMonthStatement + " " + deliveryDay + ", " + deliveryYear);
               System.out.println("Congrats! Your delivery date of " + deliveryMonthStatement + " " + deliveryDay + ", " + deliveryYear + " has been scheduled.");
            } else {
               flag = true;
            }

         }
         
      } while (flag == true);
   }
}