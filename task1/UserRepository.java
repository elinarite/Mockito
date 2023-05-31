package mockito.task1;

public interface UserRepository {

    void saveUser(User user);
    User getUserById(String userID);
   User getUserByEmail(String email);
}