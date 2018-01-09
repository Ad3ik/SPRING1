import java.util.ArrayList;

public class UserRepository{
    private ArrayList <User> UserList;

    public UserRepository(ArrayList <User> UL){
        UserList = UL;
    }

    public User findByUsername(String username) {
        for (User u :UserList)
            if (u.getUsername().equals(username)) {
                return u;
            }
        return null;
    }

    public void save(User user1) {
        UserList.add(user1);

    }

    public void remove(User user1) {
        UserList.remove(user1);
    }


}
