package com.bankwithmit.cardinfofinder.ui.result

import androidx.lifecycle.*
import com.bankwithmit.cardinfofinder.domain.models.CardInfo
import com.bankwithmit.cardinfofinder.domain.usecases.GetCardInfoUsecase
import com.bankwithmit.cardinfofinder.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(val getCardInfoUsecase: GetCardInfoUsecase): ViewModel() {

    private val _cardInfo = MutableLiveData<CardInfo>()
    val cardInfo = _cardInfo as LiveData<CardInfo>

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading as LiveData<Boolean>

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful = _isSuccessful as LiveData<Boolean>

    fun getCardNumber(cardNumber: Int) = viewModelScope.launch{
        _isLoading.postValue(true)
        when(val result =
            withContext(Dispatchers.IO){getCardInfoUsecase(cardNumber)}) {
            is Result.Success -> {
                _isLoading.postValue(false)
                _cardInfo.postValue(result.data)
            }
            is Result.Error -> {
                _isLoading.postValue(false)
                _isSuccessful.postValue(false)
            }

        }
    }
}