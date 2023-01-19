package br.com.geradordedevs.financialnotification.services;

import org.apache.commons.mail.EmailException;

import java.math.BigDecimal;

public interface SendEmailService {
    void sendEmail(String month, BigDecimal amount) throws EmailException;
}
