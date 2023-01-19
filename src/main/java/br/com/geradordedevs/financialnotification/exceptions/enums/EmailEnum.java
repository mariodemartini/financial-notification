package br.com.geradordedevs.financialnotification.exceptions.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum EmailEnum {

    ERROR_SEND_EMAIL("ERROR_SEND_EMAIL", "It was not possible to send the email", 400);

    private String code;
    private String message;
    private Integer statusCode;
}
