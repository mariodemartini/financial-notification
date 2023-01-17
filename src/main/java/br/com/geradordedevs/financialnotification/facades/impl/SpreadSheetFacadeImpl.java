package br.com.geradordedevs.financialnotification.facades.impl;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.dtos.responses.UploadExcelResponseDTO;
import br.com.geradordedevs.financialnotification.facades.SpreadSheetFacade;
import br.com.geradordedevs.financialnotification.mappers.SpreadSheetMapper;
import br.com.geradordedevs.financialnotification.services.SpreadSheetService;
import br.com.geradordedevs.financialnotification.services.UploadExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Slf4j
public class SpreadSheetFacadeImpl implements SpreadSheetFacade {

    @Autowired
    private SpreadSheetService spreadSheetService;

    @Autowired
    private UploadExcelService uploadExcelService;

    @Autowired
    private SpreadSheetMapper spreadSheetMapper;

    @Override
    public boolean validateExcelFile(MultipartFile file) {
        return uploadExcelService.validateExcelFile(file);
    }

    @Override
    public List<SpreadSheetResponseDTO> getSpreadSheets() {
        return spreadSheetMapper.toListDTO(spreadSheetService.getSpreadSheets());
    }

    @Override
    public UploadExcelResponseDTO uploadSheet(MultipartFile file) throws IOException {
        UploadExcelResponseDTO uploadExcelResponseDTO = new UploadExcelResponseDTO();
        uploadExcelService.getSpreadSheetFromExcel(file.getInputStream());
        if (validateExcelFile(file)){
            uploadExcelResponseDTO.setSuccess(true);
        }
        return uploadExcelResponseDTO;
    }
}
