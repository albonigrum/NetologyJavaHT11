package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerEmptyTest {
    private PosterManager posterManager = new PosterManager();

    @Test
    public void shouldGetLasts() {
        PosterItem[] actual = posterManager.getLasts();
        PosterItem[] expected = new PosterItem[]{};

        assertArrayEquals(expected, actual);
    }

}