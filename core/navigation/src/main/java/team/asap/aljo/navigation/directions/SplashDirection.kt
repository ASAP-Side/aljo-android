package team.asap.aljo.navigation.directions

import team.asap.aljo.navigation.NavigationCommand

private const val SPLASH_ROUTE = "splash"

object SplashNavigationCommand : NavigationCommand {
    override val destination: String = SPLASH_ROUTE

}