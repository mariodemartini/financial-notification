package br.com.geradordedevs.financialnotification.services;

import org.springframework.web.multipart.MultipartFile;

public interface SpreadSheetService {

    boolean validateExcelFile(MultipartFile file);
}
