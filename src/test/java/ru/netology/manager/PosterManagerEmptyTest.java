package ru.netology.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterManagerEmptyTest {
    PosterManager posterManager = new PosterManager();

    @AfterEach
    public void checkThatEmpty() {
        PosterItem[] actual = posterManager.getLast10();
        PosterItem[] expected = new PosterItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast10() {}

    @Test
    public void shouldNotRemoveIfNotExists() {
        posterManager.removeById(1);
    }
}