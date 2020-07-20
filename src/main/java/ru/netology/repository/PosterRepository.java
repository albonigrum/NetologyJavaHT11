package ru.netology.repository;

import ru.netology.domain.PosterItem;


public class PosterRepository {
    private PosterItem[] items = new PosterItem[0];


    public PosterItem[] findAll() {
        return items;
    }

    public void save(PosterItem item) {
        PosterItem[] tmp = new PosterItem[items.length + 1];
        System.arraycopy(items, 0, tmp, 0, items.length);
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public PosterItem findById(int id) {
        for (PosterItem item : items) {
            if (item.getProductId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) != null) {
            PosterItem[] tmp = new PosterItem[items.length - 1];
            int index = 0;
            for (PosterItem item : items){
                if (item.getProductId() != id)
                    tmp[index++] = item;
            }
            items = tmp;
        }
    }

    public void removeAll() {
        items = new PosterItem[0];
    }
}
