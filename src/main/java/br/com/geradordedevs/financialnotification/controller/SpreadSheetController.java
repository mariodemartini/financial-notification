package br.com.geradordedevs.financialnotification.controller;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.dtos.responses.UploadExcelResponseDTO;
import br.com.geradordedevs.financialnotification.facades.SpreadSheetFacade;
import br.com.geradordedevs.financialnotification.services.UploadExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/upload-sheet")
public class SpreadSheetController {

    @Autowired
    private UploadExcelService uploadExcelService;

    @Autowired
    private SpreadSheetFacade spreadSheetFacade;

    @PostMapping("/data")
    public UploadExcelResponseDTO uploadSpreadSheet (@RequestParam("file") MultipartFile file) throws IOException {
        return spreadSheetFacade.uploadSheet(file);
    }

    @GetMapping
    public List<SpreadSheetResponseDTO> getSpreadSheets(){
        return spreadSheetFacade.getSpreadSheets();
    }

}
