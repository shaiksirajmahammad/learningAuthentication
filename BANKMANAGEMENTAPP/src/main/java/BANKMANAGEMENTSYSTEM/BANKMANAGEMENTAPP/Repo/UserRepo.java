package BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Repo;

import BANKMANAGEMENTSYSTEM.BANKMANAGEMENTAPP.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,Long> {
@Query("select p from User p where p.username=:email")
Optional<User> findByName(@Param("email") String email);
}
