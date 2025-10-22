package br.com.alexandrejnrx.controlprodapi.repository;

import br.com.alexandrejnrx.controlprodapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByNomeUsuario(String nomeUsuario);

    boolean existsByEmail(String email);

    UserDetails findByNomeUsuario(String nomeUsuario);

}
