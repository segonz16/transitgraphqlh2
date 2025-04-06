package transitgraphql.transitgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transitgraphql.transitgraphql.entity.Infraccion;

import java.util.List;

public interface InfraccionRepository extends JpaRepository<Infraccion, Long> {
    List<Infraccion> findByMatriculaPlaca(String placa);

    List<Infraccion> findByMatricula_Propietario_Identificacion(String identificacion);
}
