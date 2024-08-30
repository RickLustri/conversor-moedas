package br.senac.sp.moedas.application.service.impl;

import br.senac.sp.moedas.application.dto.MoedaRequest;
import br.senac.sp.moedas.application.service.ConverterMoedaService;
import br.senac.sp.moedas.application.usecase.CalculaMoedaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ConverterMoedaServiceImplTest {

    @Mock
    private CalculaMoedaUseCase calculaMoedaUseCase;

    @InjectMocks
    private ConverterMoedaServiceImpl converterMoedaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testConverterMoeda() {
        // Arrange
        MoedaRequest request = new MoedaRequest(100.0, "DOLLAR");
        when(calculaMoedaUseCase.converterMoeda(any(MoedaRequest.class))).thenReturn(20.0);

        // Act
        Double resultado = converterMoedaService.converterMoeda(request);

        // Assert
        assertEquals(20.0, resultado);
    }

    @Test
    void testConverterMoedaParaPeso() {
        // Arrange
        MoedaRequest request = new MoedaRequest(200.0, "PESO");
        when(calculaMoedaUseCase.converterMoeda(any(MoedaRequest.class))).thenReturn(40.0);

        // Act
        Double resultado = converterMoedaService.converterMoeda(request);

        // Assert
        assertEquals(40.0, resultado);
    }
}
