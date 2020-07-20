package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerOneElementTest {
    private PosterManager posterManager = new PosterManager();
    private final PosterItem elem = new PosterItem(1, "The favourite");

    @BeforeEach
    public void addElementToPostManager() {
        posterManager.add(elem);
    }

    @Test
    public void shouldGetLasts() {
        PosterItem[] actual = posterManager.getLasts();
        PosterItem[] expected = new PosterItem[]{elem};

        assertArrayEquals(expected, actual);
    }
}