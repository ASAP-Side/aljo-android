package team.asap.aljo.local.datastore

import android.content.SharedPreferences
import androidx.core.content.edit
import javax.inject.Inject

class DummyDataStoreImpl @Inject constructor(
    private val preferences: SharedPreferences,
) : DummyDataStore {

    override var token: String
        get() = preferences.getString(TOKEN, "").orEmpty()
        set(value) {
            preferences.edit(commit = true) {
                putString(TOKEN, value)
            }
        }

    override fun hasToken(): Boolean =
        preferences.contains(TOKEN)

    override fun clear() {
        preferences.edit(commit = true) {
            clear()
        }
    }

    private companion object {
        const val TOKEN = "TOKEN"
    }

}
