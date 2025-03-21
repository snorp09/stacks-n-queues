import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class StackDemo {

    /*
     * Fills the stack with random integer values.
     */
    public static void fillStack(Stack<Integer> stack){
        Random rand = new Random();
        while(stack.getCurrentLocation() != stack.getSize()){
            stack.push(rand.nextInt(100));
        }
    }

    /*
     * Prints the value of the stack, by swapping the values between two stacks.
     * The new stack will contain the original stack upside down
     * So we need to reinsert the data back into the original stack to correct the direction.
     */
    public static void printStack(Stack<Integer> stack){
        Stack<Integer> newStack = new Stack<>(Integer.class, 12);
        while(stack.getCurrentLocation() != 0){
            System.out.printf("|   %-5d|\n", stack.peek());
            System.out.printf("| ------ |\n");
            newStack.push(stack.pop());
        }
        while(newStack.getCurrentLocation() != 0){
            stack.push(newStack.pop());
        }
    }

    /*
     * Removes a value from the stack.
     */
    public static void popStack(Stack<Integer> stack){
        if(stack.getCurrentLocation() == 0){
            System.out.println("Can't pop! There's nothing left!");
            return;
        }
        System.out.printf("Number %d removed from stack.\n", stack.pop());
    }

    /*
     * Adds an integer to the stack.
     */
    public static void insertStack(Stack<Integer> stack){
        if(stack.getCurrentLocation() == stack.getSize()){
            System.out.println("Can't add to stack! It'll overflow!");
            return;
        }
        Scanner intScanner = new Scanner(System.in);
        while(true){
            System.out.print("New int to add> ");
            try{
                stack.push(intScanner.nextInt());
                break;
            } catch(InputMismatchException e){
                System.out.println("Please only enter integers.");
            }
        }
    }

    /*
     * Our menu, with branching code paths depending upon which menu option the user selects.
     */
    public static void stackOptions(Stack<Integer> stack){
        boolean running = true;
        while(running){
            printStack(stack);
            System.out.println("p.) Pop Stack");
            System.out.println("i.) Insert into stack");
            System.out.println("x.) Exit.");
            char choiceChar;
            Scanner choiceScan = new Scanner(System.in);
            System.out.print("Menu choice> ");
            choiceChar = choiceScan.nextLine().toLowerCase().charAt(0);
            switch (choiceChar) {
                case 'p' :
                    popStack(stack);
                    break;
                case 'i':
                    insertStack(stack);
                    break;
                case 'x':
                    running = false;
                    break;
                default:
                    System.out.println("Please make a valid selection.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Stack<Integer> numbStack = new Stack<>(Integer.class, 12);
        fillStack(numbStack);
        stackOptions(numbStack);
    }
}
