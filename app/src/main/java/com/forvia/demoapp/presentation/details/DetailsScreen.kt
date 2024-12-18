package com.forvia.demoapp.presentation.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import coil.compose.rememberAsyncImagePainter
import com.forvia.demoapp.R
import com.forvia.demoapp.navigation.AppItemNavType
import com.forvia.demoapp.presentation.composables.DetailsAlertDialog
import com.forvia.demoapp.presentation.composables.DetailsLabels
import com.forvia.demoapp.presentation.composables.PrimaryButton
import com.forvia.demoapp.ui.theme.ForviaDemoAppTheme
import com.forvia.demoapp.util.MultiDevicePreview
import com.forvia.domain.model.AppItem
import kotlinx.serialization.Serializable
import kotlin.reflect.typeOf

@Serializable
data class DetailsScreen(val appItem: AppItem) //This argument is always very small, otherwise I would pass the id and then get the element from DB


private val appItemNavType = AppItemNavType()

fun NavGraphBuilder.detailsScreen(navController: NavController) {
    composable<DetailsScreen>(
        typeMap = mapOf(typeOf<AppItem>() to appItemNavType)
    ) {
        val args = it.toRoute<DetailsScreen>()
        DetailsScreenRoute(
            onBackClick = { navController.navigateUp() },
            appItem = args.appItem
        )
    }
}

@Composable
fun DetailsScreenRoute(
    onBackClick: () -> Unit,
    appItem: AppItem,
    detailsScreenViewModel: DetailsViewModel = hiltViewModel()
) {
    DetailsScreen(appItem, onBackClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    appItem: AppItem,
    onBackClick: () -> Unit
) {

    var showDialog by remember { mutableStateOf(false) }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.onSecondary,

        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(appItem.name) },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick,
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back_acc),
                        )
                    }
                }
            )
        },
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
        ) {
            val screenHeight = LocalConfiguration.current.screenHeightDp.dp
            val imageHeight = screenHeight / 2 // 1/2 of the screen height

            // Load image from URL using Coil
            Image(
                painter = rememberAsyncImagePainter(appItem.appIcon),
                contentDescription = appItem.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(imageHeight),
                contentScale = ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.Top
                ) {
                    Image(
                        painter = rememberAsyncImagePainter(appItem.appIcon),
                        contentDescription = appItem.name,
                        modifier = Modifier
                            .size(64.dp)
                            .padding(end = 8.dp),
                        contentScale = ContentScale.Crop
                    )
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = appItem.name,
                            style = MaterialTheme.typography.titleMedium,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailsLabels(
                            stringResource(R.string.package_name_label),
                            appItem.packageName
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailsLabels(stringResource(R.string.version_label), appItem.versionName)
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailsLabels(stringResource(R.string.last_update_label), appItem.updated)
                        Spacer(modifier = Modifier.height(8.dp))
                        DetailsLabels(
                            stringResource(R.string.downloads_label),
                            appItem.downloads.toString()
                        )
                    }
                }

                Spacer(modifier = Modifier.height(60.dp))
                PrimaryButton(
                    text = stringResource(R.string.download),
                    isEnabled = true,
                    onClick = {
                        //implement
                        showDialog = true
                    }
                )

                DetailsAlertDialog(showDialog = showDialog, onDismiss = { showDialog = false })
            }

        }
    }
}


@MultiDevicePreview
@Composable
fun HomeScreenPreview() {
    val testItem = AppItem(
        id = 1,
        "App Name 1",
        "packageName",
        "App Icon",
        "App graphic",
        "version name",
        0,
        "update"
    )

    ForviaDemoAppTheme {
        DetailsScreen(testItem, {})
    }


}