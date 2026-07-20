package me.rezapour.drivers.compse

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun DriverDetailScreen(
    driverId: String,
    onBackPress: () -> Unit
) {

    Box(modifier = Modifier.fillMaxSize()) {

        Text(modifier = Modifier.align(alignment = Alignment.Center), text = "Driver Detail Screen $driverId")

    }
}


@Preview
@Composable
fun DriverDetailScreenPreview() {
    DriverDetailScreen(driverId = ""){

    }
}