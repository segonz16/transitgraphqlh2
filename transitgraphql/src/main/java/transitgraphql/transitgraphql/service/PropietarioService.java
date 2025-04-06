package transitgraphql.transitgraphql.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transitgraphql.transitgraphql.dto.PropietarioInput;
import transitgraphql.transitgraphql.entity.Propietario;
import transitgraphql.transitgraphql.repository.PropietarioRepository;

import java.util.List;

@Service
@Slf4j
public class PropietarioService {
    @Autowired
    private PropietarioRepository propietarioRepository;

    public List<Propietario> finAllPropietarios(){
        return propietarioRepository.findAll();
    }

    public Propietario findById(String identificacion) {
        return   propietarioRepository.findById(identificacion).orElse(null);
    }

    public Propietario create(PropietarioInput input) {
        Propietario p = new Propietario();
        p.setIdentificacion(input.getIdentificacion());
        p.setTipoPropietario(input.getTipoPropietario());
        p.setTipoDocumento(input.getTipoDocumento());
        p.setNombre(input.getNombre());
        p.setDireccion(input.getDireccion());
        return propietarioRepository.save(p);
    }

    public Propietario update(String id, PropietarioInput input) {
        Propietario p = propietarioRepository.findById(id).orElseThrow();
        p.setTipoPropietario(input.getTipoPropietario());
        p.setTipoDocumento(input.getTipoDocumento());
        p.setNombre(input.getNombre());
        p.setDireccion(input.getDireccion());
        return propietarioRepository.save(p);
    }

    public boolean delete(String id) {
        propietarioRepository.deleteById(id);
        return true;
    }

}
