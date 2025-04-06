package transitgraphql.transitgraphql.dto;

import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MatriculaInput {
    private String placa;
    private String marca;
    private LocalDate fechaMatricula;
    private String propietarioId;
    private Long vehiculoId;
}
