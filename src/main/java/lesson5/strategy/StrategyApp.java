package lesson5.strategy;

import java.util.Arrays;

public class StrategyApp {
    public static void main(String[] args) {
        int[] arrr = {8,3,5,9,1};
        StrategyClient client = new StrategyClient();
        client.setStrategy(new BubbleSort());
        client.executeStrategy(arrr);
    }
}
//Context
class StrategyClient{
    Sorting strategy;
    public void setStrategy(Sorting strategy) {this.strategy=strategy;}
    public void  executeStrategy (int[] arr){strategy.sort(arr);}
}
//Strategy
interface Sorting{
    void sort(int[] arr);
}


class BubbleSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        System.out.println("Сортировка пузырьком");
        System.out.println("до:\t"+ Arrays.toString(arr));
        for (int barier = arr.length-1; barier>=0; barier--) {
            for (int i = 0; i < barier; i++) {
                if (arr[i]>arr[i+1]){
                    int tmp = arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tmp;
                }
            }
        }
        System.out.println("после:\t"+ Arrays.toString(arr));
    }
}