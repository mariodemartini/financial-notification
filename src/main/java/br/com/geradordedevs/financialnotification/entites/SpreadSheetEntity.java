package br.com.geradordedevs.financialnotification.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class SpreadSheetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String month;
    private BigDecimal input;
    private BigDecimal output;
    private BigDecimal amount;
    
}
