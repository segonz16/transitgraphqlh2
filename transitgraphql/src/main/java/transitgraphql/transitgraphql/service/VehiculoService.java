package transitgraphql.transitgraphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transitgraphql.transitgraphql.entity.Vehiculo;
import transitgraphql.transitgraphql.repository.VehiculoRepository;

import java.util.List;

@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }
}
