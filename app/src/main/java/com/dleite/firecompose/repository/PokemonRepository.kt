package com.dleite.firecompose.repository

import com.dleite.firecompose.data.remote.PokeAPI
import com.dleite.firecompose.data.remote.responses.Pokemon
import com.dleite.firecompose.data.remote.responses.PokemonList
import com.dleite.firecompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeAPI
) {

    suspend fun getPokemonList(
        limit: Int,
        offset: Int
    ): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        }catch (e: Exception){
            return Resource.Error("Um erro desconhecido ocorreu tente novamente mais terde.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(
        pokemonName: String
    ): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        }catch (e: Exception){
            return Resource.Error("Um erro desconhecido ocorreu tente novamente mais terde.")
        }
        return Resource.Success(response)
    }
}