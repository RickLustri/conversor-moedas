package br.senac.sp.moedas.domain.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PesoArgentinoEntityTest {

    @Test
    void testConverterMoedaParaPesoArgentino() {
        // Arrange
        PesoArgentinoEntity pesoEntity = new PesoArgentinoEntity(1.0);  // Valor em reais

        // Act
        Double resultado = pesoEntity.converterMoedaParaPesoArgentino();

        // Assert
        assertEquals(172.96, resultado);  // 1.0 * 172.96 = 172.96
    }

    @Test
    void testEqualsAndHashCode() {
        // Arrange
        PesoArgentinoEntity entity1 = new PesoArgentinoEntity(100.0);
        PesoArgentinoEntity entity2 = new PesoArgentinoEntity(100.0);
        PesoArgentinoEntity entity3 = new PesoArgentinoEntity(200.0);

        // Act & Assert
        assertEquals(entity1, entity2);  // Verifica se objetos com os mesmos valores são iguais
        assertNotEquals(entity1, entity3);  // Verifica se objetos com valores diferentes não são iguais
        assertEquals(entity1.hashCode(), entity2.hashCode());  // Verifica se hashCodes são iguais para objetos iguais
        assertNotEquals(entity1.hashCode(), entity3.hashCode());  // Verifica se hashCodes são diferentes para objetos diferentes
    }

    @Test
    void testEqualsWithNullAndDifferentClass() {
        // Arrange
        PesoArgentinoEntity entity = new PesoArgentinoEntity(100.0);

        // Act & Assert
        assertNotEquals(entity, null);  // Verifica se entity não é igual a null
        assertNotEquals(entity, "Some String");  // Verifica se entity não é igual a um objeto de classe diferente
    }
}
