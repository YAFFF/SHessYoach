package com.example.shessyoach.data_control

data class Player(
    val isLogged: Boolean = false,
    val playerId: Int? = null,
    val login: String? = null,
    val password: String? = null,
) {
    companion object {
        var current: Player = Player()

        fun login(login: String, password: String): Boolean {
            current = Player(isLogged = true, playerId = 1, login = login, password = password)
            return true
        }

        fun logout() {
            current = Player()
        }
    }
}
