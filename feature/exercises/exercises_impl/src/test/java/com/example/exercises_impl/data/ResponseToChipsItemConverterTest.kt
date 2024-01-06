package com.example.exercises_impl.data

import com.example.exercises_impl.model.presentation.ChipsItemModel
import com.example.exercises_impl.utils.Constants.EQUIPMENT_LIST
import com.example.exercises_impl.utils.Constants.MUSCLES_LIST
import com.google.common.truth.Truth
import org.junit.Test

internal class ResponseToChipsItemConverterTest {

    private val responseToChipsItemConverter = ResponseToChipsItemConverter()

    @Test
    fun `testing convert muscles to chips`() {
        val expected = listOf(
            ChipsItemModel(
            1,
            "Title"
        ),
            ChipsItemModel(
                2,
                "Title2"
            ),
        )

        val actual = responseToChipsItemConverter.convertMusclesToChips(MUSCLES_LIST)
        Truth.assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `testing convert equipment to chips`() {
        val expected = listOf(
            ChipsItemModel(
                1,
                "Title"
            ),
            ChipsItemModel(
                2,
                "Title2"
            ),
        )

        val actual = responseToChipsItemConverter.convertEquipmentToChips(EQUIPMENT_LIST)
        Truth.assertThat(actual).isEqualTo(expected)
    }
}