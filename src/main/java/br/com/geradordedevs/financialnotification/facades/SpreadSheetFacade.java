package br.com.geradordedevs.financialnotification.facades;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.dtos.responses.UploadExcelResponseDTO;
import org.apache.commons.mail.EmailException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

public interface SpreadSheetFacade {
    
    List<SpreadSheetResponseDTO> getSpreadSheets();

    UploadExcelResponseDTO uploadSheet(MultipartFile file) throws IOException;

    void getSpreadSheetFromExcel(InputStream inputStream);

    void sendEmail(String month, BigDecimal amount) throws EmailException;
}