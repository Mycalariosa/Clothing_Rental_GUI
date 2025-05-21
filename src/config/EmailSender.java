package config;

import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;

public class EmailSender {

    private static final String FROM_EMAIL = "dentalflow2025@gmail.com"; // your sender email
    private static final String FROM_PASSWORD = "mpds vlzw cnqh dwco";   // your Gmail app password
    private static final String SENDER_NAME = "Clothing Rental";

    /**
     * Create and return a configured mail session.
     */
    private static Session createEmailSession() {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.ssl.trust", "*"); // Trust all SSL certificates
        props.put("mail.smtp.ssl.protocols", "TLSv1.2"); // Use TLS 1.2
        props.put("mail.smtp.connectiontimeout", "5000"); // 5 seconds timeout
        props.put("mail.smtp.timeout", "5000"); // 5 seconds timeout
        props.put("mail.smtp.writetimeout", "5000"); // 5 seconds timeout

        return Session.getInstance(props, new Authenticator() {
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
                "<body style='font-family:Arial, sans-serif;'>" +
                "<h2 style='color:#007BFF;'>Clothing Rental - Password Reset Verification</h2>" +
                "<p>Dear <b>" + userName + "</b>,</p>" +
                "<p>You have requested to reset your password. Please use the PIN below to verify your identity:</p>" +
                "<h3 style='color:#28A745; background-color:#f8f9fa; padding:10px; border-radius:5px; text-align:center;'>" + pinString + "</h3>" +
                "<p>This PIN is valid for 5 minutes. Do not share it with anyone.</p>" +
                "<p>If you didn't request this password reset, please ignore this email.</p>" +
                "<br><p>Sincerely,<br><b>Clothing Rental Team</b></p>" +
                "</body>" +
                "</html>";

            message.setContent(htmlBody, "text/html");
            Transport.send(message);

            return pinString;
        } catch (MessagingException e) {
            System.err.println("Failed to send verification PIN to " + toEmail + ": " + e.getMessage());
            throw e;
        }
    }
}
