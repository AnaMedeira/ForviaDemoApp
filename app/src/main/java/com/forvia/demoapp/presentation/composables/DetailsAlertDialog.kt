package com.forvia.demoapp.presentation.composables

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.forvia.demoapp.R


@Composable
fun DetailsAlertDialog(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text(stringResource(R.string.downloads_dialog_error_title)) },
        text = { Text(stringResource(R.string.downloads_dialog_error_body)) },
        confirmButton = {
            TextButton(onClick = { onDismiss() }) {
                Text(stringResource(R.string.downloads_dialog_error_btn))
            }
        },

        )
}