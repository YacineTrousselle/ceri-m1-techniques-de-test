package fr.univavignon.pokedex.api;

import java.util.HashMap;
import java.util.Map;

/**
 * @see fr.univavignon.pokedex.api.IPokemonMetadataProvider
 */
public class MyPokemonMetadataProvider implements IPokemonMetadataProvider {

    private final Map<Integer, PokemonMetadata> pokemonsMetadata = new HashMap<>();

    public MyPokemonMetadataProvider() {
        pokemonsMetadata.put(0, new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        pokemonsMetadata.put(133, new PokemonMetadata(133, "Aquali", 186, 168, 260));
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        if (!pokemonsMetadata.containsKey(index)) {
            throw new PokedexException("PokemonMetadata not found for index " + index);
        }
        return pokemonsMetadata.get(index);
    }
}
