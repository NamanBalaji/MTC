package Greedy;

import java.util.Arrays;
import java.util.Comparator;


public class MaxStocks {
    
    public static int maxStocks(int[] price, int amount, int n){
        Stock[] stocks = new Stock[n];
        for(int i=0; i< n; i++){
            stocks[i] = new Stock(price[i], i+1);
        }
        Arrays.sort(stocks, new Comparator<Stock>(){
            public int compare(Stock x, Stock y){
                if(x.price < y.price){
                    return -1;
                } else if (y.price > x.price){
                    return 1;
                } else{
                    return x.day -y.day;
                }
            }
        });
        int ans = 0;
        for(int i=0; i<n; i++){
            ans += Math.min(stocks[i].day, amount/stocks[i].price);
            amount -= stocks[i].price * Math.min(stocks[i].day, amount/stocks[i].price);
        }
        return ans;
    }

    public static void main(String[] args) {
        int price[] = { 10, 7, 19 };
        int n = 3;
        int k = 45;

        System.out.println(maxStocks(price, k, n));

    }

    static class Stock{
        int day;
        int price;

        Stock(int price, int day){
            this.day = day;
            this.price = price;
        }
    }
}