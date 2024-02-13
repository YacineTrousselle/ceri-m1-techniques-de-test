package fr.univavignon.pokedex.api;

public class PokemonMockFactory {

    public static PokemonMetadata getBulbizarreMetadata() {
        return new PokemonMetadata(0, "Bulbizarre", 126, 126, 90);
    }

    public static PokemonMetadata getAqualiMetadata() {
        return new PokemonMetadata(133, "Aquali", 186, 168, 260);
    }

    public static Pokemon getBulbizarre() {
        PokemonMetadata bulbizarreMetadata = getBulbizarreMetadata();

        return new Pokemon(
                bulbizarreMetadata.getIndex(),
                bulbizarreMetadata.getName(),
                bulbizarreMetadata.getAttack(),
                bulbizarreMetadata.getDefense(),
                bulbizarreMetadata.getStamina(),
                613,
                64,
                4000,
                4,
                56
        );
    }

    public static Pokemon getAquali() {
        PokemonMetadata aqualiMetadata = getAqualiMetadata();

        return new Pokemon(
                aqualiMetadata.getIndex(),
                aqualiMetadata.getName(),
                aqualiMetadata.getAttack(),
                aqualiMetadata.getDefense(),
                aqualiMetadata.getStamina(),
                2729,
                202,
                5000,
                4,
                100
        );
    }

}
