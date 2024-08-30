package br.senac.sp.moedas.presentation.rest;

import br.senac.sp.moedas.application.dto.MoedaRequest;
import br.senac.sp.moedas.application.service.ConverterMoedaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig
class MoedaControllerTest {

    @Mock
    private ConverterMoedaService converterMoedaService;

    @InjectMocks
    private MoedaController moedaController;

    @Test
    void testConverterMoeda() {
        // Arrange
        MoedaRequest request = new MoedaRequest(100.0, "DOLLAR");
        Double expectedConversion = 20.0;  // Valor convertido esperado

        when(converterMoedaService.converterMoeda(request)).thenReturn(expectedConversion);

        // Act
        ResponseEntity<?> response = moedaController.converterMoeda(request);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedConversion, response.getBody());
    }
}
