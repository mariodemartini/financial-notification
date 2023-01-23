package br.com.geradordedevs.financialnotification.services;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface SpreadSheetService {

    boolean validateExcelFile(MultipartFile file);

    SpreadSheetEntity saveSpreadSheetToDatabase(SpreadSheetEntity spreadSheetEntity);

    Iterable<SpreadSheetEntity> getSpreadSheets();
}
