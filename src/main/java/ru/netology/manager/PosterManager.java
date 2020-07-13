package ru.netology.manager;

import ru.netology.domain.PosterItem;

import java.util.ArrayList;

public class PosterManager {
  private ArrayList<PosterItem> items = new ArrayList<>();

  public void add(PosterItem item) {
    items.add(item);
  }

  public PosterItem[] getLast10() {
    int lengthResultArray = Math.min(items.size(), 10);
    PosterItem[] result = new PosterItem[lengthResultArray];
    for (int i = 0; i < result.length; i++) {
      result[i] = items.get(items.size() - i - 1);
    }
    return result;
  }

  public void removeById(int id) {
    items.removeIf(elem -> (elem.getId() == id));
  }
}
