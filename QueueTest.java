import java.util.NoSuchElementException;
import java.util.Scanner;

public class QueueTest {
    public static void main(String[] args) {
        Queue<Integer> testQueue = new Queue<>();
        Scanner userInput = new Scanner(System.in);
        char menuInput;
        boolean menuFlag = true;

        //  shows user current items in queue in order
        //  prompts user for input and commits operations based on input
        do {
            //  initial queue visual and prompt
            queueVisual(testQueue);
            System.out.print("(a)dd an item to the queue | (r)emove an item from the queue | (q)uit\n>");
            menuInput = userInput.next().toLowerCase().charAt(0);

            //  checks user's input
            switch(menuInput) {
                //  if nothing exists in the queue catch exception and 
                case('a'):
                    try {
                        testQueue.enqueue(getNextItem(testQueue)+1);
                    } catch (NoSuchElementException e) {
                    }
                    break;
                case('r'):
                    try {
                        testQueue.dequeue();
                    } catch (NoSuchElementException e) {
                        System.out.println("Error, the queue is empty\n\n");
                    }
                    break;
                case('q'):
                    menuFlag = false;
                    break;
                default:
                    System.out.println("Please enter a valid input\n\n");
            }
        } while (menuFlag);
    }

    public static void queueVisual(Queue<Integer> testQueue) {
        String queueItems = "";
        Queue<Integer> tempQueue = new Queue<>();
        int testQueueSize = testQueue.getSize();

        for (int i = 0; testQueueSize > i; i++) {
            queueItems += " " + testQueue.peek();
            tempQueue.enqueue(testQueue.dequeue());
        }

        int tempQueueSize = tempQueue.getSize();
        for (int i = 0; tempQueueSize > i; i++) {
            testQueue.enqueue(tempQueue.dequeue());
        }
        if (queueItems.equals("")) {
            System.out.println("START - END\nThe queue is currently empty");
        } else {
            System.out.printf("%n%s%s%s%n", "START", queueItems, " END");
        }
    }

    public static int getNextItem(Queue<Integer> testQueue) {
        Queue<Integer> tempQueue = new Queue<>();
        int testQueueSize = testQueue.getSize();
        int nextItem = 0;

        for (int i = 0; testQueueSize > i; i++) {
            if (testQueueSize == 1 && testQueue.peek() > 0) {
                nextItem = testQueue.peek();
            }
            tempQueue.enqueue(testQueue.dequeue());
            if (i+2 == testQueueSize) {
                nextItem = testQueue.peek();
            }
        }

        int tempQueueSize = tempQueue.getSize();
        for (int i = 0; tempQueueSize > i; i++) {
            testQueue.enqueue(tempQueue.dequeue());
        }

        return nextItem;
    }
}
