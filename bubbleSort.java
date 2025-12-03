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
    public double getAverage( int [] array ){
        double sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return (sum / array.length);
    } 
    public static void main (String [] args) {
        int[] array1 = {1, 3, 5, 3, 5, 2, 7, 9, 1, 15, 2, 17, 4, 4,3,2,5,6,7,7,8,12,3,44,61,4,6,5,4,2,345,34,14,6,5};
        bubbleSort bubble = new bubbleSort();
        bubble.bubbleSort1(array1);
        for (int i = 0 ; i < array1.length; i++) {
            System.out.print(array1[i] + ",");
        }
        //System.out.println(bubble.getAverage(array1));
    }  
}
