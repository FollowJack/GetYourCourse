package Services

import javax.mail.Session
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage

class EmailService {

    final String username = "blogmannheim@gmail.com";
    final String password = "deniel1992";
    final String host = "smtp.gmail.com";

    def sendMail(String recipient,String subject,String bodyText) {
        def props = new Properties()
        props.put "mail.smtps.auth", "true"
        props.put "mail.smtp.host", host
        props.put "mail.smtp.port", "587"

        def session = Session.getDefaultInstance props

        def msg = new MimeMessage(session)

        msg.setSubject subject
        msg.setText bodyText
        msg.addRecipient MimeMessage.RecipientType.TO, new InternetAddress(recipient, recipient)

        def transport = session.getTransport "smtps"

        try {
            transport.connect (host, username, password)
            transport.sendMessage (msg, msg.getAllRecipients())
        }
        catch (Exception e) {
            println "Error"
        }
    }
}