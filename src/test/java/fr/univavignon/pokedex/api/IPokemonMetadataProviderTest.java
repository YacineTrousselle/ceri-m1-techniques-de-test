package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    @Mock
    private IPokemonMetadataProvider pokemonMetadataProvider;

    @BeforeEach
    public void init() throws PokedexException {
        when(pokemonMetadataProvider.getPokemonMetadata(1)).thenReturn(PokemonMockFactory.getBulbizarreMetadata());
        when(pokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(PokemonMockFactory.getAqualiMetadata());
    }

    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata bulbizarre = pokemonMetadataProvider.getPokemonMetadata(1);

        assertEquals(bulbizarre.getIndex(), 0);
        assertEquals(bulbizarre.getName(), "Bulbizarre");
        assertEquals(bulbizarre.getAttack(), 126);
        assertEquals(bulbizarre.getDefense(), 126);
        assertEquals(bulbizarre.getStamina(), 90);

        PokemonMetadata aquali = pokemonMetadataProvider.getPokemonMetadata(133);

        assertEquals(aquali.getIndex(), 133);
        assertEquals(aquali.getName(), "Aquali");
        assertEquals(aquali.getAttack(), 186);
        assertEquals(aquali.getDefense(), 168);
        assertEquals(aquali.getStamina(), 260);
    }
}
