package Foro.Topico;

import Modelo.StatusTopico;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico statusTopico,
                                   String usuario, String curso) {
}
