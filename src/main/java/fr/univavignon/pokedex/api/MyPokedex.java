package fr.univavignon.pokedex.api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @see fr.univavignon.pokedex.api.IPokedex
 */
public class MyPokedex implements IPokedex {

    private final IPokemonMetadataProvider pokemonMetadataProvider;

    private final IPokemonFactory pokemonFactory;

    private final List<Pokemon> pokemons = new ArrayList<>();

    public MyPokedex(IPokemonMetadataProvider pokemonMetadataProvider, IPokemonFactory pokemonFactory) {
        this.pokemonMetadataProvider = pokemonMetadataProvider;
        this.pokemonFactory = pokemonFactory;
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) {
        return pokemonFactory.createPokemon(index, cp, hp, dust, candy);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        return pokemonMetadataProvider.getPokemonMetadata(index);
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);

        return pokemons.indexOf(pokemon);
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        try {
            return pokemons.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new PokedexException("No pokemon at index " + id);
        }
    }

    @Override
    public List<Pokemon> getPokemons() {
        return new ArrayList<>(pokemons);
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        sortedPokemons.sort(order);

        return sortedPokemons;
    }
}
