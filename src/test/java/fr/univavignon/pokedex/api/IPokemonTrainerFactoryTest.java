package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class IPokemonTrainerFactoryTest {

    public static final String NAME = "Jean";
    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    @Mock
    private IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

    @BeforeEach
    public void init() {
        Mockito
                .when(pokemonTrainerFactory.createTrainer(NAME, Team.INSTINCT, pokedexFactory))
                .thenReturn(new PokemonTrainer(NAME, Team.INSTINCT, Mockito.mock(IPokedex.class)));
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer(NAME, Team.INSTINCT, pokedexFactory);

        assertNotNull(trainer);
        assertEquals(NAME, trainer.getName());
        assertEquals(Team.INSTINCT, trainer.getTeam());
        assertInstanceOf(IPokedex.class, trainer.getPokedex());
    }

}
