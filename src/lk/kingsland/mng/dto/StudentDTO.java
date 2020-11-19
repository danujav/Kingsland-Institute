package lk.kingsland.mng.dto;

public class StudentDTO {
        private String id;
        private String studentName;
        private String address;
        private String contact;
        private String dob;
        private String gender;

        public StudentDTO() {
        }

        public StudentDTO(String id, String studentName, String address, String contact, String dob, String gender) {
            this.setId(id);
            this.setStudentName(studentName);
            this.setAddress(address);
            this.setContact(contact);
            this.setDob(dob);
            this.setGender(gender);
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getContact() {
            return contact;
        }

        public void setContact(String contact) {
            this.contact = contact;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", studentName='" + studentName + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}


