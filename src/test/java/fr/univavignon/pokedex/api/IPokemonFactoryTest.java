package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void setup() {
        when(pokemonFactory.createPokemon(0, 613, 64, 4000, 4)).thenReturn(PokemonMockFactory.getBulbizarre());
        when(pokemonFactory.createPokemon(133, 2729, 202, 5000, 4)).thenReturn(PokemonMockFactory.getAquali());
    }

    @Test
    public void testCreatePokemon() {
        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertEquals(bulbizarre.getIndex(), 0);
        assertEquals(bulbizarre.getName(), "Bulbizarre");
        assertEquals(bulbizarre.getAttack(), 126);
        assertEquals(bulbizarre.getDefense(), 126);
        assertEquals(bulbizarre.getStamina(), 90);
        assertEquals(bulbizarre.getCp(), 613);
        assertEquals(bulbizarre.getHp(), 64);
        assertEquals(bulbizarre.getDust(), 4000);
        assertEquals(bulbizarre.getCandy(), 4);

        Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertEquals(aquali.getIndex(), 133);
        assertEquals(aquali.getName(), "Aquali");
        assertEquals(aquali.getAttack(), 186);
        assertEquals(aquali.getDefense(), 168);
        assertEquals(aquali.getStamina(), 260);
        assertEquals(aquali.getCp(), 2729);
        assertEquals(aquali.getHp(), 202);
        assertEquals(aquali.getDust(), 5000);
        assertEquals(aquali.getCandy(), 4);
    }
}
