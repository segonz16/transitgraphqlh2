package transitgraphql.transitgraphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import transitgraphql.transitgraphql.entity.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {}
