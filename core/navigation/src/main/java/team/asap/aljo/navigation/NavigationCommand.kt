package team.asap.aljo.navigation

interface NavigationCommand {
    val type: NavigationType
        get() = NavigationType.NAVIGATE
    val destination: String
}

enum class NavigationType {
    NAVIGATE,
    POP_BACK;
}