package Foro.Repository;

import Modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositry extends JpaRepository<Usuario,Long>  {

    UserDetails findByemail(String username);
}
