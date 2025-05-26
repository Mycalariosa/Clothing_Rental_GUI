package config;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeBodyPart;
import java.io.UnsupportedEncodingException;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class EmailSender {

    private static final String FROM_EMAIL = "clothingrental2024@gmail.com"; // Clothing Rental sender email
    private static final String FROM_PASSWORD = "fxpc lhat jano eoyj";   // Gmail app password
    private static final String SENDER_NAME = "Clothing Rental System";

    /**
     * Create and return a configured mail session.
     */
    private static Session createEmailSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.connectiontimeout", "5000");
        props.put("mail.smtp.timeout", "5000");
        props.put("mail.smtp.writetimeout", "5000");
        props.put("mail.smtp.quitwait", "false");

        return Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM_EMAIL, FROM_PASSWORD);
            }
        });
    }

    /**
     * Sends a 6-digit verification PIN to the specified email and returns it.
     */
    public static String sendVerificationPin(String toEmail, String userName) throws MessagingException {
        if (toEmail == null || toEmail.trim().isEmpty()) {
            throw new MessagingException("Recipient email address is missing or null.");
        }

        // Generate a random 6-digit PIN
        Random random = new Random();
        int pin = 100000 + random.nextInt(900000);
        String pinString = String.valueOf(pin);

        try {
            Session session = createEmailSession();
            Message message = new MimeMessage(session);
            try {
                message.setFrom(new InternetAddress(FROM_EMAIL, SENDER_NAME));
            } catch (UnsupportedEncodingException e) {
                message.setFrom(new InternetAddress(FROM_EMAIL));
            }
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Password Reset Verification PIN");

            String htmlBody = "<html>" +
                "<head>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; line-height: 1.6; color: #333; }" +
                ".container { max-width: 600px; margin: 0 auto; padding: 20px; }" +
                ".logo { text-align: center; margin-bottom: 20px; }" +
                ".header { color: #007BFF; text-align: center; margin-bottom: 20px; }" +
                ".pin-box { background-color: #f8f9fa; padding: 15px; border-radius: 5px; text-align: center; margin: 20px 0; }" +
                ".pin { color: #28A745; font-size: 24px; font-weight: bold; letter-spacing: 2px; }" +
                ".footer { margin-top: 30px; padding-top: 20px; border-top: 1px solid #eee; text-align: center; color: #666; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='container'>" +
                "<div class='logo'>" +
                "<img src='cid:logo' alt='Clothing Rental Logo' style='width: 100px; height: auto;'>" +
                "</div>" +
                "<div class='header'>" +
                "<h2>Password Reset Verification</h2>" +
                "</div>" +
                "<p>Dear <b>" + userName + "</b>,</p>" +
                "<p>You have requested to reset your password. Please use the PIN below to verify your identity:</p>" +
                "<div class='pin-box'>" +
                "<div class='pin'>" + pinString + "</div>" +
                "</div>" +
                "<p><b>Important:</b> This PIN is valid for 5 minutes only. Do not share it with anyone.</p>" +
                "<p>If you didn't request this password reset, please ignore this email and ensure your account is secure.</p>" +
                "<div class='footer'>" +
                "<p>Sincerely,<br><b>Clothing Rental Team</b></p>" +
                "</div>" +
                "</div>" +
                "</body>" +
                "</html>";

            // Create a multipart message
            MimeMultipart multipart = new MimeMultipart("related");
            
            // Create the HTML part
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(htmlBody, "text/html");
            multipart.addBodyPart(messageBodyPart);
            
            // Add the logo image
            messageBodyPart = new MimeBodyPart();
            DataSource fds = new FileDataSource("src/images/logos50.png");
            messageBodyPart.setDataHandler(new DataHandler(fds));
            messageBodyPart.setHeader("Content-ID", "<logo>");
            multipart.addBodyPart(messageBodyPart);
            
            // Set the content
            message.setContent(multipart);
            
            Transport.send(message);

            return pinString;
        } catch (MessagingException e) {
            System.err.println("Failed to send verification PIN to " + toEmail + ": " + e.getMessage());
            throw e;
        }
    }
}
