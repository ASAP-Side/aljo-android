package team.asap.aljo.navigation.directions

import team.asap.aljo.navigation.NavigationCommand

private const val LOGIN_ROUTE = "login"

object LoginNavigationCommand : NavigationCommand {
    override val destination: String = LOGIN_ROUTE

}