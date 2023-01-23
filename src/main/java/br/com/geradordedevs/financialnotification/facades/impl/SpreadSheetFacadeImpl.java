package br.com.geradordedevs.financialnotification.facades.impl;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.dtos.responses.UploadExcelResponseDTO;
import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import br.com.geradordedevs.financialnotification.exceptions.UploadExcelException;
import br.com.geradordedevs.financialnotification.exceptions.enums.UploadExcelEnum;
import br.com.geradordedevs.financialnotification.facades.SpreadSheetFacade;
import br.com.geradordedevs.financialnotification.mappers.SpreadSheetMapper;
import br.com.geradordedevs.financialnotification.services.SendEmailService;
import br.com.geradordedevs.financialnotification.services.SpreadSheetService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.EmailException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@Component
@Slf4j
public class SpreadSheetFacadeImpl implements SpreadSheetFacade {

    @Autowired
    private SpreadSheetService spreadSheetService;

    @Autowired
    private SendEmailService sendEmailService;

    @Autowired
    private SpreadSheetMapper spreadSheetMapper;

    @Override
    public void saveSpreadSheetToDatabase(MultipartFile file) {

        if (spreadSheetService.validateExcelFile(file)) {
            try {
                getSpreadSheetFromExcel(file.getInputStream());

            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    @Override
    public List<SpreadSheetResponseDTO> getSpreadSheets() {
        log.info("list spreadsheet");
        return spreadSheetMapper.toListDTO(spreadSheetService.getSpreadSheets());
    }

    @Override
    public UploadExcelResponseDTO uploadSheet(MultipartFile file) throws IOException {
        UploadExcelResponseDTO uploadExcelResponseDTO = new UploadExcelResponseDTO();

        getSpreadSheetFromExcel(file.getInputStream());

        if (spreadSheetService.validateExcelFile(file)){
            log.info("is true");
            uploadExcelResponseDTO.setSuccess(true);
        }

        return uploadExcelResponseDTO;
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

                spreadSheetService.saveSpreadSheetToDatabase(spreadSheetEntity);

                sendEmail(spreadSheetEntity.getMonth(), spreadSheetEntity.getAmount());
            }

        } catch (UploadExcelException e) {
            throw new UploadExcelException(UploadExcelEnum.ERROR_IMPORTING_SPREADSHEET);

        } catch (IOException e) {
            throw new RuntimeException(e);

        } catch (EmailException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void sendEmail(String month, BigDecimal amount) throws EmailException {
        if (amount.doubleValue() < 0){
            log.info("month: {} / amount $ {} ", month, amount);
            sendEmailService.sendEmail(month, amount);
        }
    }
}
