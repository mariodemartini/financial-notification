package br.com.geradordedevs.financialnotification.services.impl;

import br.com.geradordedevs.financialnotification.services.SendEmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class SendEmailServiceImpl implements SendEmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendEmail(String month, BigDecimal amount) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("{spring.mail.from}");
            message.setTo("{spring.mail.to}");
            message.setSubject("{spring.mail.subject}");
            message.setText("The balance for the month " + month + " is negative in $" + amount);

            mailSender.send(message);
            log.info("deu certo");

        } catch (Exception exception) {
            log.info("deu erro");
        }
    }

}
