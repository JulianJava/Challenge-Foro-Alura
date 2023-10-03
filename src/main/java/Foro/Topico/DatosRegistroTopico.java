package Foro.Topico;

import Modelo.StatusTopico;

import java.time.LocalDateTime;

public record DatosRegistroTopico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico statusTopico,
                                  RegistroUsuario usuario, RegistroCurso curso) {
}
