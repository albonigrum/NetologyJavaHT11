package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PosterManagerMoreThenOneElementTest {
  @Mock
  private PosterRepository posterRepository;
  @InjectMocks
  private PosterManager posterManager;
  private final PosterItem elem1 = new PosterItem(1, 1, "elem1");
  private final PosterItem elem2 = new PosterItem(2, 2, "elem2");
  private final PosterItem elem3 = new PosterItem(3, 3, "elem3");
  private final PosterItem elem4 = new PosterItem(4, 4, "elem4");
  private final PosterItem elem5 = new PosterItem(5, 5, "elem5");
  private final PosterItem elem6 = new PosterItem(6, 6, "elem6");
  private final PosterItem elem7 = new PosterItem(7, 7, "elem7");
  private final PosterItem elem8 = new PosterItem(8, 8, "elem8");
  private final PosterItem elem9 = new PosterItem(9, 9, "elem9");
  private final PosterItem elem10 = new PosterItem(10, 10, "elem10");
  private final PosterItem elem11 = new PosterItem(11, 11, "elem11");



  @BeforeEach
  public void setUp() {
    doNothing().when(posterRepository).save(elem1);
    doNothing().when(posterRepository).save(elem2);
    doNothing().when(posterRepository).save(elem3);
    doNothing().when(posterRepository).save(elem4);
    doNothing().when(posterRepository).save(elem5);
    doNothing().when(posterRepository).save(elem6);
    doNothing().when(posterRepository).save(elem7);
    doNothing().when(posterRepository).save(elem8);
    doNothing().when(posterRepository).save(elem9);
    doNothing().when(posterRepository).save(elem10);
    doNothing().when(posterRepository).save(elem11);

    posterManager.add(elem1);
    posterManager.add(elem2);
    posterManager.add(elem3);
    posterManager.add(elem4);
    posterManager.add(elem5);
    posterManager.add(elem6);
    posterManager.add(elem7);
    posterManager.add(elem8);
    posterManager.add(elem9);
    posterManager.add(elem10);
    posterManager.add(elem11);
  }

  @Test
  public void shouldAdd() {
    PosterItem[] returned = new PosterItem[]{elem1, elem2, elem3, elem4, elem5, elem6, elem7, elem8, elem9, elem10, elem11};
    doReturn(returned).when(posterRepository).findAll();

    PosterItem[] actual = posterManager.getLast10();
    PosterItem[] expected = new PosterItem[]{elem11, elem10, elem9, elem8, elem7, elem6, elem5, elem4, elem3, elem2};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldRemoveIfExists() {
    int idToRemove = 2;

    PosterItem[] returned = new PosterItem[]{elem1, elem3, elem4, elem5, elem6, elem7, elem8, elem9, elem10, elem11};
    doReturn(returned).when(posterRepository).findAll();
    doNothing().when(posterRepository).removeById(idToRemove);

    posterManager.removeById(idToRemove);

    PosterItem[] actual = posterManager.getLast10();
    PosterItem[] expected = new PosterItem[]{elem11, elem10, elem9, elem8, elem7, elem6, elem5, elem4, elem3, elem1};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 12;

    PosterItem[] returned = new PosterItem[]{elem1, elem2, elem3, elem4, elem5, elem6, elem7, elem8, elem9, elem10, elem11};
    doReturn(returned).when(posterRepository).findAll();
    doNothing().when(posterRepository).removeById(idToRemove);

    posterManager.removeById(idToRemove);

    PosterItem[] actual = posterManager.getLast10();
    PosterItem[] expected = new PosterItem[]{elem11, elem10, elem9, elem8, elem7, elem6, elem5, elem4, elem3, elem2};

    assertArrayEquals(expected, actual);
  }
}