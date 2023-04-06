package mailRestaurant;

import java.time.LocalDate;
import java.util.Properties;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import restaurant.EnviarTIcket;

public class viaMailEnviarTicket implements EnviarTIcket {

	@Override
	public void envairTicket(String email, LocalDate fecha, Double monto) {

		String mensaje = fecha.toString() + " " + "//" + " " + String.valueOf(monto) + "\n";
		String to = email;

		String from = "jakartafrom@example.com";

		final String username = "e1aa2e5afc42df";

		final String password = "b8bc167ddcc249";

		String host = "smtp.mailtrap.io";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new jakarta.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {

			Message message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));

			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

			message.setSubject("TICKET");

			message.setText(mensaje);

			Transport.send(message);
			System.out.println("Email Message Sent Successfully");
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

	}

}
