package br.com.geradordedevs.financialnotification.services;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import org.springframework.web.multipart.MultipartFile;

public interface SpreadSheetService {

    void saveSpreadSheetToDatabase(MultipartFile file);

    Iterable<SpreadSheetEntity> getSpreadSheets();
}
