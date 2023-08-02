package Akme.model;


public class UserModel {
    private String username;
    private String password;
    private int userId;
    private String firstName;
    private String lastName;
    private String middleName;

        public UserModel(int userId, String username, String password, String firstName, String lastName, String middleName) {
            this.userId = userId;
            this.username = username;
            this.password = password;
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
        }


        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public void setUsername(String username) {
        this.username = username;
    }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public boolean authenticate(String username, String password) {
            return this.username.equals(username) && this.password.equals(password);
        }
    }