package config;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;

public class EmailUtil {
    // Replace these with your actual Gmail credentials
    private static final String EMAIL_FROM = "your.email@gmail.com"; // Your Gmail address
    private static final String EMAIL_PASSWORD = "xxxx xxxx xxxx xxxx"; // Your 16-character App Password

    public static boolean sendOTPEmail(String toEmail, String otp) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.ssl.enable", "true"); // Enable SSL
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // Trust Gmail's SSL certificate

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("Password Reset OTP");
            message.setText("Your OTP for password reset is: " + otp + "\n\nThis OTP will expire in 5 minutes.");

            Transport.send(message);
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to send email: " + e.getMessage(), 
                "Email Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
} 