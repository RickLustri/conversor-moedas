package br.senac.sp.moedas.application.usecase.impl;

import br.senac.sp.moedas.application.dto.MoedaRequest;
import br.senac.sp.moedas.domain.entity.DollarEntity;
import br.senac.sp.moedas.domain.entity.PesoArgentinoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class CalculaMoedaUseCaseImplTest {

    private CalculaMoedaUseCaseImpl calculaMoedaUseCase;

    @BeforeEach
    void setUp() {
        calculaMoedaUseCase = new CalculaMoedaUseCaseImpl();
    }

    @Test
    void testConverterMoedaParaDollar() {
        // Arrange
        MoedaRequest request = new MoedaRequest(100.0, "DOLLAR");

        try (MockedStatic<DollarEntity> mockedDollarEntity = Mockito.mockStatic(DollarEntity.class)) {
            DollarEntity dollarEntityMock = Mockito.mock(DollarEntity.class);
            mockedDollarEntity.when(() -> new DollarEntity(request.getValorReais()))
                    .thenReturn(dollarEntityMock);
            Mockito.when(dollarEntityMock.converterMoedaParaDollarAmericano()).thenReturn(20.0);

            // Act
            Double resultado = calculaMoedaUseCase.converterMoeda(request);

            // Assert
            assertNotNull(resultado);
            assertEquals(20.0, resultado);
        }
    }

    @Test
    void testConverterMoedaParaPeso() {
        // Arrange
        MoedaRequest request = new MoedaRequest(100.0, "PESO");

        try (MockedStatic<PesoArgentinoEntity> mockedPesoEntity = Mockito.mockStatic(PesoArgentinoEntity.class)) {
            PesoArgentinoEntity pesoEntityMock = Mockito.mock(PesoArgentinoEntity.class);
            mockedPesoEntity.when(() -> new PesoArgentinoEntity(request.getValorReais()))
                    .thenReturn(pesoEntityMock);
            Mockito.when(pesoEntityMock.converterMoedaParaPesoArgentino()).thenReturn(400.0);

            // Act
            Double resultado = calculaMoedaUseCase.converterMoeda(request);

            // Assert
            assertNotNull(resultado);
            assertEquals(400.0, resultado);
        }
    }

    @Test
    void testConverterMoedaComTipoInvalido() {
        // Arrange
        MoedaRequest request = new MoedaRequest(100.0, "EURO");  // Tipo de moeda não implementado

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            calculaMoedaUseCase.converterMoeda(request);
        });

        assertEquals("Nao foi localizado o tipo de moeda", exception.getMessage());
    }
}
