package transitgraphql.transitgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import transitgraphql.transitgraphql.dto.PropietarioInput;
import transitgraphql.transitgraphql.entity.Propietario;
import transitgraphql.transitgraphql.service.PropietarioService;

import java.util.List;

@Controller
public class PropietarioController {

    @Autowired
    PropietarioService propietarioService;

    @QueryMapping
    public List<Propietario> findAllPropietario(){
        return propietarioService.finAllPropietarios();
    }
    @QueryMapping
    public Propietario findByIdPropietario(@Argument String identificacion){
        return propietarioService.findById(identificacion);
    }

    @MutationMapping
    public Propietario crearPropietario(@Argument PropietarioInput input) {
        return propietarioService.create(input);
    }

    @MutationMapping
    public Propietario actualizarPropietario(@Argument String id, @Argument PropietarioInput input) {
        return propietarioService.update(id, input);
    }

    @MutationMapping
    public Boolean eliminarPropietario(@Argument String id) {
        return propietarioService.delete(id);
    }


}
