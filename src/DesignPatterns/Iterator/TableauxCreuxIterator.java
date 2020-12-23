package DesignPatterns.Iterator;
import javax.swing.text.html.HTMLDocument;
import java.util.*;

public class TableauxCreuxIterator implements Iterator {

    protected int index;

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {

    }

}
