package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {
    Movie first = new Movie(1, "https://someURL.ru/1", "Бладшот", "боевик", false);
    Movie second = new Movie(2, "https://someURL.ru/2", "Вперед", "мультфильм", false);
    Movie third = new Movie(3, "https://someURL.ru/3", "Отель Белград", "комедия", false);
    Movie fourth = new Movie(4, "https://someURL.ru/4", "Джентльмены", "боевик", false);
    Movie fifth = new Movie(5, "https://someURL.ru/5", "Человек-невидимка", "ужасы", false);
    Movie sixth = new Movie(6, "https://someURL.ru/6", "Троллию Мировой тур", "мультфильм", true);
    Movie seventh = new Movie(7, "https://someURL.ru/7", "Номер один", "комедия", true);
    Movie eighth = new Movie(8, "https://someURL.ru/8", "Бладшо 1т", "боевик", false);
    Movie ninth = new Movie(9, "https://someURL.ru/9", "Вперед 1", "мультфильм", false);
    Movie tenth = new Movie(10, "https://someURL.ru/10", "Джентльмены 1", "боевик", false);
    Movie eleventh = new Movie(11, "https://someURL.ru/11", "Человек-невидимка 1", "ужасы", false);

    MovieManager movieManager = new MovieManager();     //создание пустого объекта

    @Test
    void shouldAddedToEmptyList() {     //добавь новый элемент в пустой список
        movieManager.addNewMovie(first);        //тестируемое действие - сохрани первый элемент

        Movie[] expected = {first};     //expected - ожидаемый результат, покажи запомненный элемент
        Movie[] actual = movieManager.getMovies();        //дай фильм, который ты запомнил
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIfAlreadyContains() {     //добавь новый элемент к уже имеющимся
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);

        Movie[] expected = {first, second};
        Movie[] actual = movieManager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindAllMovies() {        //покажи все фильмы
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Movie[] actual = movieManager.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrder() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10)
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

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
        MovieManager movieManager = new MovieManager(5);

        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfQuantityIs0() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если в конструктор передается 0
        MovieManager movieManager = new MovieManager(0);

        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfQuantityIsLessThen0() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если в конструктор передается меньше 0
        MovieManager movieManager = new MovieManager(-1);

        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);
        movieManager.addNewMovie(sixth);
        movieManager.addNewMovie(seventh);
        movieManager.addNewMovie(eighth);
        movieManager.addNewMovie(ninth);
        movieManager.addNewMovie(tenth);
        movieManager.addNewMovie(eleventh);

        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastMoviesForDefaultCountInReverseOrderIfAdd5() {     //найди последние фильмы в обратном порядке в количестве по дефолту (т.е. 10), если добавлены 5
        movieManager.addNewMovie(first);
        movieManager.addNewMovie(second);
        movieManager.addNewMovie(third);
        movieManager.addNewMovie(fourth);
        movieManager.addNewMovie(fifth);

        Movie[] expected = {fifth, fourth, third, second, first};
        Movie[] actual = movieManager.findLast();
        assertArrayEquals(expected, actual);
    }
}
