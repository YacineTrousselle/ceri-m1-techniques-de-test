package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokedexTest {

    @Mock
    private IPokedex pokedex = Mockito.mock(IPokedex.class);

    private final Pokemon aquali = PokemonMockFactory.getAquali();
    private final Pokemon bulbizarre = PokemonMockFactory.getBulbizarre();

    @BeforeEach
    public void init() throws PokedexException {
        final int[] size = {0};
        Mockito.doAnswer(invocationOnMock -> ++size[0]).when(pokedex).size();

        Mockito.when(pokedex.addPokemon(aquali)).thenReturn(0);
        Mockito.when(pokedex.addPokemon(bulbizarre)).thenReturn(1);

        Mockito.when(pokedex.getPokemon(133)).thenReturn(aquali);
        Mockito.when(pokedex.getPokemon(0)).thenReturn(bulbizarre);

        Mockito.when(pokedex.getPokemon(1)).thenThrow(PokedexException.class);
    }

    @Test
    public void testPokedex() throws PokedexException {
        int index = pokedex.addPokemon(aquali);
        assertEquals(0, index);
        assertEquals(1, pokedex.size());
        assertEquals(aquali, pokedex.getPokemon(133));
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(1));

        index = pokedex.addPokemon(bulbizarre);
        assertEquals(1, index);
        assertEquals(2, pokedex.size());
        assertEquals(bulbizarre, pokedex.getPokemon(0));
    }
}
