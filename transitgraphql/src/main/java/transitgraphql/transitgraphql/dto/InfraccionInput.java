package transitgraphql.transitgraphql.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class InfraccionInput {
    private LocalDate fecha;
    private String accionadaPor;
    private String placa;

}

