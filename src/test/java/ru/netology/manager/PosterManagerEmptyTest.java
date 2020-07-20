package ru.netology.manager;

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

    @Test
    public void shouldGetLasts() {
        PosterItem[] returned = new PosterItem[] {};
        doReturn(returned).when(posterRepository).findAll();

        PosterItem[] actual = posterManager.getLasts();
        PosterItem[] expected = new PosterItem[]{};
        assertArrayEquals(expected, actual);
    }
}