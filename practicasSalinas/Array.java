import java.util.Random;

public class Array {

    public int[] devolverArreglo(){
        Random random = new Random();
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.ints(0, 1000)
                    .findFirst()
                    .getAsInt();
        }
        return arr;
    }

}
