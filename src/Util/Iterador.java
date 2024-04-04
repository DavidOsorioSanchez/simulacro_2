package Util;

import java.util.List;

public class Iterador {

    public static <T> T[] listArray(List<T> list){
        T[] array = (T[]) new Object[list.size()];
        int i=0;
        for (T iterador : list){
            array[i++] = iterador;
        }
        return array;
    }

}
