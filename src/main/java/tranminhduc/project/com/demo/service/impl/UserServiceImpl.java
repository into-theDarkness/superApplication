package tranminhduc.project.com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tranminhduc.project.com.demo.exception.CheckException;
import tranminhduc.project.com.demo.model.User;
import tranminhduc.project.com.demo.repository.UserRepository;
import tranminhduc.project.com.demo.service.UserService;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        List<User> users = userRepository.findAllUser();
        return users;
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findUserByIDs(id);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
