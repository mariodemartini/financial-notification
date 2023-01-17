package br.com.geradordedevs.financialnotification.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpreadSheetResponseDTO {

    private String month;
    private BigDecimal input;
    private BigDecimal output;
    private BigDecimal amount;
}
