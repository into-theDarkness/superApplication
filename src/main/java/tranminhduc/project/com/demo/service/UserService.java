package tranminhduc.project.com.demo.service;

import tranminhduc.project.com.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    void delete(Long id);
    void save(User user);
}
