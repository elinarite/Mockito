package mockito.task1;


public class User {
    private String name;
    private int age;
    private String userID;
    private String email;

    public User() {
    }


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String userID) {
        this.userID = userID;
    }

    public User(String name, int age, String userID) {
        this.name = name;
        this.age = age;
        this.userID = userID;
    }

    public User(String name, int age, String userID, String email) {
        this.name = name;
        this.age = age;
        this.userID = userID;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }
}

