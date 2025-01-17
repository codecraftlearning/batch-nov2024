package map;

public class Entry <K, V> extends  Object {
    private K key;
    private V value;
    private Integer hashcode;

    public Entry (K key, V value) {
        this.setKey(key);
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
        this.hashcode = key.hashCode();
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Integer getHashcode() {
        return hashcode;
    }

    @Override
    public boolean equals (Object entry) {
        if (entry instanceof Entry<?,?>) {
            return ((Entry<?, ?>) entry).getKey().equals(this.getKey());
        }
        return false;
    }

    @Override
    public String toString() {
        return key+"="+value;
    }
}
