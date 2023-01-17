package br.com.geradordedevs.financialnotification.facades;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.dtos.responses.UploadExcelResponseDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface SpreadSheetFacade {

    boolean validateExcelFile(MultipartFile file);

    List<SpreadSheetResponseDTO> getSpreadSheets();

    UploadExcelResponseDTO uploadSheet(MultipartFile file) throws IOException;
}
