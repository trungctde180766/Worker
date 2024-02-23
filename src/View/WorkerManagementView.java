
package View;
import Model.Worker;
import java.util.Scanner;

public class WorkerManagementView {
    private Scanner scanner;

    public WorkerManagementView() {
        scanner = new Scanner(System.in);
    }

    public int displayMenuAndGetOption() {
        System.out.println("Select an option:");
        System.out.println("1. Add a Worker");
        System.out.println("2. Increase salary for worker");
        System.out.println("3. Decrease salary for worker");
        System.out.println("4. Show adjusted salary worker information");
        System.out.println("5. Quit program");

        return scanner.nextInt();
    }

    public Worker readWorkerDetailsFromUser() {
        System.out.println("Enter worker ID:");
        String id = scanner.nextLine();
        System.out.println("Enter worker name:");
        String name = scanner.nextLine();
        System.out.println("Enter worker age:");
        int age = scanner.nextInt();
        System.out.println("Enter worker salary:");
        double salary = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter worker work location:");
        String workLocation = scanner.nextLine();

        return new Worker(id, name, age, salary, workLocation);
    }

    public String readWorkerIdFromUser() {
        System.out.println("Enter worker ID:");
        return scanner.nextLine();
    }

    public double readAmountFromUser() {
        System.out.println("Enter amount:");
        return scanner.nextDouble();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}

    

