package br.com.geradordedevs.financialnotification.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum UploadExcelEnum {

    ERROR_IMPORTING_SPREADSHEET("ERROR_IMPORTING_SPREADSHEET", "it was not possible to import the worksheet", 400);

    private String code;
    private String message;
    private Integer statusCode;
}
