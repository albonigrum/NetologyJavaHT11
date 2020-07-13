package ru.netology.manager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class PosterManagerEmptyTest {
    @Mock
    private PosterRepository posterRepository;

    @InjectMocks
    private PosterManager posterManager;


    @AfterEach
    public void checkThatEmpty() {
        PosterItem[] actual = posterManager.getLast10();
        PosterItem[] expected = new PosterItem[]{};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetLast10() {
        PosterItem[] returned = new PosterItem[] {};
        doReturn(returned).when(posterRepository).findAll();
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 1;

        PosterItem[] returned = new PosterItem[] {};
        doReturn(returned).when(posterRepository).findAll();
        doNothing().when(posterRepository).removeById(idToRemove);

        posterManager.removeById(idToRemove);
    }
}