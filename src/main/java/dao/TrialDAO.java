import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ClinicalTrialManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = DatabaseConnection.getConnection()) {
            boolean exit = false;
            while (!exit) {
                System.out.println("Clinical Trial Management System");
                System.out.println("1. Manage Trials");
                System.out.println("2. Manage Participants");
                System.out.println("3. Manage Data Records");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        TrialManagement.manageTrials(scanner, connection);
                        break;
                    case 2:
                        ParticipantManagement.manageParticipants(scanner, connection);
                        break;
                    case 3:
                        DataManagement.manageData(scanner, connection);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
        }
    }
}