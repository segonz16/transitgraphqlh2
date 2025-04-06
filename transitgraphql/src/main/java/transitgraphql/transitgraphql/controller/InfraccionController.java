package transitgraphql.transitgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import transitgraphql.transitgraphql.dto.InfraccionInput;
import transitgraphql.transitgraphql.entity.Infraccion;
import transitgraphql.transitgraphql.service.InfraccionService;

import java.util.List;

@Controller
public class InfraccionController {

    @Autowired
    private InfraccionService infraccionService;

    @QueryMapping
    public List<Infraccion> listarInfracciones() {
        return infraccionService.getAll();
    }

    @QueryMapping
    public Infraccion infraccionPorId(@Argument Long id) {
        return infraccionService.getById(id);
    }

    @QueryMapping
    public List<Infraccion> infraccionesPorPlaca(@Argument String placa) {
        return infraccionService.getByPlaca(placa);
    }

    @QueryMapping
    public List<Infraccion> infraccionesPorPropietario(@Argument String identificacion) {
        return infraccionService.obtenerPorPropietario(identificacion);
    }

    @MutationMapping
    public Infraccion registrarInfraccion(@Argument InfraccionInput input) {
        return infraccionService.create(input);
    }

    @MutationMapping
    public Infraccion actualizarInfraccion(@Argument Long id, @Argument InfraccionInput input) {
        return infraccionService.update(id, input);
    }

    @MutationMapping
    public Boolean eliminarInfraccion(@Argument Long id) {
        return infraccionService.delete(id);
    }
}
