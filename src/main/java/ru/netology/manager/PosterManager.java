package ru.netology.manager;

import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

import java.util.ArrayList;

public class PosterManager {
  private int maxReturnedArraySize = 10;
  private PosterRepository repository;
  private ArrayList<PosterItem> items = new ArrayList<>();

  //Без него не хочет работать Mockito(
  private PosterManager() {}

  public PosterManager(PosterRepository repository) {this.repository = repository;}

  public PosterManager(PosterRepository repository, int maxReturnedArraySize) {
    this.repository = repository;
    if (maxReturnedArraySize > 0)
      this.maxReturnedArraySize = maxReturnedArraySize;
  }

  public void add(PosterItem item) {
    repository.save(item);
  }

  public PosterItem[] getLasts() {
    PosterItem[] items = repository.findAll();

    int lengthResultArray = Math.min(items.length, maxReturnedArraySize);

    PosterItem[] result = new PosterItem[lengthResultArray];

    for (int i = 0; i < result.length; i++) {
      result[i] = items[items.length - i - 1];
    }
    return result;
  }
}
