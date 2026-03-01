import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        boolean running = true;

        System.out.println("=================================");
        System.out.println("  Welcome to your To-Do List ");
        System.out.println("  Let’s organize your day!");
        System.out.println("=================================");

        while (running) {

            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Add a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Remove a task");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println(" Please enter a valid number.");
                scanner.next(); 
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {

                case 1:
                    System.out.print(" Write your new task: ");
                    String task = scanner.nextLine();
                    tasks.add(task);
                    System.out.println(" Task added successfully!");
                    break;

                case 2:
                    if (tasks.isEmpty()) {
                        System.out.println("📭 Your list is empty.");
                    } else {
                        System.out.println("\n Your Tasks:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }
                    }
                    break;

                case 3:
                    if (tasks.isEmpty()) {
                        System.out.println("⚠ No tasks to remove.");
                    } else {
                        System.out.println("Enter task number to remove:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println((i + 1) + ". " + tasks.get(i));
                        }

                        if (!scanner.hasNextInt()) {
                            System.out.println(" Invalid input.");
                            scanner.next();
                            break;
                        }

                        int removeIndex = scanner.nextInt();

                        if (removeIndex > 0 && removeIndex <= tasks.size()) {
                            System.out.println("🗑 Removed: " + tasks.get(removeIndex - 1));
                            tasks.remove(removeIndex - 1);
                        } else {
                            System.out.println(" Invalid task number.");
                        }
                    }
                    break;

                case 4:
                    System.out.println(" Goodbye! Stay productive!");
                    running = false;
                    break;

                default:
                    System.out.println(" Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}

