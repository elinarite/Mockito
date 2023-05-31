package mockito.test;

import mockito.task1.AuthenticationService;
import mockito.task1.User;
import mockito.task1.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.Mockito.times;

//Создайте класс AuthenticationService, который зависит от класса UserRepository. UserRepository содержит метод
// getUserById(String userId), возвращающий объект User по идентификатору пользователя. Напишите тест,
// используя Mockito, чтобы убедиться, что метод getUserById был вызван с правильным идентификатором пользователя.
class AuthenticationServiceTest {
    mockito.task1.UserRepository UserRepository = Mockito.mock(UserRepository.class);
    AuthenticationService authenticationService = new AuthenticationService(UserRepository);

    @Test
    void test() {
        String userId = "123";
        User test = new User(userId);
        Mockito.when(UserRepository.getUserById(userId)).thenReturn(test);
        Optional<User> actualUser = authenticationService.authenticateUser(userId);
        Assertions.assertEquals(Optional.of(test), actualUser);
        Mockito.verify(UserRepository, times(1)).getUserById(userId);
    }
}