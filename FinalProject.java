public class FinalProject {

    /*public void sort( int [] array ) {
        for (int x : array){
            if (array[x-1] <= array[0]) {
                int y = array[0];
                array[0] = array[x-1];
                array[x-1] = y;
            }
        }
        for (int x : array){
            if(array[x] > array[x-1]){
                sort(array);
                System.out.println("looping");
                break;
                
            }
        }

    }*/

    public void bubbleSort(int [] array ) {
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
    
    public void insertionSort(int [] array) {
        for (int i = 1; i < array.length; i++){
            int target = array[i];
            int j = i - 1;
            for ( ; j>= 0 && array[j] > target; j--) {
                array[j+1] = array[j];
            }
            array[j+1] = target;
        }
    }
    public void mergeSort(int [] array){

    }
    
    /*public void minValSort(int [] array){
        int[] comparisonArray = new int[array.length];
        //int loopcount = 0;
        //go through once per element
        for(int i = 0; i < array.length-1; i++) {
            //find the smallest element in the unsorted elements
            for(int j = i; j < array.length - 1; j++) {
                //place the smallest element in the begining of the array and set value to null
                if (array[j] < array[i]) {
                    comparisonArray[i] = array[j];
                    //set copied value to a large number so as to not be copied again
                    array[j] = 9999999;
                }
                //loopcount++;
            }
        }
        for(int i = 0; i < array.length-1; i++) {
            array[i] = comparisonArray[i];
        }
        //System.out.println(loopcount);
    }*/
    
    public static void main (String [] args) {
        int[] testArray1 = {1, 4, 2, 3, 5, 7, 4, 3, 7, 999, 2};
        FinalProject testing = new FinalProject();
        testing.bubbleSort(testArray1);
        for (int i = 0 ; i < testArray1.length; i++) {
            System.out.println(testArray1[i]);
        }
    }
}