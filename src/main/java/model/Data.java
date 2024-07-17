public class Data {
    private int dataId;
    private int participantId;
    private String dataDate;
    private String dataValue;
    private String dataType;

    public Data(int participantId, String dataDate, String dataValue, String dataType) {
        this.participantId = participantId;
        this.dataDate = dataDate;
        this.dataValue = dataValue;
        this.dataType = dataType;
    }

    public Data(int dataId, int participantId, String dataDate, String dataValue, String dataType) {
        this.dataId = dataId;
        this.participantId = participantId;
        this.dataDate = dataDate;
        this.dataValue = dataValue;
        this.dataType = dataType;
    }

    // Getters and setters
    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}