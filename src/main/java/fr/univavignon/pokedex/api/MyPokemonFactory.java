package fr.univavignon.pokedex.api;

public class MyPokemonFactory implements IPokemonFactory {
    private final IPokemonMetadataProvider pokemonMetadataProvider;

    public MyPokemonFactory(IPokemonMetadataProvider pokemonMetadataProvider) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        try {
            PokemonMetadata pokemonMetadata = pokemonMetadataProvider.getPokemonMetadata(index);
            return new Pokemon(
                    index,
                    pokemonMetadata.getName(),
                    pokemonMetadata.getAttack(),
                    pokemonMetadata.getDefense(),
                    pokemonMetadata.getStamina(),
                    cp,
                    hp,
                    dust,
                    candy,
                    calculateIv()
            );
        } catch (PokedexException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private int calculateIv() {
        return 0;
    }
}
