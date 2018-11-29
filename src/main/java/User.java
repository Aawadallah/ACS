import java.time.LocalDate;
import java.util.Date;

public class User {
    private int ID;
    private String name;
    private String userName;
    private String password;
    private String email;
    private String dateOffRegister;


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfRegister='" + dateOffRegister + '\'' +
                '}';
    }

    public String getDate() {
        return dateOffRegister;
    }

    public void setDate(String date) {
        this.dateOffRegister = date;
    }

    public static class UserBuilder {
        private final User user = new User();
        public UserBuilder setID(int id) {
            user.setID(id);
            return this;  }

        public UserBuilder setName(String name) {
            user.setName(name);
            return this ; }

        public UserBuilder setUserName(String userName) {
            user.setUserName(userName);
            return this;
        }

        public UserBuilder setPassword(String password) {
            user.setPassword(password);
            return this;
        }

        public UserBuilder setEmail(String email) {
            user.setEmail(email);
            return this;
        }
        public UserBuilder setDateOfRegister() {
            String date = LocalDate.now().toString();
            user.setDate(date);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
