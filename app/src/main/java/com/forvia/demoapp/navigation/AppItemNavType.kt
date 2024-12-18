package com.forvia.demoapp.navigation

import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.navigation.NavType
import com.forvia.domain.model.AppItem
import kotlinx.serialization.json.Json

//To pass arguments on safe way
class AppItemNavType : NavType<AppItem>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): AppItem? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            bundle.getParcelable(key, AppItem::class.java)
        } else {
            @Suppress("DEPRECATION")
            bundle.getParcelable(key)
        }
    }

    override fun parseValue(value: String): AppItem {
        return Json.decodeFromString<AppItem>(value)
    }

    override fun put(bundle: Bundle, key: String, value: AppItem) {
        bundle.putParcelable(key, value)
    }

    override fun serializeAsValue(value: AppItem): String {
        return Uri.encode(Json.encodeToString(value))
    }
}