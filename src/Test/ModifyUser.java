package Test;

public class ModifyUser extends User {
    String modifyData;

    ModifyUser(String username, String password, String modifyData) {
        this.username = username;
        this.password = password;
        this.modifyData = modifyData;
    }

    @Override
    public String toString() {
        return "[" + username + ", " + password + ", " + modifyData + "]";
    }
}
