package team.asap.aljo.navigation

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

class NavigationManagerImpl @Inject constructor() : NavigationManager {
    private val _commands = MutableSharedFlow<NavigationCommand>(
        replay = 0,
        extraBufferCapacity = 2,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    override val commands: SharedFlow<NavigationCommand> = _commands.asSharedFlow()

    override fun navigate(command: NavigationCommand) {
        _commands.tryEmit(command)
    }

    override fun popBack(route: String) {
        _commands.tryEmit(object : NavigationCommand {
            override val destination: String = route
            override val type = NavigationType.POP_BACK
        })
    }
}