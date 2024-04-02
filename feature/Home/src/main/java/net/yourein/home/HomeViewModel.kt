package net.yourein.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import net.yourein.librocore.repositories.BookRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    bookRepository: BookRepository,
): ViewModel() {

}