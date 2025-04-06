package transitgraphql.transitgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transitgraphql.transitgraphql.entity.Propietario;

public interface PropietarioRepository extends JpaRepository<Propietario, String> {}
