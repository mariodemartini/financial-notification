package br.com.geradordedevs.financialnotification.controllers;

import br.com.geradordedevs.financialnotification.controller.SpreadSheetController;
import br.com.geradordedevs.financialnotification.facades.SpreadSheetFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(SpreadSheetController.class)
@AutoConfigureMockMvc
@TestPropertySource(properties = "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration")
public class SpreadSheetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SpreadSheetFacade spreadSheetFacade;

    private static final String LIST_ROUTE = "/upload-sheet";
    private static final String WRONG_LIST_ROUTE = "/uploadsheet";
    private static final String UPLOAD_ROUTE = "/upload-sheet/data";

    @Test
    public void uploadSpreadSheetShouldReturnAccepted() throws Exception{

    }

    @Test
    public void getSpreadSheetsShouldReturnOk() throws Exception{
        mockMvc.perform(get(LIST_ROUTE)).andExpect(status().isOk());
    }

    @Test
    public void getSpreadSheetsWrongRouteShouldReturnNotFound() throws Exception{
        mockMvc.perform(get(WRONG_LIST_ROUTE)).andExpect(status().isNotFound());
    }
}
