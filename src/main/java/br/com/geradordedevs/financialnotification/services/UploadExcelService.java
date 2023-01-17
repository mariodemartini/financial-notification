package br.com.geradordedevs.financialnotification.services;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface UploadExcelService {

    boolean validateExcelFile(MultipartFile file);

    void getSpreadSheetFromExcel(InputStream inputStream);
}
