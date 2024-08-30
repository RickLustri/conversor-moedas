package br.senac.sp.moedas.application.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MoedaRequestTest {

    @Test
    void testMoedaRequestConstructor() {
        // Arrange & Act
        MoedaRequest request = new MoedaRequest(100.0, "DOLLAR");

        // Assert
        assertEquals(100.0, request.getValorReais());
        assertEquals("DOLLAR", request.getConverterPara());
    }

    @Test
    void testSettersAndGetters() {
        // Arrange
        MoedaRequest request = new MoedaRequest(0.0, "");

        // Act
        request.setValorReais(200.0);
        request.setConverterPara("PESO");

        // Assert
        assertEquals(200.0, request.getValorReais());
        assertEquals("PESO", request.getConverterPara());
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        MoedaRequest request1 = new MoedaRequest(150.0, "DOLLAR");
        MoedaRequest request2 = new MoedaRequest(150.0, "DOLLAR");
        MoedaRequest request3 = new MoedaRequest(200.0, "PESO");

        // Act & Assert
        assertEquals(request1, request2); // Verifica se objetos com mesmos valores são iguais
        assertNotEquals(request1, request3); // Verifica se objetos com valores diferentes não são iguais
        assertEquals(request1.hashCode(), request2.hashCode()); // Verifica se hashCodes são iguais para objetos iguais
        assertNotEquals(request1.hashCode(), request3.hashCode()); // Verifica se hashCodes são diferentes para objetos diferentes
    }

    @Test
    void testEqualsWithNullAndDifferentClass() {
        // Arrange
        MoedaRequest request = new MoedaRequest(100.0, "DOLLAR");

        // Act & Assert
        assertNotEquals(request, null); // Verifica se request não é igual a null
        assertNotEquals(request, "Some String"); // Verifica se request não é igual a um objeto de classe diferente
    }
}
