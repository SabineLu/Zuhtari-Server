package ai.fhe.mp.marshalling;

import java.security.SecureRandom;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//class for Mail sending out
//TODO:change email design for user to get
public class SendMailSSL
{

    public String SendNewPasswordMail(String _Mail)
    {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", "smtp.live.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.smtp.trust", "smtp.live.com");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("ZuhtariGame@hotmail.com","zuhtariServer2408");
                    }
                });
        session.setDebug(true);
        try {
            String newPW = randomString(10);
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("ZuhtariGame@hotmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(_Mail));
            message.setSubject("New Password for Account on Zuhtari Subject");
            message.setText("New Password: " +
                   newPW + " \nPlease change the Password in the Account Settings once logged in!");

            Transport.send(message);

            System.out.println("Mail Send Done");
            return newPW;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    //allowed character in string
    static final String m_AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    static SecureRandom m_Rnd = new SecureRandom();

    //create random string
    String randomString( int _Length ){
        StringBuilder sb = new StringBuilder(_Length);
        for(int i = 0; i < _Length; i++ )
            sb.append( m_AB.charAt( m_Rnd.nextInt(m_AB.length()) ) );
        return sb.toString();
    }
}