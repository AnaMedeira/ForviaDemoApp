package com.forvia.demoapp.presentation.home

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.forvia.demoapp.R
import com.forvia.demoapp.presentation.composables.CardItemView
import com.forvia.demoapp.presentation.details.DetailsScreen
import com.forvia.demoapp.presentation.home.models.HomeOneTimeEvent
import com.forvia.demoapp.presentation.home.models.HomeUIEvent
import com.forvia.demoapp.ui.theme.ForviaDemoAppTheme
import com.forvia.demoapp.util.MultiDevicePreview
import com.forvia.domain.model.AppItem
import kotlinx.serialization.Serializable


@Serializable
data object HomeScreen

fun NavGraphBuilder.homeScreen(navController: NavController) {
    composable<HomeScreen> {
        Log.d("NavigationGraph ====== ", navController.graph.toString())
        HomeRouter(navController = navController)
    }
}

@Composable
fun HomeRouter(navController: NavController, homeViewModel: HomeViewModel = hiltViewModel()) {

    val uiState by homeViewModel.uiStateFlow.collectAsState()

    HomeScreen(
        appItems = uiState.appList,
        onEvent = { homeViewModel.dispatch(it) }
    )
    val oneTimeEvent = homeViewModel.oneTimeEvents.collectAsState(initial = null)
    LaunchedEffect(oneTimeEvent.value) {
        when (val event = oneTimeEvent.value) {
            is HomeOneTimeEvent.NavigateToDetails -> {
                val route = DetailsScreen(appItem = event.item)
                Log.d("route ====== ", route.toString())
                navController.navigate(route)
            }


            null -> Unit
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    appItems: List<AppItem>,
    onEvent: (HomeUIEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    navigationIconContentColor = Color.White,
                    titleContentColor = MaterialTheme.colorScheme.inversePrimary,
                    actionIconContentColor = Color.White,
                    scrolledContainerColor = Color.Transparent
                ),
                title = {
                    Text(
                        stringResource(R.string.app_name),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
            )
        },
    ) { paddingValues ->
        val state = rememberLazyStaggeredGridState()
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            state = state,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(appItems) { appItem ->
                    CardItemView(appItem = appItem,
                        onItemClick = { onEvent(HomeUIEvent.SelectApp(appItem)) })
                }
            }
        )
    }
}

@MultiDevicePreview
@Composable
fun HomeScreenPreview() {
    val testCardItems = listOf(
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
    ForviaDemoAppTheme {
        HomeScreen(testCardItems, {})
    }


}