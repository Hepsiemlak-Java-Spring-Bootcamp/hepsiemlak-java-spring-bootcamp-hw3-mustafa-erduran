package emlakburada.repository;

import emlakburada.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    private List<User> userRepository = new ArrayList<>();

    public List<User> fetchAllUsers(){
        return userRepository;
    }
    public User saveUser(User user){
        userRepository.add(user);
        return user;
    }
}
