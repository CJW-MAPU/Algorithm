package Test;

public class RemoveUser extends User {
    String removeData;

    RemoveUser(String username, String password, String removeData) {
        this.username = username;
        this.password = password;
        this.removeData = removeData;
    }

    @Override
    public String toString() {
        return "[" + username + ", " + password + ", " + removeData + "]";
    }
}