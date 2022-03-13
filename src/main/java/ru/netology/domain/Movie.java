package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Movie {        //элемент фильм
    private int id;
    private String movieImageUrl;
    private String movieName;
    private String movieGenre;
    private boolean premiereTomorrow;
}