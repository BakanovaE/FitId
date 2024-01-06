package com.example.exercises_impl.data

import com.example.exercises_impl.model.presentation.ChipsItemModel
import com.example.exercises_impl.model.data.Equipment
import com.example.exercises_impl.model.data.Muscles
import javax.inject.Inject

class ResponseToChipsItemConverter @Inject constructor(){

    fun convertMusclesToChips(from: List<Muscles>): List<ChipsItemModel> {
        val chipsList: MutableList<ChipsItemModel> = mutableListOf()
        from.forEach {
            chipsList.add(
                ChipsItemModel(
                    it.id,
                    it.name_en.ifEmpty { it.name }
                )
            )
        }
        return chipsList
    }

    fun convertEquipmentToChips(from: List<Equipment>): List<ChipsItemModel> {
        val chipsList: MutableList<ChipsItemModel> = mutableListOf()
        from.forEach {
            chipsList.add(
                ChipsItemModel(
                    it.id,
                    it.name
                )
            )
        }
        return chipsList
    }
}