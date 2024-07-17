import java.util.List;
import java.util.Scanner;

public class ClinicalTrialApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TrialDAO trialDAO = new TrialDAO();
    private static final ParticipantDAO participantDAO = new ParticipantDAO();
    private static final DataDAO dataDAO = new DataDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Clinical Trial Management System");
            System.out.println("1. Add new clinical trial");
            System.out.println("2. View all clinical trials");
            System.out.println("3. Update clinical trial");
            System.out.println("4. Delete clinical trial");
            System.out.println("5. Register new participant");
            System.out.println("6. View all participants");
            System.out.println("7. Update participant information");
            System.out.println("8. Delete participant");
            System.out.println("9. Record trial data for participant");
            System.out.println("10. View all data");
            System.out.println("11. Update data information");
            System.out.println("12. Delete data record");
            System.out.println("13. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    addTrial();
                    break;
                case 2:
                    viewTrials();
                    break;
                case 3:
                    updateTrial();
                    break;
                case 4:
                    deleteTrial();
                    break;
                case 5:
                    registerParticipant();
                    break;
                case 6:
                    viewParticipants();
                    break;
                case 7:
                    updateParticipant();
                    break;
                case 8:
                    deleteParticipant();
                    break;
                case 9:
                    recordData();
                    break;
                case 10:
                    viewData();
                    break;
                case 11:
                    updateData();
                    break;
                case 12:
                    deleteData();
                    break;
                case 13:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addTrial() {
        System.out.print("Enter trial name: ");
        String trialName = scanner.nextLine();
        System.out.print("Enter start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();
        System.out.print("Enter status (Planned, In Progress, Completed): ");
        String status = scanner.nextLine();

        Trial trial = new Trial(trialName, startDate, endDate, status);
        trialDAO.addTrial(trial);
        System.out.println("Trial added successfully.");
    }

    private static void viewTrials() {
        List<Trial> trials = trialDAO.getAllTrials();
        for (Trial trial : trials) {
            System.out.println(trial.getTrialId() + ": " + trial.getTrialName() + " (" + trial.getStartDate() + " to " + trial.getEndDate() + ")");
            System.out.println("Status: " + trial.getStatus());
            System.out.println("-------------------------------");
        }
    }

    private static void updateTrial() {
        System.out.print("Enter trial ID to update: ");
        int trialId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter new trial name: ");
        String trialName = scanner.nextLine();
        System.out.print("Enter new start date (YYYY-MM-DD): ");
        String startDate = scanner.nextLine();
        System.out.print("Enter new end date (YYYY-MM-DD): ");
        String endDate = scanner.nextLine();
        System.out.print("Enter new status (Planned, In Progress, Completed): ");
        String status = scanner.nextLine();

        Trial trial = new Trial(trialId, trialName, startDate, endDate, status);
        trialDAO.updateTrial(trial);
        System.out.println("Trial updated successfully.");
    }

    private static void deleteTrial() {
        System.out.print("Enter trial ID to delete: ");
        int trialId = scanner.nextInt();
        trialDAO.deleteTrial(trialId);
        System.out.println("Trial deleted successfully.");
    }

    private static void registerParticipant() {
        System.out.print("Enter participant name: ");
        String participantName = scanner.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter trial ID: ");
        int trialId = scanner.nextInt();

        Participant participant = new Participant(participantName, dateOfBirth, contactNumber, email, trialId);
        participantDAO.addParticipant(participant);
        System.out.println("Participant registered successfully.");
    }

    private static void viewParticipants() {
        List<Participant> participants = participantDAO.getAllParticipants();
        for (Participant participant : participants) {
            System.out.println(participant.getParticipantId() + ": " + participant.getParticipantName() + " (DOB: " + participant.getDateOfBirth() + ")");
            System.out.println("Contact: " + participant.getContactNumber() + ", Email: " + participant.getEmail());
            System.out.println("Trial ID: " + participant.getTrialId());
            System.out.println("-------------------------------");
        }
    }

    private static void updateParticipant() {
        System.out.print("Enter participant ID to update: ");
        int participantId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter new participant name: ");
        String participantName = scanner.nextLine();
        System.out.print("Enter new date of birth (YYYY-MM-DD): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Enter new contact number: ");
        String contactNumber = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new trial ID: ");
        int trialId = scanner.nextInt();

        Participant participant = new Participant(participantId, participantName, dateOfBirth, contactNumber, email, trialId);
        participantDAO.updateParticipant(participant);
        System.out.println("Participant updated successfully.");
    }

    private static void deleteParticipant() {
        System.out.print("Enter participant ID to delete: ");
        int participantId = scanner.nextInt();
        participantDAO.deleteParticipant(participantId);
        System.out.println("Participant deleted successfully.");
    }

    private static void recordData() {
        System.out.print("Enter participant ID: ");
        int participantId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter data date (YYYY-MM-DD): ");
        String dataDate = scanner.nextLine

System.out.print("Enter data date (YYYY-MM-DD): ");
        String dataDate = scanner.nextLine();
        System.out.print("Enter data value: ");
        String dataValue = scanner.nextLine();
        System.out.print("Enter data type: ");
        String dataType = scanner.nextLine();

        Data data = new Data(participantId, dataDate, dataValue, dataType);
        dataDAO.addData(data);
        System.out.println("Data recorded successfully.");
    }

    private static void viewData() {
        List<Data> dataList = dataDAO.getAllData();
        for (Data data : dataList) {
            System.out.println(data.getDataId() + ": Participant ID " + data.getParticipantId() + " on " + data.getDataDate());
            System.out.println("Value: " + data.getDataValue() + ", Type: " + data.getDataType());
            System.out.println("-------------------------------");
        }
    }

    private static void updateData() {
        System.out.print("Enter data ID to update: ");
        int dataId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter new participant ID: ");
        int participantId = scanner.nextInt();
        scanner.nextLine();  // consume newline

        System.out.print("Enter new data date (YYYY-MM-DD): ");
        String dataDate = scanner.nextLine();
        System.out.print("Enter new data value: ");
        String dataValue = scanner.nextLine();
        System.out.print("Enter new data type: ");
        String dataType = scanner.nextLine();

        Data data = new Data(dataId, participantId, dataDate, dataValue, dataType);
        dataDAO.updateData(data);
        System.out.println("Data updated successfully.");
    }

    private static void deleteData() {
        System.out.print("Enter data ID to delete: ");
        int dataId = scanner.nextInt();
        dataDAO.deleteData(dataId);
        System.out.println("Data deleted successfully.");
    }
}