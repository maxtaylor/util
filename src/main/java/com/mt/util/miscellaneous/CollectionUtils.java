package com.mt.util.miscellaneous;

import com.mt.util.exception.MTBug;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by root on 31/10/16.
 */
public enum CollectionUtils {

    //todo work in progress

    Instance;

    public boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public String toString(Collection value) {
        return (value == null) ? "null" : Arrays.toString(value.toArray());
    }

    public boolean isSame(Collection collection1, Collection collection2) {

        if (collection1 == null || collection2 == null) {
            throw new MTBug("One of the collections is null");
        }

        return collection1.containsAll(collection2) && collection2.containsAll(collection1);
    }

}
