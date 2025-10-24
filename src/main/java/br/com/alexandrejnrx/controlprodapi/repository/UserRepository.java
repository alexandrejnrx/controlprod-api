package br.com.alexandrejnrx.controlprodapi.repository;

import br.com.alexandrejnrx.controlprodapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    UserDetails findByUsername(String username);

}
