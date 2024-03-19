package fr.univavignon.pokedex.api;

public class MyPokemonTrainerFactory implements IPokemonTrainerFactory {
    @Override
    public PokemonTrainer createTrainer(String name, Team team, IPokedexFactory pokedexFactory) {
        IPokemonMetadataProvider pokemonMetadataProvider = new MyPokemonMetadataProvider();
        IPokemonFactory pokemonFactory = new MyPokemonFactory(pokemonMetadataProvider);

        return new PokemonTrainer(name, team, pokedexFactory.createPokedex(pokemonMetadataProvider, pokemonFactory));
    }
}
