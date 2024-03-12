package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IPokemonMetadataProviderTest {

    private final IPokemonMetadataProvider pokemonMetadataProvider = new MyPokemonMetadataProvider();

    @Test
    public void testGetBulbizarreMetadata() throws PokedexException {
        PokemonMetadata bulbizarre = pokemonMetadataProvider.getPokemonMetadata(0);

        assertEquals(bulbizarre.getIndex(), 0);
        assertEquals(bulbizarre.getName(), "Bulbizarre");
        assertEquals(bulbizarre.getAttack(), 126);
        assertEquals(bulbizarre.getDefense(), 126);
        assertEquals(bulbizarre.getStamina(), 90);
    }

    @Test
    public void testGetAqualiMetadata() throws PokedexException {
        PokemonMetadata aquali = pokemonMetadataProvider.getPokemonMetadata(133);

        assertEquals(aquali.getIndex(), 133);
        assertEquals(aquali.getName(), "Aquali");
        assertEquals(aquali.getAttack(), 186);
        assertEquals(aquali.getDefense(), 168);
        assertEquals(aquali.getStamina(), 260);
    }

    @Test
    public void testGetPokemonThatDontExist() throws PokedexException {
        assertThrows(PokedexException.class, () -> pokemonMetadataProvider.getPokemonMetadata(-1));
    }
}
