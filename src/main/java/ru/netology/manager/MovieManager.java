package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.MovieRepository;

public class MovieManager {
    private MovieRepository repository;     //repository - там менеджер хранит информацию

    private int resultLength;       //желаемый размер создаваемого массива

    public int getResultLength() {
        return resultLength;
    }

    public Movie[] getMovies() {
        Movie[] movies = repository.findAll();
        return movies;
    }

    public MovieManager(MovieRepository repository) {       //конструктор
        this.repository = repository;
        resultLength = 10;
    }

    public MovieManager(MovieRepository repository, int resultLength) {     //конструктор
        this.repository = repository;
        if (resultLength <= 0) {
            this.resultLength = 10;
        } else {
            this.resultLength = resultLength;
        }
    }

    public Movie[] findAll() {      //вывод всех фильмов в порядке добавления
        return repository.findAll();
    }

    public void save(Movie movie) {        //команда менеджеру добавить фильм в ленту - репозиторий запомни новый фильм
        repository.save(movie);
    }

    public Movie findById(int id) {         //возвращает фильм по id (либо null, если такого объекта нет)
        return repository.findById(id);
    }

    public void removeById(int id) {        //принимает id и удаляет объект по id (если объекта нет, то пусть будет исключение, как на лекции)
        repository.removeById(id);
    }

    public void removeAll() {       //полностью вычищает репозиторий (для удаления всех элементов достаточно в поле items положить пустой массив)
        repository.removeAll();
    }

    private Movie[] revertMovies() {      //вывод всех фильмов в обратном от добавления порядке
        Movie[] movies = findAll();
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {       //перебираем массив в прямом порядке, но кладем в результаты в обратном
            int movieIndex = movies.length - i - 1;
            result[i] = movies[movieIndex];
        }
        return result;
    }

    public Movie[] findLast() {     //вывод последние ... фильмов в обратном от добавления порядке
        Movie[] movies = findAll();
        int calculatedResultLength;
        if (movies.length < resultLength) {
            calculatedResultLength = movies.length;
        } else {
            calculatedResultLength = resultLength;
        }

        Movie[] result = new Movie[calculatedResultLength];
        Movie[] allMovie = revertMovies();
        System.arraycopy(allMovie, 0, result, 0, calculatedResultLength);
        return result;
    }
}
