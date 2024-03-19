package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokedexTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider = Mockito.mock(IPokemonMetadataProvider.class);

    @Mock
    private IPokemonFactory pokemonFactory = Mockito.mock(IPokemonFactory.class);

    private IPokedex pokedex;

    private final Pokemon aquali = PokemonMockFactory.getAquali();
    private final Pokemon bulbizarre = PokemonMockFactory.getBulbizarre();

    @BeforeEach
    public void init() throws PokedexException {
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(bulbizarre);
        Mockito.when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(aquali);

        pokedex = new MyPokedex(pokemonMetadataProvider, pokemonFactory);
    }

    @Test
    public void testAddAquali() throws PokedexException {
        int aqualiIndex = 0;
        int index = pokedex.addPokemon(aquali);
        assertEquals(aqualiIndex, index);
        assertEquals(aquali, pokedex.getPokemon(aqualiIndex));
    }

    @Test
    public void testAddBulbizarreAfterAquali() throws PokedexException {
        int bulbizarreIndex = 1;
        pokedex.addPokemon(aquali);

        int index = pokedex.addPokemon(bulbizarre);
        assertEquals(bulbizarreIndex, index);
        assertEquals(bulbizarre, pokedex.getPokemon(bulbizarreIndex));
    }

    @Test
    public void testGetPokemons() {
        pokedex.addPokemon(aquali);
        pokedex.addPokemon(bulbizarre);

        List<Pokemon> pokemons = pokedex.getPokemons();
        assertEquals(aquali, pokemons.get(0));
        assertEquals(bulbizarre, pokemons.get(1));
    }

    @Test
    public void testNotExistingIndex() {
        assertThrows(PokedexException.class, () -> pokedex.getPokemon(3));
    }

    @Test
    public void testSize() {
        assertEquals(0, pokedex.size());

        pokedex.addPokemon(aquali);
        assertEquals(1, pokedex.size());

        pokedex.addPokemon(bulbizarre);
        assertEquals(2, pokedex.size());
    }
}
