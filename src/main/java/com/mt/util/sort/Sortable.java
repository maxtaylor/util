package com.mt.util.sort;

import java.util.Collection;
import java.util.Comparator;

/**
 * Created by root on 27/10/16.
 */
public interface Sortable {
    Collection<Comparable> sort(Collection<Comparable> values);
}
