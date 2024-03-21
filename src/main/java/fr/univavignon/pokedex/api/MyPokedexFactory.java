package fr.univavignon.pokedex.api;

/**
 * @see fr.univavignon.pokedex.api.IPokedexFactory
 */
public class MyPokedexFactory implements IPokedexFactory {
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        return new MyPokedex(pokemonMetadataProvider, pokemonFactory);
    }
}
