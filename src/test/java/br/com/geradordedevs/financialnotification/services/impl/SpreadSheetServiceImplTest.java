package br.com.geradordedevs.financialnotification.services.impl;

import br.com.geradordedevs.financialnotification.entites.SpreadSheetEntity;
import br.com.geradordedevs.financialnotification.repositories.SpreadSheetRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class SpreadSheetServiceImplTest {

    @InjectMocks
    private SpreadSheetServiceImpl spreadSheetService;

    @Mock
    private SpreadSheetRepository spreadSheetRepository;

    private static final Long MOCK_ID = 1L;
    private static final String MOCK_MONTH = "July";
    private static final BigDecimal MOCK_INPUT = new BigDecimal(100.00);
    private static final BigDecimal MOCK_OUTPUT = new BigDecimal(50.00);
    private static final BigDecimal MOCK_AMOUNT = new BigDecimal(50.00);

    @Before
    public void setupMock(){
        when(spreadSheetRepository.save(returnSpreadSheetEntity())).thenReturn(returnSpreadSheetEntity());
        when(spreadSheetRepository.findAll()).thenReturn(returnListSpreadSheetEntity());
    }


    @Test
    public void saveSpreadSheetToDatabaseReturnOk() throws Exception{
        assertEquals(returnSpreadSheetEntity(), spreadSheetService.saveSpreadSheetToDatabase(returnSpreadSheetEntity()));
    }

    @Test
    public void getSpreadSheetsReturnOk() throws Exception{
        assertEquals(returnListSpreadSheetEntity(), spreadSheetService.getSpreadSheets());
    }

    private SpreadSheetEntity returnSpreadSheetEntity() {
        return new SpreadSheetEntity(MOCK_ID, MOCK_MONTH, MOCK_INPUT, MOCK_OUTPUT, MOCK_AMOUNT);
    }

    private List<SpreadSheetEntity> returnListSpreadSheetEntity() {
        List<SpreadSheetEntity> list = new ArrayList<>();
        list.add(returnSpreadSheetEntity());

        return list;
    }

}
