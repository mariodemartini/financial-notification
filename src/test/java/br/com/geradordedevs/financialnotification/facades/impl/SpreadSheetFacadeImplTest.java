package br.com.geradordedevs.financialnotification.facades.impl;

import br.com.geradordedevs.financialnotification.dtos.responses.SpreadSheetResponseDTO;
import br.com.geradordedevs.financialnotification.dtos.responses.UploadExcelResponseDTO;
import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import br.com.geradordedevs.financialnotification.mappers.SpreadSheetMapper;
import br.com.geradordedevs.financialnotification.services.SendEmailService;
import br.com.geradordedevs.financialnotification.services.SpreadSheetService;
import org.apache.poi.hpsf.ClassIDPredefined;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest
public class SpreadSheetFacadeImplTest {

    @InjectMocks
    private SpreadSheetFacadeImpl spreadSheetFacade;

    @Mock
    private SpreadSheetService spreadSheetService;

    @Mock
    private SendEmailService sendEmailService;

    @Mock
    private SpreadSheetMapper spreadSheetMapper;

    private static final Long MOCK_ID = 1L;
    private static final String MOCK_MONTH = "July";
    private static final BigDecimal MOCK_INPUT = new BigDecimal(100.00);
    private static final BigDecimal MOCK_OUTPUT = new BigDecimal(50.00);
    private static final BigDecimal MOCK_AMOUNT = new BigDecimal(50.00);
    private static final BigDecimal MOCK_NEGATIVE_AMOUNT = BigDecimal.valueOf(-50.00);

    @Before
    public void setupMock(){
        MockitoAnnotations.openMocks(this);
        when(spreadSheetService.getSpreadSheets()).thenReturn(returnListSpreadSheetEntities());

        when(spreadSheetMapper.toListDTO(returnListSpreadSheetEntities())).thenReturn(returnListSpreadSheetDTO());
    }

    @Test
    public void getSpreadSheetsShouldReturnOk() throws Exception{
        assertEquals(returnListSpreadSheetDTO(), spreadSheetFacade.getSpreadSheets());
    }

    @Test
    public void sendEMailReturnOk() throws Exception{
        spreadSheetFacade.sendEmail(MOCK_MONTH, MOCK_NEGATIVE_AMOUNT);
        verify(sendEmailService, timeout(1)).sendEmail(MOCK_MONTH, MOCK_NEGATIVE_AMOUNT);
    }

    private List<SpreadSheetResponseDTO> returnListSpreadSheetDTO() {
        List<SpreadSheetResponseDTO> list = new ArrayList<>();
        list.add(returnSpreadSheetResponseDTO());

        return list;
    }

    private SpreadSheetResponseDTO returnSpreadSheetResponseDTO() {
        return new SpreadSheetResponseDTO(MOCK_MONTH, MOCK_INPUT, MOCK_OUTPUT, MOCK_AMOUNT);
    }

    private List<SpreadSheetEntity> returnListSpreadSheetEntities() {
        List<SpreadSheetEntity> list = new ArrayList<>();
        list.add(returnSpreadSheetEntity());

        return list;
    }

    private SpreadSheetEntity returnSpreadSheetEntity() {
        return new SpreadSheetEntity(MOCK_ID, MOCK_MONTH, MOCK_INPUT, MOCK_OUTPUT, MOCK_AMOUNT);
    }

    private UploadExcelResponseDTO returnUploadExcelResponseDtoTrue() {
        return new UploadExcelResponseDTO(true);
    }

    private MultipartFile returnValidFile() throws IOException {
        FileInputStream file = new FileInputStream("src/test/resource/desafio2.xlsx");

        return new MockMultipartFile(
                "file",
                "desafio2.xlsx",
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",
                file);
    }
}
