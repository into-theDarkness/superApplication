package tranminhduc.project.com.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tranminhduc.project.com.demo.model.User;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT * from user ", nativeQuery = true)
    List<User> findAllUser();

    @Query(value = "select * from user where id =?1", nativeQuery = true)
    Optional<User> findUserByIDs(Long id);

}
