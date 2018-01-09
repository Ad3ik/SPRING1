public class UserService{

    private UserRepository URI;
    public UserService(UserRepository UR){
        URI = UR;
    }

    public void addUser(User user)  {
        URI.save(user);
    }

    public User getUser(String username) {
        return URI.findByUsername(username);
    }

    public void removeUser(String username) {
        User user2=URI.findByUsername(username);
        URI.remove(user2);
    }

    public boolean verifyUser(String username, String password) {
        User user2=URI.findByUsername(username);
        if(user2!=null&&user2.getPassword().equals(password)){
            return true;

        }
        return false;
    }
}
