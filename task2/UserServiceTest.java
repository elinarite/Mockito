package mockito.task2;
//Создайте класс UserService, который зависит от класса UserRepository.
// UserRepository содержит метод saveUser(User user), сохраняющий пользователя в
// базе данных. Напишите тест, используя Mockito, чтобы убедиться, что метод saveUser
// был вызван с корректным пользователем.

//Создайте класс UserService, который зависит от класса UserRepository.
// UserRepository содержит метод getUserByEmail(String email),
// возвращающий объект User по электронной почте. Напишите тест, используя Mockito,
// чтобы убедиться, что метод getUserByEmail был вызван с правильной электронной почтой и
// обработан правильно.


import mockito.task1.User;
import mockito.task1.UserRepository;
import mockito.task1.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;

class UserServiceTest {

    UserRepository newUserRepo = mock(UserRepository.class);
    UserService userService = new UserService(newUserRepo);

    User user = mock(User.class);
    List<User> userList = new ArrayList<>();


    @BeforeEach
    void saveUserBehavior() {
        Mockito.doAnswer(invocation -> {
            User user = invocation.getArgument(0);
            userList.add(user);
            return null;
        }).when(newUserRepo).saveUser(Mockito.any(User.class));

        Mockito.doThrow(NullPointerException.class)
                .when(newUserRepo).saveUser(null);
    }

    @Test
    void saveUserBehaviorTest() {
        User user = new User("user", 12);
        newUserRepo.saveUser(user);
        Assertions.assertEquals(1, userList.size());
        Assertions.assertEquals(user, userList.get(0));
        Assertions.assertThrows(NullPointerException.class, () -> newUserRepo.saveUser(null));
    }

    @Test
    void getUserByEmailBehaviorTest() {
        String email = "123";
        Mockito.doAnswer(invocation -> {
            for (User user : userList) {
                if (user.getEmail().equals(email)) {
                    return user;
                }
            }
            return null;
        }).when(newUserRepo).getUserByEmail(anyString());

        User user1 = new User("ok", 12, "123", "123");
        newUserRepo.saveUser(user1);
        newUserRepo.getUserByEmail(email);
        User user2 = newUserRepo.getUserByEmail(email);
        Assertions.assertEquals(user2, userService.userPerEmail(email));
    }
}