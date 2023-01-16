package br.com.geradordedevs.financialnotification.services.impl;

import br.com.geradordedevs.financialnotification.repositories.SpreadSheetRepository;
import br.com.geradordedevs.financialnotification.services.SpreadSheetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

@Service
@Slf4j
public class SpreadSheetServiceImpl implements SpreadSheetService {

    @Autowired
    private SpreadSheetRepository spreadSheetRepository;

    @Override
    public boolean validateExcelFile(MultipartFile file) {
        log.info("verify if file is a valid file");
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }
}
