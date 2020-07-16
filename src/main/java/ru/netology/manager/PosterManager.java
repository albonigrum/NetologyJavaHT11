package ru.netology.manager;

import ru.netology.domain.PosterItem;

import java.util.ArrayList;

public class PosterManager {
  private int maxReturnedArraySize = 10;
  private ArrayList<PosterItem> items = new ArrayList<>();

  public PosterManager() {}

  public PosterManager(int maxReturnedArraySize) {
    if (maxReturnedArraySize > 0)
      this.maxReturnedArraySize = maxReturnedArraySize;
  }

  public void add(PosterItem item) {
    items.add(item);
  }

  public PosterItem[] getLasts() {
    int lengthResultArray = Math.min(items.size(), maxReturnedArraySize);
    PosterItem[] result = new PosterItem[lengthResultArray];
    for (int i = 0; i < result.length; i++) {
      result[i] = items.get(items.size() - i - 1);
    }
    return result;
  }

}
