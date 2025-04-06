package transitgraphql.transitgraphql.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendInfraccionNotification(String toEmail, String placa, String fecha, String accionadaPor) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Nueva Infracción Registrada");
        message.setText("Se ha registrado una nueva infracción para el vehículo con placa " + placa +
                " el día " + fecha + " y fue impuesta por " + accionadaPor + ".");
        mailSender.send(message);
    }
}