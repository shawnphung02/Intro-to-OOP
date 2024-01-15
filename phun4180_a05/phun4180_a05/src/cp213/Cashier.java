package cp213;

import java.util.Scanner;

/**
 * Wraps around an Order object to ask for MenuItems and quantities.
 *
 * @author Shawn Phung
 * @author Abdul-Rahman Mawlood-Yunis
 * @author David Brown
 * @version 2022-11-20
 */
public class Cashier {

    // Attributes
    private Menu menu = null;

    /**
     * Constructor.
     *
     * @param menu A Menu.
     */
    public Cashier(Menu menu) {
	this.menu = menu;
    }

    /**
     * Prints the menu.
     */
    private void printCommands() {
	System.out.println("\nMenu:");
	System.out.println(menu.toString());
	System.out.println("Press 0 when done.");
	System.out.println("Press any other key to see the menu again.\n");
    }

    /**
     * Asks for commands and quantities. Prints a receipt when all orders have been
     * placed.
     *
     * @return the completed Order.
     */
    public Order takeOrder() {
    	System.out.println("Welcome to WLU Foodorama!");
	
    	boolean not_done = true;
    	printCommands();
    	Order order = new Order();
    	Scanner read = new Scanner(System.in);
		
		do {
			int input1 = -1, input2 = 0;
			
			System.out.println("Command: ");
			if(read.hasNextInt()) {
				input1 = read.nextInt();
			}else {
				System.out.println("Not a valid number");
				read.next();
			}
			// Invalid index
			if(input1 < 0 || input1 > this.menu.size()) {
				printCommands();
			}else if(input1 > 0 && input1 <= this.menu.size()) {
				System.out.println("How many do you want? ");
				if(read.hasNextInt()) {
					input2 = read.nextInt();
					if(input2 > 0) {
						MenuItem item = this.menu.getItem(input1 - 1);
						order.add(item, input2);
					}
				}
			}else {
				not_done = false;
			}
			
		}while(not_done);
		System.out.println("----------------------------------------");
		System.out.println("Receipt:");
		System.out.println(order.toString());
		read.close();
		
		return order;
    }
}