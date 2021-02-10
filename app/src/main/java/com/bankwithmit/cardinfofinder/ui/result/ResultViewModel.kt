package com.bankwithmit.cardinfofinder.ui.result

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.bankwithmit.domain.models.CardInfo
import com.bankwithmit.domain.usecases.GetCardInfoUsecase
import com.bankwithmit.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


class ResultViewModel @ViewModelInject constructor(val getCardInfoUsecase: GetCardInfoUsecase): ViewModel() {

    private val _cardInfo = MutableLiveData<CardInfo>()
    val cardInfo = _cardInfo as LiveData<CardInfo>

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading as LiveData<Boolean>

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful = _isSuccessful as LiveData<Boolean>

    fun getCardNumber(cardNumber: Int) = viewModelScope.launch{
        _isLoading.postValue(true)
        when(val result = getCardInfoUsecase(cardNumber)) {
            is com.bankwithmit.domain.utils.Result.Success -> {
                _isLoading.postValue(false)
                _cardInfo.postValue(result.data)
            }
            is com.bankwithmit.domain.utils.Result.Error -> {
                _isLoading.postValue(false)
                _isSuccessful.postValue(false)
            }

        }
    }
}