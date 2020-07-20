package ru.netology.manager;

import ru.netology.domain.PosterItem;

public class PosterManager {
  private int maxReturnedArraySize = 10;
  private PosterItem[] items = new PosterItem[0];

  public PosterManager() {}

  public PosterManager(int maxReturnedArraySize) {
    if (maxReturnedArraySize > 0)
      this.maxReturnedArraySize = maxReturnedArraySize;
  }

  public void add(PosterItem item) {
    PosterItem[] tmp = new PosterItem[items.length + 1];
    System.arraycopy(items, 0, tmp, 0, items.length);
    tmp[tmp.length - 1] = item;
    items = tmp;
  }

  public PosterItem[] getLasts() {
    int lengthResultArray = Math.min(items.length, maxReturnedArraySize);
    PosterItem[] result = new PosterItem[lengthResultArray];
    for (int i = 0; i < result.length; i++) {
      result[i] = items[items.length - i - 1];
    }
    return result;
  }
}
