package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class IPokemonTrainerFactoryTest {

    @Mock
    private IPokemonTrainerFactory pokemonTrainerFactory = Mockito.mock(IPokemonTrainerFactory.class);
    @Mock
    private IPokedexFactory pokedexFactory = Mockito.mock(IPokedexFactory.class);

    @BeforeEach
    public void init() {
        Mockito
                .when(pokemonTrainerFactory.createTrainer("Jean", Team.INSTINCT, pokedexFactory))
                .thenReturn(new PokemonTrainer("Jean", Team.INSTINCT, Mockito.mock(IPokedex.class)));
    }

    @Test
    public void testCreateTrainer() {
        PokemonTrainer trainer = pokemonTrainerFactory.createTrainer("Jean", Team.INSTINCT, pokedexFactory);

        assertNotNull(trainer);
        assertEquals("Jean", trainer.getName());
        assertEquals(Team.INSTINCT, trainer.getTeam());
    }

}
