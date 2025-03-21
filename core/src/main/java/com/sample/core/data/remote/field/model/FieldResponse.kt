package com.sample.core.data.remote.field.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FieldResponse(
    @SerialName("ok") val ok: Int,
    @SerialName("data") val data: Map<String, FieldDTO>
)