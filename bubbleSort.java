public class bubbleSort {
    public void bubbleSort1(int [] array ) {
        boolean swapped = false;
        do {
            swapped = false;
            for(int i = 1; i < array.length; i++) {
                if( array[i-1] > array[i]){
                    int temp = array[i - 1];
                    array [i-1] = array [i];
                    array[i] = temp;
                    swapped = true;

                }
            }
        } while (swapped);
    } 
    public static void main (String [] args) {
        int[] array1 = {1, 3, 5, 3, 5, 2, 7};
        bubbleSort bubble = new bubbleSort();
        bubble.bubbleSort1(array1);
        for (int i = 0 ; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }  
}
