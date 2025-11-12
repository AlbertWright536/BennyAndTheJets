public class FinalProject {

    public static void sort( int [] array ) {
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

    }
    public static void main (String [] args) {
        int[] testArray1 = {1, 4, 2, 3, 5};
        sort(testArray1);
        System.out.println(testArray1);
    }
}