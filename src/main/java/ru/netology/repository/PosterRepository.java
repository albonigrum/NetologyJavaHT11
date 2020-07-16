package ru.netology.repository;

import ru.netology.domain.PosterItem;

import java.util.ArrayList;

public class PosterRepository {
    private ArrayList<PosterItem> items = new ArrayList<>();


    public PosterItem[] findAll() {
        return items.toArray(new PosterItem[0]);
    }

    public void save(PosterItem item) {
        items.add(item);
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
        items.removeIf(elem -> (elem.getProductId() == id));
    }

    public void removeAll() {
        items.clear();
    }
}
