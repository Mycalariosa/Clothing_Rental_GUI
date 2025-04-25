package config;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SMSConfig {
    private static final Logger LOGGER = Logger.getLogger(SMSConfig.class.getName());
    
    // Semaphore SMS API configuration - Get these from https://semaphore.co/docs
    private static final String API_KEY = "your-semaphore-api-key"; // Replace with your actual API key
    private static final String SENDER_ID = "CLTHRENT"; // Your sender name (max 11 characters)
    
    public static boolean sendOTP(String contactNumber, String otp) {
        try {
            // Format the phone number (remove leading zero and add country code if needed)
            if (contactNumber.startsWith("0")) {
                contactNumber = "63" + contactNumber.substring(1); // Convert 09XX to 639XX format
            } else if (contactNumber.startsWith("+63")) {
                contactNumber = contactNumber.substring(1); // Remove the + from +63
            } else if (!contactNumber.startsWith("63")) {
                contactNumber = "63" + contactNumber; // Add 63 prefix if not present
            }
            
            // Prepare the message
            String message = String.format("Your OTP for Clothing Rental password reset is: %s. Valid for 5 minutes only. Do not share this with anyone.", otp);
            
            // Encode parameters
            String encodedMessage = URLEncoder.encode(message, "UTF-8");
            String encodedNumber = URLEncoder.encode(contactNumber, "UTF-8");
            
            // Build the API URL
            String apiUrl = String.format(
                "https://api.semaphore.co/api/v4/messages?" +
                "apikey=%s&number=%s&message=%s&sendername=%s",
                API_KEY, encodedNumber, encodedMessage, SENDER_ID
            );
            
            // Create connection
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setConnectTimeout(5000); // 5 seconds timeout
            conn.setReadTimeout(5000); // 5 seconds timeout
            
            // Get response
            int responseCode = conn.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK || responseCode == HttpURLConnection.HTTP_CREATED) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                LOGGER.log(Level.INFO, "SMS sent successfully to: {0}, Response: {1}", 
                    new Object[]{contactNumber, response.toString()});
                return true;
            } else {
                BufferedReader errorReader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                StringBuilder errorResponse = new StringBuilder();
                String line;
                while ((line = errorReader.readLine()) != null) {
                    errorResponse.append(line);
                }
                errorReader.close();
                
                LOGGER.log(Level.SEVERE, "Failed to send SMS. Response code: {0}, Error: {1}", 
                    new Object[]{responseCode, errorResponse.toString()});
                return false;
            }
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Error sending SMS: " + e.getMessage(), e);
            return false;
        }
    }
    
    // Test SMS configuration and API key
    public static boolean testSMSConfiguration() {
        try {
            // Build the API URL to check account balance/status
            String apiUrl = String.format(
                "https://api.semaphore.co/api/v4/account?" +
                "apikey=%s",
                API_KEY
            );
            
            // Create connection
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);
            
            // Get response
            int responseCode = conn.getResponseCode();
            
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                
                LOGGER.log(Level.INFO, "SMS configuration test successful. Account details: {0}", response.toString());
                return true;
            } else {
                LOGGER.log(Level.SEVERE, "SMS configuration test failed. Response code: {0}", responseCode);
                return false;
            }
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "SMS configuration test failed: " + e.getMessage(), e);
            return false;
        }
    }
} 