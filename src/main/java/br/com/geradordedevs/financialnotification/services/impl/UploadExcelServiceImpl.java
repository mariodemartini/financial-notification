package br.com.geradordedevs.financialnotification.services.impl;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import br.com.geradordedevs.financialnotification.repositories.SpreadSheetRepository;
import br.com.geradordedevs.financialnotification.services.UploadExcelService;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Objects;

@Service
@Slf4j
public class UploadExcelServiceImpl implements UploadExcelService {

    @Autowired
    private SpreadSheetRepository spreadSheetRepository;

    @Override
    public boolean validateExcelFile(MultipartFile file) {
        log.info("verify if file is a valid file");
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    }

    @Override
    public void getSpreadSheetFromExcel(InputStream inputStream){
        log.info("importing spreadsheet");

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("Planilha1");

            int rowIndex = 0;
            for (Row row : sheet){
                if (rowIndex == 0){
                    rowIndex++;
                    continue;
                }

                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                SpreadSheetEntity spreadSheetEntity = new SpreadSheetEntity();

                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> spreadSheetEntity.setMonth(cell.getStringCellValue());
                        case 1 -> spreadSheetEntity.setInput(BigDecimal.valueOf(cell.getNumericCellValue()));
                        case 2 -> spreadSheetEntity.setOutput(BigDecimal.valueOf(cell.getNumericCellValue()));
                        case 3 -> spreadSheetEntity.setAmount(BigDecimal.valueOf(cell.getNumericCellValue()));
                        default -> {
                        }
                    }
                    cellIndex++;
                }

                spreadSheetRepository.save(spreadSheetEntity);
            }

        } catch (IOException e) {
            e.getStackTrace();
        }

    }

}
