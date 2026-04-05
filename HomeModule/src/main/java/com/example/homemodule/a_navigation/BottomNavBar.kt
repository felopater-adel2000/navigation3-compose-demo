package com.example.homemodule.a_navigation

import android.net.http.SslCertificate.restoreState
import android.net.http.SslCertificate.saveState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.basemodule.navigation.LocalNav3Controller

data class NavigationItem(
    val title: String,
    val icon: ImageVector,
    val screen: HomeNavModule
)

@Composable
fun BottomNavBar() {
    val navController = LocalNav3Controller.current
    var selectedNavigationIndex by rememberSaveable { mutableIntStateOf(0) }

    val navigationItems = remember {
        listOf(
            NavigationItem("Visits", Icons.Default.Home, HomeNavModule.VisitsScreen()),
            NavigationItem("Maps", Icons.Rounded.CheckCircle, HomeNavModule.MapsScreen()),
            NavigationItem("Clients", Icons.Default.Face, HomeNavModule.ClientsScreen()),
            NavigationItem("Profile", Icons.Default.Person, HomeNavModule.ProfileScreen())
        )
    }

    NavigationBar(
        containerColor = Color.White,
        contentColor = Color.Red
    ) {
        navigationItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = navigationItems.indexOf(item) == selectedNavigationIndex,
                onClick = {
                    selectedNavigationIndex = index
                    navController.navigate(item.screen) {
                            popUpTo(item.screen.javaClass, inclusive = true)
                    }
                },
                icon = { androidx.compose.material3.Icon(item.icon, contentDescription = item.title) },
                label = { androidx.compose.material3.Text(item.title) }
            )
        }
    }

}