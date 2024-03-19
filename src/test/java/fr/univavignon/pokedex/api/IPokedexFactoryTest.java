package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokedexFactoryTest {

    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void init() {
        pokedexFactory = new MyPokedexFactory();
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertInstanceOf(IPokedex.class, pokedex);
    }
}
