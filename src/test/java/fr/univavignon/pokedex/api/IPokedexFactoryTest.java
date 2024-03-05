package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokedexFactoryTest {

    @Mock
    private IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    @BeforeEach
    public void init() {
        Mockito.when(pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory)).thenReturn(Mockito.mock(IPokedex.class));
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        assertNotNull(pokedex);
        assertInstanceOf(IPokedex.class, pokedex);
    }
}
