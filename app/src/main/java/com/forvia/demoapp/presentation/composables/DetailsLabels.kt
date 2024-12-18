package com.forvia.demoapp.presentation.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.forvia.demoapp.R
import com.forvia.demoapp.ui.theme.ForviaDemoAppTheme
import com.forvia.demoapp.util.MultiDevicePreview

@Composable
fun DetailsLabels(
    label: String,
    text: String,
    modifier: Modifier = Modifier,
) {
    // Title and subtitle
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@MultiDevicePreview
@Composable
fun PreviewDetailsLabel() {

    ForviaDemoAppTheme {
        DetailsLabels(stringResource(R.string.package_name_label), "package Name")
    }
}