package br.com.geradordedevs.financialnotification.exceptions;

import br.com.geradordedevs.financialnotification.exceptions.enums.EmailEnum;
import br.com.geradordedevs.financialnotification.exceptions.enums.UploadExcelEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class UploadExcelException extends FinancialNotificationException{

    private final UploadExcelEnum error;

    public UploadExcelException(UploadExcelEnum error){
        super(error.getMessage());
        this.error = error;
    }

}
