package net.yourein.libro.repositories

import androidx.compose.ui.graphics.painter.Painter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.delay
import net.yourein.datasource.entities.Book
import net.yourein.datasource.entities.Tag
import net.yourein.datasource.entities.Series
import net.yourein.datasource.entities.Author
import net.yourein.libro.LibroApplication
import net.yourein.libro.MainActivity
import net.yourein.librocore.repositories.BookRepository
import javax.inject.Inject
import javax.inject.Singleton

class DevBookRepository @Inject constructor(): BookRepository {
    override suspend fun getAllBooks(): List<Book> {
        delay(5000)
        return (1..10).map {
            Book(
                id = it,
                name = "Book Title ${it}",
                registeredAt = 0,
                readingStatus = 0,
                isbn = null,
                publishDate = null,
                thumbnailUrl = null,
                thumbnailName = null
            )
        }
    }

    override suspend fun getBookByIsbn(isbn: String): Book {
        TODO("Not yet implemented")
    }

    override suspend fun getBookByTag(tag: Tag): List<Book> {
        TODO("Not yet implemented")
    }

    override suspend fun getBookBySeries(series: Series): List<Book> {
        TODO("Not yet implemented")
    }

    override suspend fun getBookByAuthor(author: Author): List<Book> {
        TODO("Not yet implemented")
    }

    override suspend fun getBookthumbnail(book: Book): Painter {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentlyReadingBooks(): List<Book> {
        delay(100)
        return (1..3).map {
            Book(
                id = it,
                name = "Currently Reading Book Title ${it}",
                registeredAt = 0,
                readingStatus = 0,
                isbn = null,
                publishDate = null,
                thumbnailUrl = null,
                thumbnailName = null
            )
        }
    }
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class DevBookRepositoryModule {

    @Binds
    abstract fun bindBookRepository(devBookRepository: DevBookRepository): BookRepository
}