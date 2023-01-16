package br.com.geradordedevs.financialnotification.controller;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import br.com.geradordedevs.financialnotification.services.SpreadSheetService;
import br.com.geradordedevs.financialnotification.services.UploadExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/upload-sheet")
public class SpreadSheetController {

    @Autowired
    private UploadExcelService uploadExcelService;

    @Autowired
    private SpreadSheetService spreadSheetService;

    @PostMapping("/data")
    public ResponseEntity<?> uploadCustomersData(@RequestParam("file") MultipartFile file){
        this.spreadSheetService.saveSpreadSheetToDatabase(file);
        return  ResponseEntity
                .ok(Map.of("Message", "Customers data uploaded and sabe to database suceeccfully"));
    }

}
