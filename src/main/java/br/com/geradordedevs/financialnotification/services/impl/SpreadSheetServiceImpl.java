package br.com.geradordedevs.financialnotification.services.impl;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import br.com.geradordedevs.financialnotification.repositories.SpreadSheetRepository;
import br.com.geradordedevs.financialnotification.services.SpreadSheetService;
import br.com.geradordedevs.financialnotification.services.UploadExcelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@Slf4j
public class SpreadSheetServiceImpl implements SpreadSheetService {

    @Autowired
    private SpreadSheetRepository spreadSheetRepository;

    @Autowired
    private UploadExcelService uploadExcelService;

    @Override
    public void saveSpreadSheetToDatabase(MultipartFile file) {

        if (uploadExcelService.validateExcelFile(file)) {
            try {
                uploadExcelService.getSpreadSheetFromExcel(file.getInputStream());

            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    @Override
    public Iterable<SpreadSheetEntity> getSpreadSheets(){
        log.info("list spreadsheet");
        return spreadSheetRepository.findAll();
    }

}
