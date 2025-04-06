package transitgraphql.transitgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transitgraphql.transitgraphql.entity.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula, String> {}
