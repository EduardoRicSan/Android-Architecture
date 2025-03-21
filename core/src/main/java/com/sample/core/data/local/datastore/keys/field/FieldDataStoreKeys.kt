package com.sample.core.data.local.datastore.keys.field

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringSetPreferencesKey

object FieldDataStoreKeys {
    val FIELD_NAME_KEY = stringSetPreferencesKey("field_name")
    val FIELD_ID_KEY = intPreferencesKey("field_id")
    val IS_FIELD_ACTIVE_KEY = booleanPreferencesKey("is_active_")
    val FIELD_SCORE_KEY = doublePreferencesKey("field_score")
}