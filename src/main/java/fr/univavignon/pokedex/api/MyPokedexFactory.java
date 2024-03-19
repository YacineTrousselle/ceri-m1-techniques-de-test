package fr.univavignon.pokedex.api;

public class MyPokedexFactory implements IPokedexFactory {
    @Override
    public IPokedex createPokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        return new MyPokedex(pokemonMetadataProvider, pokemonFactory);
    }
}
