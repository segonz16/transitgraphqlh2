package transitgraphql.transitgraphql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "matricula")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Matricula {
    @Id
    private String placa;

    private String marca;

    private LocalDate fechaMatricula;

    @ManyToOne
    @JoinColumn(name = "propietario_id")
    private Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "matricula", cascade = CascadeType.ALL)
    private List<Infraccion> infracciones = new ArrayList<>();


}
