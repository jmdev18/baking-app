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

package com.fjoglar.bakingapp.recipedetail.domain;

import com.fjoglar.bakingapp.UseCase;
import com.fjoglar.bakingapp.data.model.Ingredient;
import com.fjoglar.bakingapp.data.source.RecipesDataSource;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Scheduler;

/**
 * This class is an implementation of {@link UseCase} that represents a use case for
 * getting a list of {@link Ingredient} of a recipe with a solicited id.
 */
public class GetIngredientsByRecipeId extends UseCase<List<Ingredient>, GetIngredientsByRecipeId.Params> {

    private final RecipesDataSource mRepository;

    public GetIngredientsByRecipeId(RecipesDataSource repository,
                                    Scheduler threadExecutor,
                                    Scheduler postExecutionThread) {
        super(threadExecutor, postExecutionThread);
        mRepository = repository;
    }

    @Override
    public Observable<List<Ingredient>> buildUseCaseObservable(Params params) {
        return mRepository.getIngredientsByRecipeId(params.recipeId);
    }

    public static final class Params {

        private final int recipeId;

        private Params(int recipeId) {
            this.recipeId = recipeId;
        }

        public static Params forRecipe(int recipeId) {
            return new Params(recipeId);
        }
    }
}