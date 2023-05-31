package mockito.task1;

//Task1 Создайте класс UserService, который зависит от класса UserRepository.
// UserRepository содержит метод saveUser(User user), сохраняющий пользователя в базе данных.
// Напишите тест, используя Mockito, чтобы убедиться, что метод saveUser был вызван с корректным пользователем.

////Создайте класс UserService, который зависит от класса UserRepository.
//// UserRepository содержит метод getUserByEmail(String email),
//// возвращающий объект User по электронной почте. Напишите тест, используя Mockito,
//// чтобы убедиться, что метод getUserByEmail был вызван с правильной электронной почтой и
//// обработан правильно.

//
public class UserService {

    private UserRepository userRepository;

    public UserService() {
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User userPerEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}