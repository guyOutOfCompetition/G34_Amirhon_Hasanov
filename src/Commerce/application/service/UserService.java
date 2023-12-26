package Commerce.application.service;


import Commerce.application.domain.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public interface UserService {

    List<User> USERS = Collections.synchronizedList(new ArrayList<>());

    User login(String password, String name);

    String registerUser(User user);

    void showUsers(Integer userId);

    User getUserById(Integer userId);
}
