package ru.netology.repository;

import ru.netology.domain.Movie;

public class MovieRepository {
    private Movie[] movies = new Movie[0];      //movies - поле, в котором создан пустой массив

    public Movie[] findAll() {      //вывод всех фильмов в порядке добавления
        Movie[] result = new Movie[movies.length];
        System.arraycopy(movies, 0, result, 0, result.length);
        return result;
    }

    public void save(Movie movie) {      //добавление нового фильма, принимает и сохраняет один элемент movie
        int length = movies.length + 1;     //вычисление длинны нового массива = длинна старого массива + 1
        Movie[] tmp = new Movie[length];        //создание нового массива из фильмов
        System.arraycopy(movies, 0, tmp, 0, movies.length);     //метод для автоматического копирования элементов из старого массива в новый
        int lastIndex = tmp.length - 1;     //вычисляем номер последней ячейки
        tmp[lastIndex] = movie;     //добавляем в нее новый фильм
        movies = tmp;       //сохраняем новый массив в поле movies
    }

    public Movie findById(int id) {       //возвращает фильм по id (либо null, если такого объекта нет)
        Movie result = null;
        for (Movie movie : movies) {
            if (movie.getId() == id) {
                result = movie;
                break;
            }
        }
        return result;
    }

    //void - ничего не возвращаем
    public void removeById(int id) {     //принимает id и удаляет объект по id (если объекта нет, то пусть будет исключение, как на лекции)
        int length = movies.length - 1;     //вычисление длинны нового массива
        Movie[] tmp = new Movie[length];        //создаем новый массив tmp
        int index = 0;      //index - переменная, номер ячейки куда будем копировать
        for (Movie movie : movies) {        //перебор элементов
            if (movie.getId() != id) {      //сравнение, совпадает ли id с удаляемым: если не равно, то скопируй, если равно - то не копируй
                tmp[index] = movie;
                index++;
            }
        }
        movies = tmp;       //меняем наши элементы
    }

    //void - ничего не возвращаем
    public void removeAll() {      //полностью вычищает репозиторий (для удаления всех элементов достаточно в поле items положить пустой массив)
        movies = new Movie[0];
    }
}
