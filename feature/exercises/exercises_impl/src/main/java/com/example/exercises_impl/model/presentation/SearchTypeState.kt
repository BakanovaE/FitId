package com.example.exercises_impl.model.presentation

sealed class SearchTypeState {

    object Loading: SearchTypeState()

    data class Success(
        val items: List<ChipsItemModel>
    ): SearchTypeState()

    data class Error(
        val exception: Throwable
    ): SearchTypeState()
}