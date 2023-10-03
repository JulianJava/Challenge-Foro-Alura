package Foro.Controller;

import Foro.Topico.*;
import Foro.Repository.TopicoRepository;
import Modelo.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping("/Topico")
public class TopicoController {
    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> RegistrarTopico(@RequestBody DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder){
     Topico topico = topicoRepository.save(new Topico(datosRegistroTopico));
     DatosRespuestaTopico datosRespuestaTopico=new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getfechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso());
        URI url=uriComponentsBuilder.path("/Topico/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> ListadoTopico(Pageable paginacion){
        return ResponseEntity.ok( topicoRepository.findAll(paginacion).map(DatosListadoTopico::new));
    }
    @PutMapping
    @Transactional
    public ResponseEntity ActualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico=topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.DatosActualizarTopico(datosActualizarTopico);
    return  ResponseEntity.ok( new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getfechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso()));}
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity EliminarTopico(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity <DatosRespuestaTopico>RetornarDatosTopicoId(@PathVariable Long id){
        Topico topico= topicoRepository.getReferenceById(id);
        var datosTopico=new DatosRespuestaTopico(topico.getId(),topico.getTitulo(),topico.getMensaje(),topico.getfechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso());
        return ResponseEntity.ok(datosTopico);
    }
}
