package com.sample.feature.presentation.field.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.core.data.remote.field.model.FieldResponse
import com.sample.core.data.remote.utils.NetworkResult
import com.sample.core.domain.usecase.field.GetFieldUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FieldViewModel @Inject constructor(
    private val getFieldUseCase: GetFieldUseCase
) : ViewModel() {

    private val _fieldState = MutableStateFlow<NetworkResult<FieldResponse>>(NetworkResult.Loading)
    val fieldState: StateFlow<NetworkResult<FieldResponse>> = _fieldState

    fun getField() {
        viewModelScope.launch {
            getFieldUseCase().collect { result ->
                _fieldState.value = result
            }
        }
    }
}