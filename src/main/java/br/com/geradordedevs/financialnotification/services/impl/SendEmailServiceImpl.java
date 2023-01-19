package br.com.geradordedevs.financialnotification.services.impl;

import br.com.geradordedevs.financialnotification.services.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class SendEmailServiceImpl implements SendEmailService {

    @Value("${email.smpt.port}")
    private int smptPort;

    @Value("${email.hostname}")
    private String hostName;

    @Value("${email.user}")
    private String user;

    @Value("${email.password}")
    private String password;

    @Value("${email.to}")
    private String to;

    @Value("${email.from}")
    private String from;

    @Value("${email.subject}")
    private String subject;

    private final String START_TEXT = "O balanço do mês de :";
    private final String END_TEXT = " ficou com saldo negativo de : ";

    @Override
    public void sendEmail(String month, BigDecimal amount) {
        SimpleEmail email = new SimpleEmail();
        email.setHostName(hostName);
        email.setSmtpPort(smptPort);
        email.setDebug(true);
        email.setAuthenticator(new DefaultAuthenticator(user, password));
        email.setSSLOnConnect(true);

        try {
            email.addTo(to);
            email.setFrom(from);
            email.setSubject(subject + " : " + month);
            email.setMsg(START_TEXT + month + END_TEXT + amount + "R$");

            email.send();
        } catch (Exception exception) {
            log.info("deu erro");
        }
    }

}
