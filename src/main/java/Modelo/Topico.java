package Modelo;

import Foro.Topico.DatosActualizarTopico;
import Foro.Topico.DatosRegistroTopico;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Table(name="consultas")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String mensaje;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    @Enumerated(EnumType.STRING)
    private StatusTopico status = StatusTopico.NO_RESPONDIDO;
    @NotBlank
    private String autor;
    @NotBlank
    private String curso;
    private List<Respuesta> respuestas = new ArrayList<>();



    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }
    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.id=datosRegistroTopico.id();
        this.titulo= datosRegistroTopico.titulo();
        this.mensaje= datosRegistroTopico.mensaje();
        this.fechaCreacion=datosRegistroTopico.fechaCreacion();
        this.status=datosRegistroTopico.statusTopico();
        this.autor= datosRegistroTopico.usuario().nombre();
        this.curso=datosRegistroTopico.curso().nombre();
    }

    public LocalDateTime getfechaCreacion() {
        return fechaCreacion;
    }

    public void DatosActualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        if(datosActualizarTopico.titulo()!= null) {
            this.titulo = datosActualizarTopico.titulo();
        }
        if(datosActualizarTopico.mensaje()!= null) {
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.autor()!=null) {
            this.autor = datosActualizarTopico.autor();
        }
        if(datosActualizarTopico.curso()!= null) {
            this.curso = datosActualizarTopico.curso();
        }
    }
}
