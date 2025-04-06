package transitgraphql.transitgraphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transitgraphql.transitgraphql.dto.MatriculaInput;
import transitgraphql.transitgraphql.entity.Matricula;
import transitgraphql.transitgraphql.entity.Propietario;
import transitgraphql.transitgraphql.entity.Vehiculo;
import transitgraphql.transitgraphql.repository.MatriculaRepository;
import transitgraphql.transitgraphql.repository.PropietarioRepository;
import transitgraphql.transitgraphql.repository.VehiculoRepository;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private PropietarioRepository propietarioRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;


    public Matricula create(MatriculaInput input) {
        Matricula m = new Matricula();
        m.setPlaca(input.getPlaca());
        m.setMarca(input.getMarca());
        m.setFechaMatricula(input.getFechaMatricula());

        Propietario p = propietarioRepository.findById(input.getPropietarioId()).orElse(null);
        Vehiculo v = vehiculoRepository.findById(input.getVehiculoId()).orElse(null);
        m.setPropietario(p);
        m.setVehiculo(v);

        return matriculaRepository.save(m);
    }


    public Matricula update(String placa, MatriculaInput input) {
        Matricula m = matriculaRepository.findById(placa).orElseThrow();
        m.setMarca(input.getMarca());
        m.setFechaMatricula(input.getFechaMatricula());

        Propietario p = propietarioRepository.findById(input.getPropietarioId()).orElse(null);
        Vehiculo v = vehiculoRepository.findById(input.getVehiculoId()).orElse(null);
        m.setPropietario(p);
        m.setVehiculo(v);

        return matriculaRepository.save(m);
    }


    public boolean delete(String placa) {
        matriculaRepository.deleteById(placa);
        return true;
    }


    public Matricula getByPlaca(String placa) {
        return matriculaRepository.findById(placa).orElse(null);
    }


    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }
}

