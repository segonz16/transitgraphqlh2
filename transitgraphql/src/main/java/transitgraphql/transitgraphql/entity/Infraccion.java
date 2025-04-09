package transitgraphql.transitgraphql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "infraccion")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Infraccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    private String accionadaPor;

    @ManyToOne
    @JoinColumn(name = "placa")
    private Matricula matricula;
}
