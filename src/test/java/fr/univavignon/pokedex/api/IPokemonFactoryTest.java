package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);
    private final IPokemonFactory pokemonFactory = new MyPokemonFactory(pokemonMetadataProvider);

    @BeforeEach
    public void setup() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(PokemonMockFactory.getBulbizarreMetadata());
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonMockFactory.getAqualiMetadata());
    }

    @Test
    public void testCreateBulbizarre() {
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
        assertEquals(bulbizarre.getIv(), 0);
    }

    @Test
    public void testCreateAquali() {
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
        assertEquals(aquali.getIv(), 0);
    }
}
