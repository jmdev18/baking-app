/*
 * Copyright 2018 Felipe Joglar Santos
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.fjoglar.bakingapp.data.source.remote;

import com.fjoglar.bakingapp.data.source.remote.jsonmodel.JsonRecipe;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * API for retrieving recipes from the network.
 */
public interface RecipeApiService {

    @GET("/topher/2017/May/59121517_baking/baking.json")
    Observable<List<JsonRecipe>> getRecipesFromJson();
}
