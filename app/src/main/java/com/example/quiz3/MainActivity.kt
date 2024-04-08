package com.example.quiz3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz3.data.Person
import com.example.quiz3.data.persons
import com.example.quiz3.navigation.NavigationBar
import com.example.quiz3.ui.theme.Quiz3Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Quiz3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Quiz3App()
                }
            }
        }
    }
}

@Composable
fun Quiz3App() {
    Scaffold(bottomBar = { Quiz3BottomAppBar()}, modifier = Modifier.padding(bottom = 50.dp)) { it ->
        Column(

            horizontalAlignment = Alignment.CenterHorizontally) {
            Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp, bottom = 10.dp, top = 50.dp)) {
                Row() {
                    Text(
                        text = stringResource(R.string.title),
                        style = MaterialTheme.typography.displayMedium
                    )
                    Spacer(Modifier.weight(1f))
                    Icon(painter = painterResource(R.drawable.logo_page_info), contentDescription = null, Modifier.size(25.dp))
                }
                Spacer(Modifier.padding(5.dp))
                Text(
                    text = stringResource(R.string.title_description),
                    style = MaterialTheme.typography.bodyLarge,
                    color = colorScheme.onSurface
                    )
            }
            LazyColumn(contentPadding = it) {
                items(persons) {
                    PersonItem(
                        person = it,
                        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
                    )
                }
            }
        }
    }
}

@Composable
fun PersonItem(
    person: Person,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
        ) {
            PersonIcon(person.icon)
            Spacer(Modifier.padding(dimensionResource(R.dimen.padding_small)))
            PersonInformation(person.name , person.age, person.city)
            Spacer(Modifier.weight(1f))
            PersonItemButton(expanded = expanded, onClick = { expanded = !expanded })
        }
    }
}

@Composable
private fun PersonItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowLeft else Icons.Filled.KeyboardArrowRight,
            contentDescription = stringResource(R.string.expand_button_content_description),

        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Quiz3BottomAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(horizontalArrangement = Arrangement.Center) {
                Spacer(Modifier.weight(0.5f))
                NavigationBar(
                    navIcon = painterResource(R.drawable.logo_home),
                    navDescription = stringResource(R.string.navigation_home),
                    modifier = Modifier
                )
                Spacer(Modifier.weight(1f))
                NavigationBar(
                    navIcon = painterResource(R.drawable.logo_search), tint = colorScheme.surfaceTint,
                    navDescription = stringResource(R.string.navigation_pencarian), textColor = colorScheme.surfaceTint,
                    modifier = Modifier,
                )
                Spacer(Modifier.weight(1f))
                NavigationBar(
                    navIcon = painterResource(R.drawable.logo_person),
                    navDescription = stringResource(R.string.navigation_profil),
                    modifier = Modifier
                )
                Spacer(Modifier.weight(0.5f))
            }
        }
    )
}

@Composable
fun PersonIcon(
    @StringRes personIcon: Int,
    modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.Center,
        modifier = modifier
            .background(
                shape = RoundedCornerShape(100),
                color = MaterialTheme.colorScheme.secondary
            )
            .padding(dimensionResource(R.dimen.padding_small))
            .size(30.dp)
    ) {
        Text(
            text = stringResource(personIcon),
            modifier = modifier,
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}
//Warna buat background icon buat sementara aja



@Composable
fun PersonInformation(
    @StringRes personName: Int,
    personAge: Int,
    @StringRes personCity: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(personName),
            style = MaterialTheme.typography.displaySmall,

        )
        Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(R.string.years_old, personAge),
                style = MaterialTheme.typography.bodyMedium,

            )
            Text(
                text = "•", Modifier.padding(start = 5.dp, end = 5.dp), fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.bodyMedium,

            )
            Text(
                text = stringResource(personCity),
                style = MaterialTheme.typography.bodyMedium,

            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Quiz1Preview() {
    Quiz3Theme {
        Quiz3App()
    }
}

@Preview(showBackground = true)
@Composable
fun Quiz1DarkThemePreview() {
    Quiz3Theme(darkTheme = true) {
        Quiz3App()
    }
}

