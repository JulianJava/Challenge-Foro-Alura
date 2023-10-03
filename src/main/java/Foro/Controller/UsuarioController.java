package Foro.Controller;

import Foro.Topico.RegistroUsuario;
import Foro.Repository.UsuarioRepositry;
import Modelo.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepositry usuarioRepositry;
    @PostMapping
    public ResponseEntity <RegistroUsuario>RegistrarUsuario(@RequestBody RegistroUsuario registroUsuario, UriComponentsBuilder uriComponentsBuilder){
       Usuario usuaario=  usuarioRepositry.save(new Usuario(registroUsuario));
       RegistroUsuario registroUsuario1= new RegistroUsuario(usuaario.getId(),usuaario.getNombre(),usuaario.getEmail(),usuaario.getContrasena());
        URI url = uriComponentsBuilder.path("/Usuario/{id}").buildAndExpand(usuaario.getId()).toUri();
        return ResponseEntity.created(url).body(registroUsuario1);
    }
    @GetMapping("/{id}")
    public ResponseEntity <RegistroUsuario>RetornarDatosUsuarioId(@PathVariable Long id){
        Usuario usuario =  usuarioRepositry.getReferenceById(id);
        var datosUsuario=new RegistroUsuario(usuario.getId(),usuario.getNombre(),usuario.getEmail(), usuario.getContrasena());
        return ResponseEntity.ok(datosUsuario);
    }

}
