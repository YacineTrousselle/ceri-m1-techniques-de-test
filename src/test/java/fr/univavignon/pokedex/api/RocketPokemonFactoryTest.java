package fr.univavignon.pokedex.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RocketPokemonFactoryTest {

    private final IPokemonFactory pokemonFactory = new RocketPokemonFactory();

    public void testCreateBulbizarre() {
        Pokemon bulbizarre = pokemonFactory.createPokemon(0, 613, 64, 4000, 4);

        assertEquals(bulbizarre.getIndex(), 0);
        assertEquals(bulbizarre.getName(), "Bulbizarre");
        assertEquals(bulbizarre.getAttack(), 126);
        assertEquals(bulbizarre.getDefense(), 126);
        assertEquals(bulbizarre.getStamina(), 90);
        assertEquals(bulbizarre.getCp(), 613);
        assertEquals(bulbizarre.getHp(), 64);
        assertEquals(bulbizarre.getDust(), 4000);
        assertEquals(bulbizarre.getCandy(), 4);
        assertEquals(bulbizarre.getIv(), 0);
    }

    public void testCreateAquali() {
        Pokemon aquali = pokemonFactory.createPokemon(133, 2729, 202, 5000, 4);

        assertEquals(aquali.getIndex(), 133);
        assertEquals(aquali.getName(), "Aquali");
        assertEquals(aquali.getAttack(), 186);
        assertEquals(aquali.getDefense(), 168);
        assertEquals(aquali.getStamina(), 260);
        assertEquals(aquali.getCp(), 2729);
        assertEquals(aquali.getHp(), 202);
        assertEquals(aquali.getDust(), 5000);
        assertEquals(aquali.getCandy(), 4);
        assertEquals(aquali.getIv(), 0);
    }
}
