package transitgraphql.transitgraphql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "vehiculo")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();
}
