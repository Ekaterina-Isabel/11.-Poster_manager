package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.manager.MovieManager;

import static org.junit.jupiter.api.Assertions.*;

class MovieRepositoryTest {
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

    MovieRepository movieRepository = new MovieRepository();     //создание пустого объекта

    @Test
    void shouldFindAllMovies() {        //покажи все фильмы
        movieRepository.save(first);
        movieRepository.save(second);
        movieRepository.save(third);
        movieRepository.save(fourth);
        movieRepository.save(fifth);
        movieRepository.save(sixth);
        movieRepository.save(seventh);
        movieRepository.save(eighth);
        movieRepository.save(ninth);
        movieRepository.save(tenth);
        movieRepository.save(eleventh);

        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh, eighth, ninth, tenth, eleventh};
        Movie[] actual = movieRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddedToEmptyList() {     //добавь новый элемент в пустой список
        movieRepository.save(first);        //тестируемое действие - сохрани первый элемент

        Movie[] expected = {first};     //expected - ожидаемый результат, покажи запомненный элемент
        Movie[] actual = movieRepository.findAll();        //дай фильм, который ты запомнил
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddIfAlreadyContains() {     //добавь новый элемент к уже имеющимся
        movieRepository.save(first);
        movieRepository.save(second);

        Movie[] expected = {first, second};
        Movie[] actual = movieRepository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldGetEmptyList() {     //дай мне пустой список
        Movie[] expected = {};
        Movie[] actual = movieRepository.findAll();

        assertArrayEquals(expected, actual);
    }
}