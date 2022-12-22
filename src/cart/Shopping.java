package cart;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;

public class Shopping {

public static void main(String[] args) {

    // create an empty list to hold shopping cart items
    List<String> cart = new LinkedList<>();
    Console cons = System.console();
    // flag to control the while loop
    Boolean stop = false;

    System.out.println("Welcome to your shopping cart");

    // keep looping until the user enters the exit command
    while (!stop) {
        // read input from the console
        String line = cons.readLine("> ");
        // command line delimited by space; trim leading and trailing whitespace
        line = line.trim();
        // add apple => ["add", "apple"]
        // list => ["list"]
        // split the input string into an array of terms
        String[] terms = line.split(" ");

        // determine which command the user has entered
        switch (terms[0]) {
            case "list":
                // list command: display the contents of the shopping cart
                if (cart.size() <= 0) {
                    // the cart is empty
                    System.out.println("Your cart is empty");
                } else {
                    // the cart is not empty
                    System.out.println("The contents of your cart");
                    for (Integer idx = 0; idx < cart.size(); idx++)
                        // iterate through the items in the cart and print them
                        System.out.printf("%d. %s\n", idx + 1, cart.get(idx));
                }
                break;

            case "add": // add apple orange pear
                // add command: add an item to the shopping cart
                // Check if add has any items
                cart.add(terms[1]);
                System.out.printf("Added %s to cart\n", terms[1]);
                break;

            case "delete":
                // delete command: remove an item from the shopping cart
                // delete has any number and if the number is valid
                Integer index = Integer.parseInt(terms[1]);
                cart.remove((int)index);
                break;

            case "exit":
                // exit command: set the stop flag to true to exit the loop
                stop = true;
                break;

            default:
                // the user has entered an unknown command
                System.err.printf("Unknown command: %s\n", terms[0]);
        }
    }
    // print a goodbye message
    System.out.println("Thank you for shopping with us. Bye bye.");

    }

}
