package net.yourein.libro.repositories

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.delay
import net.yourein.datasource.entities.Book
import net.yourein.datasource.entities.Tag
import net.yourein.datasource.entities.Series
import net.yourein.datasource.entities.Author
import net.yourein.librocore.repositories.BookRepository
import net.yourein.libro.R
import javax.inject.Inject

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
        return Book(
            id = 1,
            name = "DEV: Sample Book",
            registeredAt = 0,
            readingStatus = 0,
            isbn = isbn,
            publishDate = null,
            thumbnailName = null,
            thumbnailUrl = null,
        )
    }

    override suspend fun getBookByTag(tag: Tag): List<Book> {
        return (1..5).map {
            Book(
                id = it,
                name = "DEV: Sample Book Collected by Tag",
                registeredAt = 0,
                readingStatus = 0,
                isbn = null,
                publishDate = null,
                thumbnailName = null,
                thumbnailUrl = null,
            )
        }
    }

    override suspend fun getBookBySeries(series: Series): List<Book> {
        return (1..5).map {
            Book(
                id = it,
                name = "DEV: Sample Book Collected by Series",
                registeredAt = 0,
                readingStatus = 0,
                isbn = null,
                publishDate = null,
                thumbnailName = null,
                thumbnailUrl = null,
            )
        }
    }

    override suspend fun getBookByAuthor(author: Author): List<Book> {
        return (1..5).map {
            Book(
                id = it,
                name = "DEV: Sample Book Collected by Author",
                registeredAt = 0,
                readingStatus = 0,
                isbn = null,
                publishDate = null,
                thumbnailName = null,
                thumbnailUrl = null,
            )
        }
    }
    @Composable
    override fun getBookThumbnail(book: Book): Painter {
        return painterResource(id = R.drawable.small_sample_thumbnail_a6)
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