package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class PosterManagerOneElementTest {
    @Mock
    private PosterRepository posterRepository;
    @InjectMocks
    private PosterManager posterManager = new PosterManager();
    private final PosterItem elem = new PosterItem(1, "The favourite");

    @BeforeEach
    public void addElementToPostManager() {
        posterManager.add(elem);
    }

    @Test
    public void shouldGetLasts() {
        PosterItem[] returned = new PosterItem[]{elem};
        doReturn(returned).when(posterRepository).findAll();

        PosterItem[] actual = posterManager.getLasts();
        PosterItem[] expected = new PosterItem[]{elem};

        assertArrayEquals(expected, actual);
    }
}