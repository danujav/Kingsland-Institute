package lk.kingsland.mng.dto;

public class RegistrationDTO {
    private String regDate;
    private double regFee;
    private String studentId;
    private String courseCode;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String regDate, double regFee, String studentId, String courseCode) {
        this.setRegDate(regDate);
        this.setRegFee(regFee);
        this.setStudentId(studentId);
        this.setCourseCode(courseCode);
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", studentId='" + studentId + '\'' +
                ", courseCode='" + courseCode + '\'' +
                '}';
    }

}
