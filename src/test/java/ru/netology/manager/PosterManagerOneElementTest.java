package ru.netology.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerOneElementTest {
    PosterManager posterManager = new PosterManager();
    PosterItem elem = new PosterItem(1, 1, "The favourite");
    @BeforeEach
    public void addElementToPostManager() {
        posterManager.add(elem);
    }

    @Test
    public void shouldGetLast10() {
        PosterItem[] actual = posterManager.getLast10();
        PosterItem[] expected = new PosterItem[]{elem};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        posterManager.removeById(1);

        PosterItem[] actual = posterManager.getLast10();
        PosterItem[] expected = new PosterItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 2;

        posterManager.removeById(idToRemove);

        PosterItem[] actual = posterManager.getLast10();
        PosterItem[] expected = new PosterItem[]{elem};

        assertArrayEquals(expected, actual);
    }
}