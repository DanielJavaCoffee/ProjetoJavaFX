package entity;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import gui.util.Alerts;
import javafx.scene.control.Alert.AlertType;

public class Mensageiro {

	public static void enviarMensagemDeRecuperacaoDeSenha(String assunto, String email, Usuario usuario) {

		Properties props = new Properties();
		props.put("mail.smtp.user", "projeto2021ifpb@gmail.com"); // remetente
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("projeto2021ifpb@gmail.com", "Da76agH!"); // remetente e senha
			}
		}); // remetente
		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projeto2021ifpb@gmail.com")); // remetente
			Address[] toUser = InternetAddress.parse(email); // destinatario
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);
			message.setText("Não compartilhe essas informações por segurança: " + usuario);
			Transport.send(message);

			Alerts.showAlerts("Email enviado com sucesso!", "Email enviado", null, AlertType.CONFIRMATION);

		} catch (MessagingException e) {

			Alerts.showAlerts("Erro ao enviar Email!", "Algo deu errado", e.getMessage(), AlertType.ERROR);
		}
	}

	public static void enviarMensagem(String assunto, String email, String texto) {

		Properties props = new Properties();

		props.put("mail.smtp.user", "projeto2021ifpb@gmail.com"); // remetente
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");

		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("projeto2021ifpb@gmail.com", "Da76agH!"); // remetente e senha
			}
		}); // remetente

		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projeto2021ifpb@gmail.com")); // remetente
			Address[] toUser = InternetAddress.parse(email); // destinatario
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);
			message.setText(texto);
			Transport.send(message);

			Alerts.showAlerts("Email enviado com sucesso!", "Email enviado", null, AlertType.CONFIRMATION);

		} catch (MessagingException e) {

			Alerts.showAlerts("Erro ao enviar Email!", "Algo deu errado", e.getMessage(), AlertType.ERROR);
		}
	}

	public static void enviarMensagemDeEmailOrcamento(String assunto, String email, Orcamento orcamento) {

		Properties props = new Properties();
		props.put("mail.smtp.user", "projeto2021ifpb@gmail.com"); // remetente
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "25");
		props.put("mail.debug", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.EnableSSL.enable", "true");
		props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.smtp.socketFactory.fallback", "false");
		props.setProperty("mail.smtp.port", "465");
		props.setProperty("mail.smtp.socketFactory.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("projeto2021ifpb@gmail.com", "Da76agH!"); // remetente e senha
			}
		}); // remetente
		session.setDebug(true);

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("projeto2021ifpb@gmail.com")); // remetente
			Address[] toUser = InternetAddress.parse(email); // destinatario
			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject(assunto);
			message.setText("Qual quer duvida entre encontato: " + orcamento);
			Transport.send(message);

			Alerts.showAlerts("Email enviado com sucesso!", "Email enviado", null, AlertType.CONFIRMATION);

		} catch (MessagingException e) {

			Alerts.showAlerts("Erro ao enviar Email!", "Algo deu errado", e.getMessage(), AlertType.ERROR);
		}
	}
}
