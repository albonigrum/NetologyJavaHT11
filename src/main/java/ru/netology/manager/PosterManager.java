package ru.netology.manager;

import ru.netology.domain.PosterItem;
import ru.netology.repository.PosterRepository;

import java.util.ArrayList;

public class PosterManager {
  private PosterRepository repository;

  PosterManager(PosterRepository repository) {this.repository = repository;}


  public void add(PosterItem item) {
    repository.save(item);
  }

  public PosterItem[] getLast10() {
    PosterItem[] items = repository.findAll();

    int lengthResultArray = Math.min(items.length, 10);
    PosterItem[] result = new PosterItem[lengthResultArray];

    for (int i = 0; i < result.length; i++) {
      result[i] = items[items.length - i - 1];
    }
    return result;
  }

  public void removeById(int id) {
    repository.removeById(id);
  }
}
