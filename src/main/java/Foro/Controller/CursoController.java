package Foro.Controller;

import Foro.Repository.CursosRepository;
import Foro.Topico.DatosRespuestaTopico;
import Foro.Topico.RegistroCurso;
import Modelo.Curso;
import Modelo.Topico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/Curso")
public class CursoController {
    @Autowired
    private CursosRepository cursosRepository;
    @PostMapping
    public ResponseEntity<RegistroCurso> RegistrarCurso(@RequestBody RegistroCurso registroCurso, UriComponentsBuilder uriComponentsBuilder){
      Curso curso=  cursosRepository.save(new Curso(registroCurso));
      RegistroCurso registroCurso1= new RegistroCurso(curso.getId(), curso.getNombre(), curso.getCategoria());
        URI url=uriComponentsBuilder.path("/Curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(registroCurso1);

    }
    @GetMapping("/{id}")
    public ResponseEntity <RegistroCurso>RetornarDatosCursoId(@PathVariable Long id){
        Curso curso=    cursosRepository.getReferenceById(id);
        var datosCurso=new RegistroCurso(curso.getId(), curso.getNombre(), curso.getCategoria());
        return ResponseEntity.ok(datosCurso);
    }
}
