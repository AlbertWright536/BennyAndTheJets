public class FinalProject {

    public void sort( int [] array ) {
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
        FinalProject testing = new FinalProject();
        testing.sort(testArray1);
        for (int i = 0 ; i < testArray1.length; i++) {
            System.out.println(testArray1);
        }
    }
}