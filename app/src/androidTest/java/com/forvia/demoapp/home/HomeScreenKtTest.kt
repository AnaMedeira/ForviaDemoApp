package com.forvia.demoapp.home

import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasContentDescription
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.forvia.demoapp.presentation.composables.CardItemView
import com.forvia.demoapp.presentation.home.HomeScreen
import com.forvia.domain.model.AppItem
import org.junit.Rule
import org.junit.Test

import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    // Sample data for tests
    private val testCardItems = listOf(
        AppItem(
            id = 1,
            "App Name 1",
            "packageName",
            "App Icon",
            "App graphic",
            "version name",
            0,
            "update"
        ),
        AppItem(
            id = 2,
            "App Name 2",
            "packageName",
            "App Icon",
            "App graphic",
            "version name",
            0,
            "update"
        ),
        AppItem(
            id = 3,
            "App Name 3",
            "packageName",
            "App Icon",
            "App graphic",
            "version name",
            0,
            "update"
        )
    )


    @Test
    fun cardItemView_displaysTitleAndSubtitle() {
        // Arrange: Set up a single card item
        val testAppItem = testCardItems[0]

        composeTestRule.setContent {
            CardItemView(appItem = testAppItem, onItemClick = {})
        }

        // Assert: Check that title and subtitle are displayed
        composeTestRule.onNodeWithText(testAppItem.name).assertIsDisplayed()
        composeTestRule.onNodeWithText(testAppItem.packageName).assertIsDisplayed()

        // Assert: Image node is displayed (Coil will not load an actual image during tests)
        composeTestRule.onNode(
            hasContentDescription(testAppItem.name)
        ).assertIsDisplayed()
    }

    @Test
    fun homescreen_displaysAllItems() {
        // Arrange: Render the list screen with test data
        composeTestRule.setContent {
            HomeScreen(false, appItems = testCardItems, {})

        }

        // Assert: Check that all titles are displayed
        testCardItems.forEach { cardItem ->
            composeTestRule.onNodeWithText(cardItem.name).assertIsDisplayed()
        }

        // Assert: Check the total number of items displayed
        composeTestRule.onAllNodesWithText("packageName").assertCountEquals(3)

    }
}