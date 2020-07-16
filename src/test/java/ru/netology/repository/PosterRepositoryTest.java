package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.*;

class PosterRepositoryTest {
    PosterRepository repository = new PosterRepository();
    private final PosterItem elem1 = new PosterItem(1, "elem1");
    private final PosterItem elem2 = new PosterItem(2, "elem2");
    private final PosterItem elem3 = new PosterItem(3, "elem3");


    @BeforeEach
    void add3Elements() {
        repository.save(elem1);
        repository.save(elem2);
        repository.save(elem3);
    }

    @Test
    void shouldFindAll() {
        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = {elem1, elem2, elem3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfInRepository() {
        int idToFind = 2;

        PosterItem actual = repository.findById(idToFind);
        PosterItem expected = elem2;

        assertEquals(expected, actual);
    }

    @Test
    void shouldFindByIdIfNoInRepository() {
        int idToFind = 4;

        PosterItem actual = repository.findById(idToFind);
        PosterItem expected = null;

        assertEquals(expected, actual);
    }


    @Test
    void shouldRemoveByIdIfInRepository() {
        int idToRemove = 2;

        repository.removeById(idToRemove);

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = {elem1, elem3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByIdIfNoInRepository() {
        int idToRemove = 4;

        repository.removeById(idToRemove);

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = {elem1, elem2, elem3};

        assertArrayEquals(expected, actual);
    }



    @Test
    void shouldRemoveAll() {
        repository.removeAll();

        PosterItem[] actual = repository.findAll();
        PosterItem[] expected = {};

        assertArrayEquals(expected, actual);
    }
}