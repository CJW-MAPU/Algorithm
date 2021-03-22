package Test;

public class Process {
    public static void main(String[] args) {
        ModifyUser modifyUser = new ModifyUser("1", "2", "3");
        RemoveUser removeUser = new RemoveUser("2", "3", "4");

        PrintObjectData(modifyUser);
        PrintObjectData(removeUser);
    }

    public static void PrintObjectData(User user) {
        System.out.println(user.toString());
    }

    public static User Transaction() {
        return service.method();
    }
}