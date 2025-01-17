package map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class CustomHashMap <K, V> {
    private final Integer initialCapacity = 16;
    private final ArrayList<LinkedList<Entry<K, V>>> buckets = new ArrayList<>(initialCapacity);

    public CustomHashMap () {
        for (int i = 0; i < initialCapacity; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    public V put (K key, V value) {
        Entry<K, V> entrySet = new Entry<>(key, value);
        addEntry(entrySet);
        return value;
    }

    public V get (K key) {
        Integer index = getIndex(key);

        LinkedList<Entry<K, V>> list = buckets.get(index);
        if (!list.isEmpty()) {
            for (Entry<K, V> entry : list) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    private void addEntry(Entry<K, V> entry) {
        Integer index = getIndex(entry);
        LinkedList<Entry<K, V>> list = buckets.get(index);
        Integer itemIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(entry)) {
                itemIndex = i;
                break;
            }
        }

        if (itemIndex > -1) {
            list.set(itemIndex, entry);
        } else {
            list.add(entry);
        }

        buckets.set(index, list);
    }

    private Integer getIndex(Entry<K, V> entrySet) {
        Integer hashcode = entrySet.getHashcode();
        return hashcode & (initialCapacity - 1);
    }

    private Integer getIndex(K key) {
        return key.hashCode() & (initialCapacity - 1);
    }

    @Override
    public String toString() {
        return this.buckets.toString();
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            entrySet.addAll(bucket);
        }

        return entrySet;
    }
}
