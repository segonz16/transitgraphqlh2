package transitgraphql.transitgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import transitgraphql.transitgraphql.entity.Vehiculo;
import transitgraphql.transitgraphql.service.VehiculoService;

import java.util.List;

@Controller
public class VehiculoController {
    @Autowired
    VehiculoService vehiculoService;

    @QueryMapping
    private List<Vehiculo> listAllVehiculos() {
        return vehiculoService.getAllVehiculos();
    }
}
