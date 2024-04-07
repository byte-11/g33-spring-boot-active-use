package uz.pdp.g33springbootactiveuse.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.g33springbootactiveuse.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByEmailAndEnabledTrue(String email);


    Optional<User> findByEmail(String email);

    Optional<User> findByIdAndEnabledIsTrue(Long id);
}