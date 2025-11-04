@file:OptIn(ExperimentalMaterial3Api::class)

package me.rezapour.constructors.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import me.rezapour.constructors.viewmodel.ConstructorUiState

@Composable
fun ConstructorsScreen(
    uiState: ConstructorUiState,
    onBackPressed: () -> Unit,
    messageUpdate: (String) -> Unit
) {
    ConstructorList(uiState,messageUpdate)

}

@Composable
fun ConstructorList(
    uiState: ConstructorUiState,
    messageUpdate: (String) -> Unit
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Constructors")
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it.calculateTopPadding())
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            TextField(
                value = uiState.text,
                onValueChange = {
                    messageUpdate(it)
                }
            )
        }
    }


}