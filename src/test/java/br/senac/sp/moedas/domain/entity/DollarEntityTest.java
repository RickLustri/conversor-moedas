package br.senac.sp.moedas.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarEntityTest {

    @Test
    void testConverterMoedaParaDollarAmericano() {
        // Arrange
        DollarEntity dollarEntity = new DollarEntity(109.6);  // Valor em reais

        // Act
        Double resultado = dollarEntity.converterMoedaParaDollarAmericano();

        // Assert
        assertEquals(20.0, resultado);  // 109.6 / 5.48 = 20.0
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        DollarEntity entity1 = new DollarEntity(100.0);
        DollarEntity entity2 = new DollarEntity(100.0);
        DollarEntity entity3 = new DollarEntity(200.0);

        // Act & Assert
        assertEquals(entity1, entity2);  // Verifica se objetos com os mesmos valores são iguais
        assertNotEquals(entity1, entity3);  // Verifica se objetos com valores diferentes não são iguais
        assertEquals(entity1.hashCode(), entity2.hashCode());  // Verifica se hashCodes são iguais para objetos iguais
        assertNotEquals(entity1.hashCode(), entity3.hashCode());  // Verifica se hashCodes são diferentes para objetos diferentes
    }

    @Test
    void testEqualsWithNullAndDifferentClass() {
        // Arrange
        DollarEntity entity = new DollarEntity(100.0);

        // Act & Assert
        assertNotEquals(entity, null);  // Verifica se entity não é igual a null
        assertNotEquals(entity, "Some String");  // Verifica se entity não é igual a um objeto de classe diferente
    }
}
