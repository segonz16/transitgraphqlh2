package transitgraphql.transitgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import transitgraphql.transitgraphql.dto.MatriculaInput;
import transitgraphql.transitgraphql.entity.Matricula;
import transitgraphql.transitgraphql.service.MatriculaService;

import java.util.List;

@Controller
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @QueryMapping
    public List<Matricula> listarMatriculas() {
        return matriculaService.getAll();
    }

    @QueryMapping
    public Matricula matriculaPorPlaca(@Argument String placa) {
        return matriculaService.getByPlaca(placa);
    }

    @MutationMapping
    public Matricula crearMatricula(@Argument MatriculaInput input) {
        return matriculaService.create(input);
    }

    @MutationMapping
    public Matricula actualizarMatricula(@Argument String placa, @Argument MatriculaInput input) {
        return matriculaService.update(placa, input);
    }

    @MutationMapping
    public Boolean eliminarMatricula(@Argument String placa) {
        return matriculaService.delete(placa);
    }
}