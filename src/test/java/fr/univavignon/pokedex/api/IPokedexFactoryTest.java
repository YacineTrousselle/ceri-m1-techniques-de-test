package fr.univavignon.pokedex.api;

import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokedexFactoryTest {

    @Mock
    private IPokedexFactory pokedexFactory;

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @Mock
    private IPokemonFactory pokemonFactory;

    public void testCreatePokedex() {
        IPokedex pokedex = pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory);

        assertNotNull(pokedex);
    }
}
