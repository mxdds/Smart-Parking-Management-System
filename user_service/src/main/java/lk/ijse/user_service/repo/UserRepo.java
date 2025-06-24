package lk.ijse.user_service.repo;

import lk.ijse.user_service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo  extends JpaRepository<User, Long>{

        Optional<User> findByUsername(String username);

    }

