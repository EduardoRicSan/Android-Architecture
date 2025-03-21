package com.sample.core.domain.model.field


data class Field(
    var required: Boolean = false,
    var visible: Boolean = false,
    var order: Int = 0,
    var maxLength: Int? = 0,
    var type: String = "",
    var regex: String? = "",
    var values: Map<String, String>? = null
)