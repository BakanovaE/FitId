package com.example.exercises_impl.utils

import com.example.exercises_impl.model.data.Equipment
import com.example.exercises_impl.model.data.ExerciseBaseInfo
import com.example.exercises_impl.model.data.ExerciseCategory
import com.example.exercises_impl.model.data.ExerciseComment
import com.example.exercises_impl.model.data.ExerciseImage
import com.example.exercises_impl.model.data.ExerciseInfoAlias
import com.example.exercises_impl.model.data.ExerciseTranslationBaseInfo
import com.example.exercises_impl.model.data.ExerciseVideoInfo
import com.example.exercises_impl.model.data.License
import com.example.exercises_impl.model.data.Muscles
import com.example.exercises_impl.model.presentation.ChipsItemModel
import java.util.Date
import java.util.UUID

object Constants {

    val MUSCLES_LIST = listOf(
        Muscles(
            1,
            "Title",
            "",
            false,
            "",
            ""
        ),
        Muscles(
            2,
            "Title2",
            "",
            false,
            "",
            ""
        )
    )
    val CHIPS_LIST = listOf(
        ChipsItemModel(
            1,
            "Title"
        ),
        ChipsItemModel(
            2,
            "Title2"
        ),
    )
    val EQUIPMENT_LIST = listOf(
        Equipment(
            1,
            "Title"
        ),
        Equipment(
            2,
            "Title2"
        )
    )
    val EXERCISES_LIST = listOf(
        ExerciseBaseInfo(
            1,
            UUID.randomUUID(),
            Date(1L),
            Date(2L),
            Date(3L),
            ExerciseCategory(1, "name"),
            MUSCLES_LIST,
            MUSCLES_LIST,
            EQUIPMENT_LIST,
            License(1, "", "", ""),
            null,
            listOf(
                ExerciseImage(
                    1,
                    UUID.randomUUID(),
                    1,
                    UUID.randomUUID(),
                    "",
                    true,
                    "",
                    1,
                    "",
                    "",
                    "",
                    "",
                    "",
                    listOf("")
                )
            ),
            listOf(
                ExerciseTranslationBaseInfo(
                    1,
                    UUID.randomUUID(),
                    "name",
                    1,
                    "",
                    "",
                    234,
                    listOf(ExerciseInfoAlias(234, "")),
                    listOf(ExerciseComment(567, 98, "")),
                    1,
                    "",
                    "",
                    "",
                    "",
                    "",
                    listOf("")
                )
            ),
            345,
            listOf(
                ExerciseVideoInfo(
                    1,
                    UUID.randomUUID(),
                    765,
                    "",
                    true,
                    897,
                    "",
                    1,
                    987,
                    "",
                    "",
                    234,
                    "",
                    "",
                    "",
                    "",
                    "",
                    listOf("")
                )
            ),
            listOf(""),
            listOf("")
        )
    )
}