import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    public void addParticipant(Participant participant) {
        String sql = "INSERT INTO Participants (participant_name, date_of_birth, contact_number, email, trial_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, participant.getParticipantName());
            statement.setString(2, participant.getDateOfBirth());
            statement.setString(3, participant.getContactNumber());
            statement.setString(4, participant.getEmail());
            statement.setInt(5, participant.getTrialId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM Participants";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                participants.add(new Participant(
                    resultSet.getInt("participant_id"),
                    resultSet.getString("participant_name"),
                    resultSet.getString("date_of_birth"),
                    resultSet.getString("contact_number"),
                    resultSet.getString("email"),
                    resultSet.getInt("trial_id")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }

    public void updateParticipant(Participant participant) {
        String sql = "UPDATE Participants SET participant_name = ?, date_of_birth = ?, contact_number = ?, email = ?, trial_id = ? WHERE participant_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, participant.getParticipantName());
            statement.setString(2, participant.getDateOfBirth());
            statement.setString(3, participant.getContactNumber());
            statement.setString(4, participant.getEmail());
            statement.setInt(5, participant.getTrialId());
            statement.setInt(6, participant.getParticipantId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteParticipant(int id) {
        String sql = "DELETE FROM Participants WHERE participant_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}