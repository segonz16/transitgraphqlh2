package transitgraphql.transitgraphql.dto;

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

