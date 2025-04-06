package transitgraphql.transitgraphql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@Table(name = "propietario")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Propietario {
    @Id
    @Column(length = 50)
    private String identificacion;

    @Column(name = "tipo_propietario", nullable = false)
    private String tipoPropietario;

    @Column(name = "tipo_documento")
    private String tipoDocumento;

    @Column(nullable = false)
    private String nombre;

    @Column
    private String direccion;

    @Column
    private String correo;


    @OneToMany(mappedBy = "propietario", cascade = CascadeType.ALL)
    private List<Matricula> matriculas = new ArrayList<>();

}
