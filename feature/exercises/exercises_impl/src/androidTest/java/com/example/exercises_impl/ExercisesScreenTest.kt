package com.example.exercises_impl

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.example.design_system.theme.FitIdTheme
import com.example.exercises_impl.data.ResponseToChipsItemConverter
import com.example.exercises_impl.domain.ExercisesConnectionUseCase
import com.example.exercises_impl.domain.ExercisesUseCase
import com.example.exercises_impl.domain.GetSearchTypeUseCase
import com.example.exercises_impl.model.data.Equipment
import com.example.exercises_impl.model.data.ExerciseBaseInfo
import com.example.exercises_impl.model.data.ExerciseCategory
import com.example.exercises_impl.model.data.ExerciseComment
import com.example.exercises_impl.model.data.ExerciseImage
import com.example.exercises_impl.model.data.ExerciseInfoAlias
import com.example.exercises_impl.model.data.ExerciseTranslationBaseInfo
import com.example.exercises_impl.model.data.ExerciseVideoInfo
import com.example.exercises_impl.model.data.ExercisesFilter
import com.example.exercises_impl.model.data.License
import com.example.exercises_impl.model.data.Muscles
import com.example.exercises_impl.model.presentation.ChipsItemModel
import com.example.exercises_impl.model.presentation.SearchTypeState
import com.example.exercises_impl.presentation.ExercisesScreen
import com.example.exercises_impl.presentation.ExercisesViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.Date
import java.util.UUID

class ExercisesScreenTest {

//    private val useCase: GetSearchTypeUseCase = mockk(relaxed = true)
//    private val converter: ResponseToChipsItemConverter = mockk(relaxed = true)
//    private val exercisesUseCase: ExercisesUseCase = mockk(relaxed = true)
//    private val exercisesConnectionUseCase: ExercisesConnectionUseCase = mockk(relaxed = true)
//    private lateinit var viewModel: ExercisesViewModel
//    @get:Rule
//    val composeTestRule = createComposeRule()
//
//    @Before
//    fun setUp() {
//        viewModel =
//            ExercisesViewModel(useCase, converter, exercisesUseCase, exercisesConnectionUseCase)
//        MockKAnnotations.init(this, true)
//        every { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns false
//        every { exercisesConnectionUseCase.isWiFiConnectionEnabled() } returns true
//        every { viewModel.checkConnection() } returns true
//        every { viewModel.getMuscles() } answers { CHIPS_LIST }
//        every { viewModel.getEquipment() } answers { EQUIPMENT_LIST }
//        every { viewModel.getExercises(ExercisesFilter(null, null)) } answers { EXERCISES_LIST }
//    }
//
//    @Test
//    fun loaderForChipsWhenStateIsLoading() {
////        val state: StateFlow<SearchTypeState> = MutableStateFlow (SearchTypeState.Loading)
////        viewModel.searchTypeStateFlow = MutableStateFlow (SearchTypeState.Loading)
//        every { exercisesConnectionUseCase.isOnlyWiFiRequired() } returns false
//        every { exercisesConnectionUseCase.isWiFiConnectionEnabled() } returns true
//        every { viewModel.checkConnection() } returns true
//        every { viewModel.getMuscles() } answers { CHIPS_LIST }
//        composeTestRule.setContent {
//            FitIdTheme {
//                ExercisesScreen(searchType = "MUSCLES GROUP", viewModel = viewModel)
//            }
//        }
//        composeTestRule.onNodeWithTag("Loader").assertIsDisplayed()
////        viewModel.getMuscles()
//        composeTestRule.waitForIdle()
//        composeTestRule.onNodeWithTag("Chip").assertExists()
//    }
//
//
//    private companion object {
//        val MUSCLES_LIST = listOf(
//            Muscles(
//                1,
//                "Title",
//                "",
//                false,
//                "",
//                ""
//            ),
//            Muscles(
//                2,
//                "Title2",
//                "",
//                false,
//                "",
//                ""
//            )
//        )
//        val CHIPS_LIST = listOf(
//            ChipsItemModel(
//                1,
//                "Title"
//            ),
//            ChipsItemModel(
//                2,
//                "Title2"
//            ),
//        )
//        val EQUIPMENT_LIST = listOf(
//            Equipment(
//                1,
//                "Title"
//            ),
//            Equipment(
//                2,
//                "Title2"
//            )
//        )
//        val EXERCISES_LIST = listOf(
//            ExerciseBaseInfo(
//                1,
//                UUID.randomUUID(),
//                Date(1L),
//                Date(2L),
//                Date(3L),
//                ExerciseCategory(1, "name"),
//                MUSCLES_LIST,
//                MUSCLES_LIST,
//                EQUIPMENT_LIST,
//                License(1, "", "", ""),
//                null,
//                listOf(
//                    ExerciseImage(
//                        1,
//                        UUID.randomUUID(),
//                        1,
//                        UUID.randomUUID(),
//                        "",
//                        true,
//                        "",
//                        1,
//                        "",
//                        "",
//                        "",
//                        "",
//                        "",
//                        listOf("")
//                    )
//                ),
//                listOf(
//                    ExerciseTranslationBaseInfo(
//                        1,
//                        UUID.randomUUID(),
//                        "name",
//                        1,
//                        "",
//                        "",
//                        234,
//                        listOf(ExerciseInfoAlias(234, "")),
//                        listOf(ExerciseComment(567, 98, "")),
//                        1,
//                        "",
//                        "",
//                        "",
//                        "",
//                        "",
//                        listOf("")
//                    )
//                ),
//                345,
//                listOf(
//                    ExerciseVideoInfo(
//                        1,
//                        UUID.randomUUID(),
//                        765,
//                        "",
//                        true,
//                        897,
//                        "",
//                        1,
//                        987,
//                        "",
//                        "",
//                        234,
//                        "",
//                        "",
//                        "",
//                        "",
//                        "",
//                        listOf("")
//                    )
//                ),
//                listOf(""),
//                listOf("")
//            )
//        )
//    }
}