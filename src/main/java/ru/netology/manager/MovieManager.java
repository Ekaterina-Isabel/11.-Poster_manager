package ru.netology.manager;

import ru.netology.domain.Movie;

public class MovieManager {
    private Movie[] movies = new Movie[0];      //movies - поле, в котором создан пустой массив

    private int resultLength;       //желаемый размер создаваемого массива

    public int getResultLength() {
        return resultLength;
    }

    public Movie[] getMovies() {
        return movies;
    }

    public MovieManager() {
        resultLength = 10;
    }

    public MovieManager(int resultLength) {
        if (resultLength <= 0) {
            this.resultLength = 10;
        } else {
            this.resultLength = resultLength;
        }
    }

    public void addNewMovie(Movie movie) {      //добавление нового фильма, принимает и сохраняет один элемент movie
        int length = movies.length + 1;     //вычисление длинны нового массива = длинна старого массива + 1
        Movie[] tmp = new Movie[length];        //создание нового массива из фильмов
        System.arraycopy(movies, 0, tmp, 0, movies.length);     //метод для автоматического копирования элементов из старого массива в новый
        int lastIndex = tmp.length - 1;     //вычисляем номер последней ячейки
        tmp[lastIndex] = movie;     //добавляем в нее новый фильм
        movies = tmp;       //сохраняем новый массив в поле movies
    }

    public Movie[] findAll() {      //вывод всех фильмов в порядке добавления
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {       // перебираем массив в прямом порядке, но кладем в результаты в обратном
            result[i] = movies[i];
        }
        return result;
    }

    private Movie[] revertMovies() {      //вывод всех фильмов в обратном от добавления порядке
        Movie[] result = new Movie[movies.length];
        for (int i = 0; i < result.length; i++) {       //перебираем массив в прямом порядке, но кладем в результаты в обратном
            int movieIndex = movies.length - i - 1;
            result[i] = movies[movieIndex];
        }
        return result;
    }

    public Movie[] findLast() {     //вывод последние ... фильмов в обратном от добавления порядке
        int calculatedResultLength;
        if (movies.length < resultLength) {
            calculatedResultLength = movies.length;
        } else {
            calculatedResultLength = resultLength;
        }

        Movie[] result = new Movie[calculatedResultLength];
        Movie[] allMovie = revertMovies();
        for (int i = 0; i < calculatedResultLength; i++) {
            result[i] = allMovie[i];
        }
        return result;
    }
}
