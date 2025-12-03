import java.util.ArrayList;
public class FinalProgramP4 {
    public double euclideanDistance( ArrayList< Double > array1, ArrayList< Double > array2 ) {
        double sum = 0.0;
        for( int i = 0; i < array1.size( ); i++ ) {
            sum += Math.pow( ( array1.get( i ) - array2.get( i ) ), 2.0 );
        }
        return 1.0 / ( 1.0 + Math.sqrt( sum ) );
    }
}
