import java.util.ArrayList;
import java.util.List;

public class UserTable {
    private List<User> userList;
    private static UserTable table;

    private UserTable() {
        if(userList == null){
            userList = new ArrayList<>();
            userList.add(new User("ali","123"));
            userList.add(new User("mike","abc"));
            userList.add(new User("paul","456"));
            userList.add(new User("don","123"));
            userList.add(new User("kon","abc"));
        }
    }

    public static UserTable getInstance(){
        if(table == null){
            table = new UserTable();
        }
        return table;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void addUser(User user) {
        userList.add(user);
    }
}
