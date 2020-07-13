package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.PosterItem;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class PosterManagerMoreThenOneElementTest {
  private PosterManager posterManager = new PosterManager();
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
    PosterItem[] actual = posterManager.getLast10();
    PosterItem[] expected = new PosterItem[]{elem11, elem10, elem9, elem8, elem7, elem6, elem5, elem4, elem3, elem2};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldRemoveIfExists() {
    int idToRemove = 2;
    posterManager.removeById(idToRemove);

    PosterItem[] actual = posterManager.getLast10();
    PosterItem[] expected = new PosterItem[]{elem11, elem10, elem9, elem8, elem7, elem6, elem5, elem4, elem3, elem1};

    assertArrayEquals(expected, actual);
  }

  @Test
  public void shouldNotRemoveIfNotExists() {
    int idToRemove = 12;

    posterManager.removeById(idToRemove);

    PosterItem[] actual = posterManager.getLast10();
    PosterItem[] expected = new PosterItem[]{elem11, elem10, elem9, elem8, elem7, elem6, elem5, elem4, elem3, elem2};

    assertArrayEquals(expected, actual);
  }
}