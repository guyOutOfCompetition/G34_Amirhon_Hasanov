package Commerce.application.service.impl;

import Commerce.application.domain.User;
import Commerce.application.enums.UserRole;
import Commerce.application.service.UserService;

public class UserServiceImpl implements UserService {

    {
        USERS.add(new User("Mr.Bean", "r001", UserRole.OWNER));//OWNER
        USERS.add(new User("Spider Man", "r002"));
        USERS.add(new User("Iron Man", "r003"));
        USERS.add(new User("Harry Poter", "r004"));
    }

    @Override
    public User login(String password, String name) {
        for (User user : USERS) {
            if (user.getPassword().equals(password) && user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public String registerUser(User user) {
        if (doesTheUserExist(user)) {
            return null;
        }
        USERS.add(user);
        return "Successfully";
    }

    @Override
    public void showUsers(Integer userId) {
        for (User user : USERS) {
            if (!user.getId().equals(userId)) {
                System.out.println(user);
            }
        }
    }

    public User getUserById(Integer userId) {
        for (User user : USERS) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    private boolean doesTheUserExist(User user) {
        for (User user1 : USERS) {
            if (user1.getName().equals(user.getName())) {
                System.out.println("A user with this name exists !" + user1.getName());
                return true;
            } else if (user1.getPassword().equals(user.getPassword())) {
                System.out.println("A user with this password exists !" + user1.getPassword());
                return true;
            }
        }
        return false;
    }
}
