package com.sample.core.data.local.field

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sample.core.domain.model.field.Field

@Entity(tableName = "fields")
data class FieldEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val required: Boolean,
    val visible: Boolean,
    val order: Int,
    val maxLength: Int?,
    val type: String,
    val regex: String?,
) {
    fun toDomain() = Field(required, visible, order, maxLength, type, regex)
}

fun Field.toEntity() = FieldEntity(
    required = required,
    visible = visible,
    order = order,
    maxLength = maxLength,
    type = type,
    regex = regex
)