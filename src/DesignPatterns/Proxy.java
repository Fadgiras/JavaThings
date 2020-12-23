package DesignPatterns;
import java.util.HashMap;
import java.util.Map;

public class Proxy {

    private Map<Integer, Long> cache = new HashMap<>();
    //iteratif
    long somme(int n) {
        if (!cache.containsKey(n)) {
            long res = 0;
            for (int i = 1; i <= n; i++)
                res += i;
            cache.put(n, res);
        }
        return cache.get(n);
    }
    //recursif
    long somme2(int n){
        if(!cache.containsKey(n)){
            long res = 0;
            if (n > 0)
                res = n + somme2(n - 1);
            cache.put(n, res);
        }
        return cache.get(n);
    }


    public static void main(String[] args){
        Proxy proxy =  new Proxy();
        System.out.println(proxy.somme(10));
        System.out.println(proxy.somme2(10));
    }
}
