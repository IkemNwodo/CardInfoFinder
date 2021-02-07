package com.bankwithmit.cardinfofinder.ui.result

import androidx.lifecycle.*
import com.bankwithmit.domain.models.CardInfo
import com.bankwithmit.domain.usecases.GetCardInfoUsecase
import com.bankwithmit.domain.utils.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ResultViewModel @Inject constructor(val getCardInfoUsecase: com.bankwithmit.domain.usecases.GetCardInfoUsecase): ViewModel() {

    private val _cardInfo = MutableLiveData<com.bankwithmit.domain.models.CardInfo>()
    val cardInfo = _cardInfo as LiveData<com.bankwithmit.domain.models.CardInfo>

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading = _isLoading as LiveData<Boolean>

    private val _isSuccessful = MutableLiveData<Boolean>()
    val isSuccessful = _isSuccessful as LiveData<Boolean>

    fun getCardNumber(cardNumber: Int) = viewModelScope.launch{
        _isLoading.postValue(true)
        when(val result =
            withContext(Dispatchers.IO){getCardInfoUsecase(cardNumber)}) {
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