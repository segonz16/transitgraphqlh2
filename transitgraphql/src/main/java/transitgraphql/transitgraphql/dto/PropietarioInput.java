package transitgraphql.transitgraphql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PropietarioInput {
    private String identificacion;
    private String tipoPropietario;
    private String tipoDocumento;
    private String nombre;
    private String direccion;
    private String correo;

}
