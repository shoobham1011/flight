package airline.management.system;

public class User {
    String full_name;
    String user_name;
    String email;
    String password;
    String conform_password;

    public User(String full_name, String user_name, String email, String password, String conform_password) {
        this.full_name = full_name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.conform_password = conform_password;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name =user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String  getConform_password() {
        return  conform_password;
    }

    public void  setConform_password(String  conform_password) {
        this. conform_password =  conform_password;
    }
}
