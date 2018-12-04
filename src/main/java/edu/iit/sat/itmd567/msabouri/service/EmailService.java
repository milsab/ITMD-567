package edu.iit.sat.itmd567.msabouri.service;

import java.util.Properties;
import javax.mail.*;    
import javax.mail.internet.*;    

/**
 *
 * @author Milad
 */
public class EmailService {

    public static void send(String _to, String username, String userpass) {
        String _from = "meal.sharingservice@gmail.com";
        String _password = "Ng101840";
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session   
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(_from, _password);
            }
        });
        //compose message    
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(_to));
            message.setSubject("WELCOME TO TAHDIG");
//            message.setText(msg);
            message.setContent("<body>"
                    + "<h1>TAHDIG</h1>"
                    + "<h2>Thank you for Registering on TAHDIG,</h2>"
                    + "<h3>The First Meal Sharing Platform</h3>"
                    + "<em>Your Username is: " + username 
                    + "</em><br/><em>Your Password is: " + userpass
                    + "</em><br/><a href='http://lasalle.sat.iit.edu:8080/MealSharingV2-1.0-SNAPSHOT/'>Click here to go to the TAHDIG service</a></body>", 
                    "text/html; charset=utf8");
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}