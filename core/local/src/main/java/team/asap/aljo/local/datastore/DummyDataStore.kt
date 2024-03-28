package team.asap.aljo.local.datastore

interface DummyDataStore {

    var token: String

    fun hasToken(): Boolean

    fun clear()

}