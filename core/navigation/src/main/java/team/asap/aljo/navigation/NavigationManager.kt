package team.asap.aljo.navigation

import kotlinx.coroutines.flow.SharedFlow

interface NavigationManager {
    val commands: SharedFlow<NavigationCommand>
    fun navigate(command: NavigationCommand)
    fun popBack(route: String = "")
}