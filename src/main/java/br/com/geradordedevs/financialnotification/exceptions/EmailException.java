package br.com.geradordedevs.financialnotification.exceptions;

import br.com.geradordedevs.financialnotification.exceptions.enums.EmailEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class EmailException extends FinancialNotificationException{

    private final EmailEnum error;

    public EmailException(EmailEnum error){
        super(error.getMessage());
        this.error = error;
    }

}
