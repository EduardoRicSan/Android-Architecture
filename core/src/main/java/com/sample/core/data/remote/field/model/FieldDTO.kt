package com.sample.core.data.remote.field.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FieldDTO(
    @SerialName("req") val required: Boolean,
    @SerialName("visible") val visible: Boolean,
    @SerialName("order") val order: Int,
    @SerialName("maxlength") val maxLength: Int?,
    @SerialName("type") val type: String,
    @SerialName("regex") val regex: String?,
    @SerialName("values") val values: Map<String, String>? = null
)