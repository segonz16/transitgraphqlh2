package transitgraphql.transitgraphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transitgraphql.transitgraphql.dto.InfraccionInput;
import transitgraphql.transitgraphql.entity.Infraccion;
import transitgraphql.transitgraphql.entity.Matricula;
import transitgraphql.transitgraphql.repository.InfraccionRepository;
import transitgraphql.transitgraphql.repository.MatriculaRepository;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InfraccionService {

    @Autowired
    private InfraccionRepository infraccionRepository;

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private EmailService emailService;

    public Infraccion create(InfraccionInput input) {
        Infraccion i = new Infraccion();
        i.setFecha(input.getFecha());
        i.setAccionadaPor(input.getAccionadaPor());

        Matricula m = matriculaRepository.findById(input.getPlaca()).orElse(null);
        i.setMatricula(m);

        // Guardar infracción
        Infraccion saved = infraccionRepository.save(i);

        // Enviar notificación si el propietario tiene correo
        if (m != null && m.getPropietario() != null && m.getPropietario().getCorreo() != null) {
            String correo = m.getPropietario().getCorreo();
            emailService.sendInfraccionNotification(
                    correo,
                    m.getPlaca(),
                    input.getFecha().toString(),
                    input.getAccionadaPor()
            );
        }

        return saved;
    }

    public Infraccion update(Long id, InfraccionInput input) {
        Infraccion i = infraccionRepository.findById(id).orElseThrow();
        i.setFecha(input.getFecha());
        i.setAccionadaPor(input.getAccionadaPor());

        Matricula m = matriculaRepository.findById(input.getPlaca()).orElse(null);
        i.setMatricula(m);

        return infraccionRepository.save(i);
    }

    public List<Infraccion> obtenerPorPropietario(String identificacion) {
        return infraccionRepository.findByMatricula_Propietario_Identificacion(identificacion);
    }
    public boolean delete(Long id) {
        infraccionRepository.deleteById(id);
        return true;
    }

    public Infraccion getById(Long id) {
        return infraccionRepository.findById(id).orElse(null);
    }

    public List<Infraccion> getAll() {
        return infraccionRepository.findAll();
    }

    public List<Infraccion> getByPlaca(String placa) {
        return infraccionRepository.findByMatriculaPlaca(placa);
    }
}
