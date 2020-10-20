package DesignPatterns.Strategy;

public class CarreMoche extends Carre{
    @Override
    public int carre(int n) {
        int res = 0;
        for(int i = 0; i==n; i++){
            if (!isEven(n)){
                res = res + n;
            }
        }
        return res +(2*n-1);
    }

    static Boolean isEven(int n){
        return n%2 ==0;
    }

    public int main(String[] args) {
        return carre(1);
    }
}

