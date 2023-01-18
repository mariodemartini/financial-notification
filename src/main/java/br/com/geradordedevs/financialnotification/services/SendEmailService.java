package br.com.geradordedevs.financialnotification.services;

import java.math.BigDecimal;

public interface SendEmailService {
    void sendEmail(String month, BigDecimal amount);
}
