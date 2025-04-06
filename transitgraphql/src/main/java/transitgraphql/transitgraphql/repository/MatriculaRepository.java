package transitgraphql.transitgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transitgraphql.transitgraphql.entity.Matricula;
import transitgraphql.transitgraphql.entity.Propietario;

import java.util.List;

public interface MatriculaRepository extends JpaRepository<Matricula, String> {

    List<Matricula> findByPropietario(Propietario propietario);

}
