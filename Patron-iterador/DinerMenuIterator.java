public class DinerMenuIterator implements Iterator {

    MenuItem[] items;
    int numberOfItems;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items, int numberOfItems) {
        this.items = items;
        this.numberOfItems = numberOfItems;
    }

    @Override
    public boolean hasNext() {
        return position < numberOfItems && items[position] != null;
    }

    @Override
    public MenuItem next() {
        return items[position++];
    }
}
