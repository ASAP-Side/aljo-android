package team.asap.aljo.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import team.asap.aljo.domain.login.model.LoginType
import team.asap.aljo.domain.login.usecase.LoginUseCase
import team.asap.aljo.domain.user.model.User
import javax.inject.Inject

data class LoginState(
    val user: User? = null,
    val at: String = "",
)

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state = _state.asStateFlow()

    fun login(loginType: LoginType){
        viewModelScope.launch{
            loginUseCase(loginType)
        }
    }
}