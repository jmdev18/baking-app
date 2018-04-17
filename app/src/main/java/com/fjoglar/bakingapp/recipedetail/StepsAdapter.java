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

package com.fjoglar.bakingapp.recipedetail;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fjoglar.bakingapp.R;
import com.fjoglar.bakingapp.data.model.Step;

import butterknife.BindView;
import butterknife.ButterKnife;

import java.util.List;

/**
 * Adapter that manages a collection of {@link Step}.
 */
public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.ViewHolder> {

    private static final String TAG = StepsAdapter.class.getSimpleName();

    private final StepClickListener mOnClickListener;
    private List<Step> mStepsList;

    public StepsAdapter(StepClickListener listener) {
        mOnClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_step, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Step step = mStepsList.get(position);
        holder.mTextViewRecipeStepDescription.setText(step.getShortDescription());
        holder.itemView.setOnClickListener(v -> mOnClickListener.onStepClicked(step));
    }

    @Override
    public int getItemCount() {
        return (mStepsList == null) ? 0 : mStepsList.size();
    }

    public List<Step> getStepsList() {
        return mStepsList;
    }

    public void setStepsList(List<Step> stepsList) {
        validateStepsList(stepsList);
        mStepsList = stepsList;
        notifyDataSetChanged();
    }

    private void validateStepsList(List<Step> stepsList) {
        if (stepsList == null) {
            throw new IllegalArgumentException("The steps list cannot be null");
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.textview_recipe_step_description)
        TextView mTextViewRecipeStepDescription;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface StepClickListener {
        void onStepClicked(Step step);
    }
}
