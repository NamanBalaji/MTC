package Topics.Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static float getMax(int[] weight, int[] value, int n, int w){
        Item[] items = new Item[n];
        for(int i = 0; i<n; i++){
            items[i] = new Item(value[i], weight[i]);
        }
        Arrays.sort(items, new Comparator<Item>(){
            public int compare(Item x, Item y){
                float wv1 = (float) x.value/x.weight;
                float wv2 = (float) y.value/y.weight;
                if(wv2>wv1){
                    return 1;
                } else if(wv2<wv1){
                    return -1;
                }
                return 0;
            }
        });

        float fVal = 0;
        for(int i=0; i<n; i++){
            if(items[i].weight <= w){
                fVal += items[i].value;
                w -= items[i].weight;
            } else{
                float fractionW = (float) items[i].value/items[i].weight;
                fVal += fractionW * w;
                break;
            }
        }
        return fVal;
    }

    public static void main(String[] args) {
        int n =  3;
        int w =50;
        int values[] = {60,100,120};
        int weight[] = {10,20,30};
        System.out.println(getMax(weight, values, n, w));
    }
}

class Item{
    int value;
    int weight;

    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}