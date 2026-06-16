@file:OptIn(ExperimentalMaterial3Api::class)

package me.rezapour.drivers.compse

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import me.rezapour.domain.models.Driver
import me.rezapour.drivers.viewmodel.DriverListViewModel

@Composable
fun DriversScreen(
    viewModel: DriverListViewModel = hiltViewModel(),
    onDriverClicked: (String) -> Unit,
) {
    val items = viewModel.drivers.collectAsLazyPagingItems()
    ScreenContent(items, onDriverClicked)

}

@Composable
fun ScreenContent(
    items: LazyPagingItems<Driver>,
    onDriverClicked: (String) -> Unit,
) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Driver List")
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(
                    top = paddingValues.calculateTopPadding(),
                    start = 8.dp,
                    end = 8.dp
                )
                .fillMaxSize()
                .navigationBarsPadding()
        ) {
            items(
                count = items.itemCount,
                key = items.itemKey { it.driverId }
            ) { index ->
                val driver = items[index]
                driver?.let {
                    DriverItem(
                        modifier = Modifier.padding(4.dp),
                        driverId = driver.driverId,
                        name = "${driver.givenName} ${driver.familyName}",
                        nationality = driver.nationality,
                        dateOfBirth = driver.dateOfBirth,
                        onDriverClicked = onDriverClicked
                    )
                }
            }
        }
    }
}

@Composable
private fun DriverItem(
    modifier: Modifier = Modifier,
    driverId: String,
    name: String,
    dateOfBirth: String,
    nationality: String,
    onDriverClicked: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onDriverClicked(driverId)
            },
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = name,
            fontSize = TextUnit(16f, TextUnitType.Sp)
        )

        Row {
            Text(dateOfBirth)
            Spacer(modifier = Modifier.width(6.dp))
            Text(text = nationality)
        }

    }
}

val drivers = listOf(
    Driver(
        driverId = "hamilton",
        url = "https://en.wikipedia.org/wiki/Lewis_Hamilton",
        givenName = "Lewis",
        familyName = "Hamilton",
        dateOfBirth = "1985-01-07",
        nationality = "British"
    ),
    Driver(
        driverId = "max_verstappen",
        url = "https://en.wikipedia.org/wiki/Max_Verstappen",
        givenName = "Max",
        familyName = "Verstappen",
        dateOfBirth = "1997-09-30",
        nationality = "Dutch"
    ),
    Driver(
        driverId = "leclerc",
        url = "https://en.wikipedia.org/wiki/Charles_Leclerc",
        givenName = "Charles",
        familyName = "Leclerc",
        dateOfBirth = "1997-10-16",
        nationality = "Monégasque"
    ),
    Driver(
        driverId = "norris",
        url = "https://en.wikipedia.org/wiki/Lando_Norris",
        givenName = "Lando",
        familyName = "Norris",
        dateOfBirth = "1999-11-13",
        nationality = "British"
    ),
    Driver(
        driverId = "alonso",
        url = "https://en.wikipedia.org/wiki/Fernando_Alonso",
        givenName = "Fernando",
        familyName = "Alonso",
        dateOfBirth = "1981-07-29",
        nationality = "Spanish"
    ),
    Driver(
        driverId = "sainz",
        url = "https://en.wikipedia.org/wiki/Carlos_Sainz_Jr.",
        givenName = "Carlos",
        familyName = "Sainz",
        dateOfBirth = "1994-09-01",
        nationality = "Spanish"
    ),
    Driver(
        driverId = "russell",
        url = "https://en.wikipedia.org/wiki/George_Russell_(racing_driver)",
        givenName = "George",
        familyName = "Russell",
        dateOfBirth = "1998-02-15",
        nationality = "British"
    ),
    Driver(
        driverId = "piastri",
        url = "https://en.wikipedia.org/wiki/Oscar_Piastri",
        givenName = "Oscar",
        familyName = "Piastri",
        dateOfBirth = "2001-04-06",
        nationality = "Australian"
    ),
    Driver(
        driverId = "ricciardo",
        url = "https://en.wikipedia.org/wiki/Daniel_Ricciardo",
        givenName = "Daniel",
        familyName = "Ricciardo",
        dateOfBirth = "1989-07-01",
        nationality = "Australian"
    ),
    Driver(
        driverId = "vettel",
        url = "https://en.wikipedia.org/wiki/Sebastian_Vettel",
        givenName = "Sebastian",
        familyName = "Vettel",
        dateOfBirth = "1987-07-03",
        nationality = "German"
    )
)

