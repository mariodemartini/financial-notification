package br.com.geradordedevs.financialnotification.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SpreadSheetEntity {
    @Id
    private Long id;
    private String month;
    private BigDecimal input;
    private BigDecimal output;
    private BigDecimal amount;

    @Override
    public String toString() {
        return "SpreadSheetEntity{" +
                "month='" + month + '\'' +
                ", input=" + input +
                ", output=" + output +
                ", amount=" + amount +
                '}';
    }
}
