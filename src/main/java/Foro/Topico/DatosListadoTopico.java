package Foro.Topico;

import Modelo.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(String titulo, String mensaje, LocalDateTime fechaCreacion,String autor,String curso) {
    public DatosListadoTopico(Topico topico){
        this(topico.getTitulo(),
                topico.getMensaje(),
                topico.getfechaCreacion(),
                topico.getAutor(),
                topico.getCurso());
    }
}
