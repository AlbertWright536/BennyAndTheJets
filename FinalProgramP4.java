/*
* Bennie And The Jets
* Freya Durst
* Michelle Boscato
* Marcus Bonifas
* Albert Wright
* Class CS1131
* Michigan Technological University
*/
import java.util.ArrayList;
public class FinalProgramP4 {
    
    //modified pythagorean theorem to find level of similarity between two songs
    public double euclideanDistance( ArrayList< Double > array1, ArrayList< Double > array2 ) {
        double sum = 0.0;
        for( int i = 0; i < array1.size( ); i++ ) {
            sum += Math.pow( ( array1.get( i ) - array2.get( i ) ), 2.0 );
        }
        return 1.0 / ( 1.0 + Math.sqrt( sum ) );
    }

    //get average value across two songs, then get standard deviation across the songs
    //return... something... I don't really understand this formula
    public double pearsonDistance( ArrayList< Double > array1, ArrayList< Double > array2 ) {
        double mean1 = 0.0, mean2 = 0.0;
        for( int i = 0; i < array1.size( ); i++ ) {
            mean1 += array1.get( i );
            mean2 += array2.get( i );
        }   
        mean1 /= array1.size( );
        mean2 /= array2.size( );
        double sumXY = 0.0, sumX2 = 0.0, sumY2 = 0.0;
        for( int i = 0; i < array1.size( ); i++ ) {
            sumXY += ( ( array1.get( i ) - mean1 ) * ( array2.get( i ) - mean2 ) );
            sumX2 += Math.pow( array1.get( i ) - mean1, 2.0 );
            sumY2 += Math.pow( array2.get( i ) - mean2, 2.0 );
        }
        return ( 1.0 + ( sumXY / ( Math.sqrt( sumX2 ) * Math.sqrt( sumY2 ) ) ) ) / 2.0;
    }


    /*
    * Problem 0: Initialize Data
    * Make a constructor to initialize the data members inherited from AbstractClass. 
    * You can't directly access the parent's data members (users, titles, genres, trackDB, etc.) 
    * because they are declared private so remember to use their setter methods. 
    */
    //We can use the work done in part 3


    /*
    * Problem 1: Calculate a single field similarity between two users.  
    * We want to calculate the similarity between two users with respect to one of the data fields, e.g. TITLE, ARTIST, or GENRE. 
    * To use the above distance methods, we need to construct an ArrayList representing a vector of the user's tastes with respect to the chosen field. 
    * One way to do this is to count how many times each possible field value appears in the user's track list.
    * Your task is to calculate the similarity between two users with respect to a data field and a specified distance method.
    */
    //Use the euclidean distance method to compare data.


    /*
    * Problem 2: Calculate the similarity between one user and each of the other users.
    * Write a method calculateAllSimilarity that calculates the similarity between one user (the source user) and all others (the target users), 
    * returning the similarity scores in a HashMap that associates the target user with the resulting similarity score.
    */
    //Loop comparing a single item to all others, and puting similar ones in a HashMap together


    /*
    * Problem 3: Make a playlist of tracks for a specified user from the most similar users.
    * Having calculated the similarity with all other users, make a playlist of tracks from the most similar users. 
    * Start with the user with the highest similarity score, adding his tracks, and continuing to the user with the next highest similarity score, 
    * and so on, until either the specified number of tracks has been added or there are no more users available.
    */
    //Put similar songs into a HashMap


    /*Problem 4: Implement another similarity method.
    * The Euclidean Distance and Pearson Correlation Coefficient are not the only algorithms that can be used to measure similarity. 
    * Other methods include: the Jaccard Similarity CoefficientLinks to an external site., the Tversky IndexLinks to an external site., 
    * Hamming DistanceLinks to an external site., Simple Matching CoefficientLinks to an external site., Minkowski DistanceLinks to an external site., 
    * Manhattan DistanceLinks to an external site., Chebyshev DistanceLinks to an external site.,  Canberra DistanceLinks to an external site., 
    * Sørensen–Dice CoefficientLinks to an external site.. Regardless of which similarity algorithm you choose to implement, 
    * the resulting similarity value should be normalize to the range [0.0, 1.0], indicating the likelihood that the two users being compared share the same music tastes.
    * The method you develop should be integrated with the methods created in Problems 1 - 3.
    * Be sure to document your method and its usage extensively for the grader. Also provide a test method and usage examples.
    * In the comments indicate if your method produces better or worse results that the Euclidian and Pearson methods. 
    */
    //Develop our own comparison method
}
