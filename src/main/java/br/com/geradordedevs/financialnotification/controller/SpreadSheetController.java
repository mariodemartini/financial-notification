package br.com.geradordedevs.financialnotification.controller;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.dtos.responses.UploadExcelResponseDTO;
import br.com.geradordedevs.financialnotification.facades.SpreadSheetFacade;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/upload-sheet")
public class SpreadSheetController {

    @Autowired
    private SpreadSheetFacade spreadSheetFacade;

    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "sent successfuly"),
            @ApiResponse(code = 400, message = "bad request"),
    })
    @PostMapping("/data")
    public ResponseEntity<UploadExcelResponseDTO> uploadSpreadSheet (@RequestParam("file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(spreadSheetFacade.uploadSheet(file), HttpStatus.ACCEPTED);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "find all successfuly"),
            @ApiResponse(code = 400, message = "bad request")
    })
    @GetMapping
    public ResponseEntity<List<SpreadSheetResponseDTO>> getSpreadSheets(){
        return new ResponseEntity<>(spreadSheetFacade.getSpreadSheets(), HttpStatus.OK);
    }

}
