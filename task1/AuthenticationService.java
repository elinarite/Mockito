package mockito.task1;
//Создайте класс AuthenticationService, который зависит от класса UserRepository. UserRepository содержит метод getUserById(String userId),
// возвращающий объект User по идентификатору пользователя. Напишите тест, используя Mockito,
// чтобы убедиться, что метод getUserById был вызван с правильным идентификатором пользователя.

import java.util.Optional;

public class AuthenticationService {
    private UserRepository UserRepository;

    public AuthenticationService() {
    }

    public AuthenticationService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public Optional<User> authenticateUser(String userID) {
        User user = UserRepository.getUserById(userID);
        return Optional.ofNullable(user);
    }
}