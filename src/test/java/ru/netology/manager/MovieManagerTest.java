package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MovieManagerTest {
    //@Mock
    private MovieRepository repository = Mockito.mock(MovieRepository.class);       //команда Mockito создать фейковый репозиторий
    //@InjectMocks
    private MovieManager manager = new MovieManager(repository);
    private MovieManager manager5 = new MovieManager(repository, 5);     //создание пустого объекта

    private Movie firstMock = new Movie(1,"https://someURL.ru/1", "Бладшот", "боевик", false);
    private Movie secondMock = new Movie(2, "https://someURL.ru/2", "Вперед", "мультфильм", false);
    private Movie thirdMock = new Movie(3, "https://someURL.ru/3", "Отель Белград", "комедия", false);
    private Movie fourthMock = new Movie(4, "https://someURL.ru/4", "Джентльмены", "боевик", false);
    private Movie fifthMock = new Movie(5, "https://someURL.ru/5", "Человек-невидимка", "ужасы", false);
    private Movie sixthMock = new Movie(6, "https://someURL.ru/6", "Троллию Мировой тур", "мультфильм", true);
    private Movie seventhMock = new Movie(7, "https://someURL.ru/7", "Номер один", "комедия", true);
    private Movie eighthMock = new Movie(8, "https://someURL.ru/8", "Бладшот 1", "боевик", false);
    private Movie ninthMock = new Movie(9, "https://someURL.ru/9", "Вперед 1", "мультфильм", false);
    private Movie tenthMock = new Movie(10, "https://someURL.ru/10", "Джентльмены 1", "боевик", false);
    private Movie eleventhMock = new Movie(11, "https://someURL.ru/11", "Человек-невидимка 1", "ужасы", false);


    Movie first = new Movie(1, "https://someURL.ru/1", "Бладшот", "боевик", false);
    Movie second = new Movie(2, "https://someURL.ru/2", "Вперед", "мультфильм", false);
    Movie third = new Movie(3, "https://someURL.ru/3", "Отель Белград", "комедия", false);
    Movie fourth = new Movie(4, "https://someURL.ru/4", "Джентльмены", "боевик", false);
    Movie fifth = new Movie(5, "https://someURL.ru/5", "Человек-невидимка", "ужасы", false);
    Movie sixth = new Movie(6, "https://someURL.ru/6", "Троллию Мировой тур", "мультфильм", true);
    Movie seventh = new Movie(7, "https://someURL.ru/7", "Номер один", "комедия", true);
    Movie eighth = new Movie(8, "https://someURL.ru/8", "Бладшот 1", "боевик", false);
    Movie ninth = new Movie(9, "https://someURL.ru/9", "Вперед 1", "мультфильм", false);
    Movie tenth = new Movie(10, "https://someURL.ru/10", "Джентльмены 1", "боевик", false);
    Movie eleventh = new Movie(11, "https://someURL.ru/11", "Человек-невидимка 1", "ужасы", false);

    MovieManager movieManager = new MovieManager(new MovieRepository());     //создание пустого объекта


    //тесты с Mockito
    @Test
    public void shouldFindAllMoviesMockito() {        //покажи все фильмы, тест с Mockito
        //настройка заглушки
        Movie[] returned = { firstMock, secondMock, thirdMock };        //подготовка: репозиторий уже помнит три фильма
        doReturn(returned).when(repository).findAll();       //возвращай этот массив, когда тебя спросят findAll

        Movie[] expected = {firstMock, secondMock, thirdMock };
        Movie[] actual = manager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLast5MoviesInReverseOrderMockito() {     //найди последние 5 фильмов в обратном порядке, тест с Mockito
        //настройка заглушки
        Movie[] returned = { sixthMock, seventhMock, eighthMock, ninthMock, tenthMock, eleventhMock };        //подготовка: репозиторий уже помнит 5 фильмов
        doReturn(returned).when(repository).findAll();       //возвращай этот массив, когда тебя спросят findLast


        Movie[] expected = { eleventhMock, tenthMock, ninthMock, eighthMock, seventhMock };
        Movie[] actual = manager5.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddedToEmptyList() {     //добавь новый элемент в пустой список
        movieManager.save(first);        //тестируемое действие - сохрани первый элемент

        Movie[] expected = {first};     //expected - ожидаемый результат, покажи запомненный элемент
        Movie[] actual = movieManager.getMovies();        //дай фильм, который ты запомнил
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIfAlreadyContains() {     //добавь новый элемент к уже имеющимся
        movieManager.save(first);
        movieManager.save(second);

        Movie[] expected = {first, second};
        Movie[] actual = movieManager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllMovies() {        //покажи все фильмы
        movieManager.save(first);
        movieManager.save(second);
        movieManager.save(third);
        movieManager.save(fourth);
        movieManager.save(fifth);
        movieManager.save(sixth);
        movieManager.save(seventh);
        movieManager.save(eighth);
        movieManager.save(ninth);
        movieManager.save(tenth);
        movieManager.save(eleventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Movie[] actual = movieManager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrder() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10)
        movieManager.save(first);
        movieManager.save(second);
        movieManager.save(third);
        movieManager.save(fourth);
        movieManager.save(fifth);
        movieManager.save(sixth);
        movieManager.save(seventh);
        movieManager.save(eighth);
        movieManager.save(ninth);
        movieManager.save(tenth);
        movieManager.save(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEmptyList() {     //дай мне пустой список
        Movie[] expected = {};
        Movie[] actual = movieManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLast5MoviesInReverseOrder() {     //найди последние 5 фильмов в обратном порядке
        MovieManager movieManager = new MovieManager(new MovieRepository(),5);

        movieManager.save(first);
        movieManager.save(second);
        movieManager.save(third);
        movieManager.save(fourth);
        movieManager.save(fifth);
        movieManager.save(sixth);
        movieManager.save(seventh);
        movieManager.save(eighth);
        movieManager.save(ninth);
        movieManager.save(tenth);
        movieManager.save(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfQuantityIs0() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если в конструктор передается 0
        MovieManager movieManager = new MovieManager(new MovieRepository(),0);

        movieManager.save(first);
        movieManager.save(second);
        movieManager.save(third);
        movieManager.save(fourth);
        movieManager.save(fifth);
        movieManager.save(sixth);
        movieManager.save(seventh);
        movieManager.save(eighth);
        movieManager.save(ninth);
        movieManager.save(tenth);
        movieManager.save(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfQuantityIsLessThen0() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если в конструктор передается меньше 0
        MovieManager movieManager = new MovieManager(new MovieRepository(), -1);

        movieManager.save(first);
        movieManager.save(second);
        movieManager.save(third);
        movieManager.save(fourth);
        movieManager.save(fifth);
        movieManager.save(sixth);
        movieManager.save(seventh);
        movieManager.save(eighth);
        movieManager.save(ninth);
        movieManager.save(tenth);
        movieManager.save(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfAdd5() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если добавлены 5
        movieManager.save(first);
        movieManager.save(second);
        movieManager.save(third);
        movieManager.save(fourth);
        movieManager.save(fifth);

        Movie[] expected = {fifth, fourth, third, second, first};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }
}
