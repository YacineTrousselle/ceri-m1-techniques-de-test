package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

        Mockito.when(pokedex.getPokemon(0)).thenReturn(aquali);
        Mockito.when(pokedex.getPokemon(1)).thenReturn(bulbizarre);

        Mockito.when(pokedex.getPokemon(3)).thenThrow(PokedexException.class);
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(aquali);
        pokemons.add(bulbizarre);

        Mockito.when(pokedex.getPokemons()).thenReturn(pokemons);
    }

    @Test
    public void testPokedex() throws PokedexException {
        int aqualiIndex = 0;
        int bulbizarreIndex = 1;

        int index = pokedex.addPokemon(aquali);
        assertEquals(aqualiIndex, index);
        assertEquals(1, pokedex.size());
        assertEquals(aquali, pokedex.getPokemon(aqualiIndex));

        assertThrows(PokedexException.class, () -> pokedex.getPokemon(3));

        index = pokedex.addPokemon(bulbizarre);
        assertEquals(bulbizarreIndex, index);
        assertEquals(2, pokedex.size());
        assertEquals(bulbizarre, pokedex.getPokemon(bulbizarreIndex));

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(aquali, pokemons.get(0));
        assertEquals(bulbizarre, pokemons.get(1));
    }
}
