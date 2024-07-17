import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataDAO {
    public void addData(Data data) {
        String sql = "INSERT INTO Data (participant_id, data_date, data_value, data_type) VALUES (?, ?, ?, ?)";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, data.getParticipantId());
            statement.setString(2, data.getDataDate());
            statement.setString(3, data.getDataValue());
            statement.setString(4, data.getDataType());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Data> getAllData() {
        List<Data> dataList = new ArrayList<>();
        String sql = "SELECT * FROM Data";
        try (Connection connection = DBConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                dataList.add(new Data(
                    resultSet.getInt("data_id"),
                    resultSet.getInt("participant_id"),
                    resultSet.getString("data_date"),
                    resultSet.getString("data_value"),
                    resultSet.getString("data_type")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dataList;
    }

    public void updateData(Data data) {
        String sql = "UPDATE Data SET participant_id = ?, data_date = ?, data_value = ?, data_type = ? WHERE data_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, data.getParticipantId());
            statement.setString(2, data.getDataDate());
            statement.setString(3, data.getDataValue());
            statement.setString(4, data.getDataType());
            statement.setInt(5, data.getDataId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(int id) {
        String sql = "DELETE FROM Data WHERE data_id = ?";
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}