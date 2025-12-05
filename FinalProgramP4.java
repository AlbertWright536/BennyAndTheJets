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
import java.util.HashMap;

public class FinalProgramP4 extends AbstractClass {

    public FinalProgramP4( ) {
        setTrackDB( new ArrayList< TrackInfo >( ) );
        setUsers( new ArrayList< String >( ) );
        setTitles( new ArrayList< String >( ) );
        setArtists( new ArrayList< String >( ) );
        setAlbums( new ArrayList< String >( ) );
        setGenres( new ArrayList< String >( ) );
        setUserTrackMap( new HashMap( ) );
        readInput( "responses.csv" );
    }
    
    /**
    * Uses the distance methods to calculate the similarity between two
    * users with respect to a particular data field.
    *
    * @param user1
    * @param user2
    * @param fieldName - USER, RANK, TITLE, ARTIST, ALBUM, GENRE, PLAYS
    * @param method - Euclidean, PEARSON
    * @return
    */
    double calculateSimilarity( String user1, String user2, String
    fieldName, String method ) {
        ArrayList< TrackInfo > user1List = getUserTrackMap( ).get( user1 );
        ArrayList< TrackInfo > user2List = getUserTrackMap( ).get( user2 );
        if ( method.equals( "JACCARD" ) ) {
            ArrayList< String > user1FieldList = new ArrayList();
            ArrayList< String > user2FieldList = new ArrayList();
            for ( TrackInfo track : user1List ) {
                String trackField = null;
                switch ( fieldName ) {
                    case "TITLE":
                        trackField = track.getTitle( );
                        break;
                    case "ARTIST":
                        trackField = track.getArtist( );
                        break;
                    case "ALBUM":
                        trackField = track.getAlbum( );
                        break;
                    case "GENRE":
                        trackField = track.getGenre( );
                        break;

                    default:
                        return -1;
                }
                if ( !user1FieldList.contains( trackField ) ) {
                    user1FieldList.add( trackField );
                }
            }

            for ( TrackInfo track : user2List ) {
                String trackField = null;
                switch ( fieldName ) {
                    case "TITLE":
                        trackField = track.getTitle( );
                        break;
                    case "ARTIST":
                        trackField = track.getArtist( );
                        break;
                    case "ALBUM":
                        trackField = track.getAlbum( );
                        break;
                    case "GENRE":
                        trackField = track.getGenre( );
                        break;

                    default:
                        return -1;
                }
                if ( !user2FieldList.contains( trackField ) ) {
                    user2FieldList.add( trackField );
                }
            }

            return jaccardSimiliarity( user1FieldList, user2FieldList );
        }

        ArrayList< String > fieldList;
        switch ( fieldName ) {
            case "USER":
                return -1; // Useless output, would always produce 1 or 0. Return error -1
            case "RANK":
                return -1; // Not useful, return -1
            case "TITLE":
                fieldList = getTitles( );
                break;
            case "ARTIST":
                fieldList = getArtists( );
                break;
            case "ALBUM":
                fieldList = getAlbums( );
                break;
            case "GENRE":
                fieldList = getGenres( );
                break;
            case "PLAYS":
                return -1;

            default:
                return -1; // Error, return -1
        }

        ArrayList< Double > user1Scores = new ArrayList< Double >( fieldList.size( ) );
        ArrayList< Double > user2Scores = new ArrayList< Double >( fieldList.size( ) );
        for ( TrackInfo track : user1List ) {
            for ( int i = 0; i < fieldList.size( ); i++ ) {
                if ( user1Scores.size( ) < i + 1 ) {
                    user1Scores.add( 0.0 );
                }
                String fieldValue = fieldList.get( i );
                switch ( fieldName ) {
                    case "TITLE":
                        if ( fieldValue == track.getTitle( ) ) {
                            user1Scores.set( i, user1Scores.get( i ) + 1 );
                        }
                        break;
                    case "ARTIST":
                        if ( fieldValue == track.getArtist( ) ) {
                            user1Scores.set( i, user1Scores.get( i ) + 1 );
                        }
                        break;
                    case "ALBUM":
                        if ( fieldValue == track.getAlbum( ) ) {
                            user1Scores.set( i, user1Scores.get( i ) + 1 );
                        }
                        break;
                    case "GENRE":
                        if ( fieldValue == track.getGenre( ) ) {
                            user1Scores.set( i, user1Scores.get( i ) + 1 );
                        }
                        break;
                
                    default:
                        break;
                }
            }
        }

        for ( TrackInfo track : user2List ) {
            for ( int i = 0; i < fieldList.size( ); i++ ) {
                String fieldValue = fieldList.get( i );
                if ( user2Scores.size( ) < i + 1 ) {
                    user2Scores.add( 0.0 );
                }
                switch ( fieldName ) {
                    case "TITLE":
                        if ( fieldValue == track.getTitle( ) ) {
                            user2Scores.set( i, user2Scores.get( i ) + 1 );
                        }
                        break;
                    case "ARTIST":
                        if ( fieldValue == track.getArtist( ) ) {
                            user2Scores.set( i, user2Scores.get( i ) + 1 );
                        }
                        break;
                    case "ALBUM":
                        if ( fieldValue == track.getAlbum( ) ) {
                            user2Scores.set( i, user2Scores.get( i ) + 1 );
                        }
                        break;
                    case "GENRE":
                        if ( fieldValue == track.getGenre( ) ) {
                            user2Scores.set( i, user2Scores.get( i ) + 1 );
                        }
                        break;
                
                    default:
                        break;
                }
            }
        }

        if ( method == "Euclidean" ) {
            return euclideanDistance( user1Scores, user2Scores );
        } else if ( method == "PEARSON" ) {
            return pearsonDistance( user1Scores, user2Scores );
        } else {
            return -1;
        }
    }
    private double jaccardSimiliarity( ArrayList< String > array1, ArrayList< String >array2 ) {
        ArrayList< String > unionArray = (ArrayList< String >) array1.clone( );
        for (String element : array2) {
            if ( !unionArray.contains( element ) ) {
                unionArray.add( element );
            }
        }

        array1.retainAll( array2 );
        int overlapSize = array1.size( );
        int unionSize = unionArray.size( );
        double jaccard = (double) overlapSize / (double) unionSize;
        
        return jaccard;
    }
    /**
    * Calculate the similarity scores between the specified user and every
    * other user.
    *
    * @param user
    * @param fieldName - USER, RANK, TITLE, ARTIST, ALBUM, GENRE, PLAYS
    * @param method - Euclidean, PEARSON
    * @return
    */
    HashMap< String, Double > calculateAllSimilarity( String user, String fieldName, String method ) {
        HashMap< String, Double > scores = new HashMap( );
        for( String comparedUser : getUsers( ) ) {
            if ( comparedUser.equals( user ) ) {
                continue;
            }
            scores.put( comparedUser, calculateSimilarity( user, comparedUser, fieldName, method ) );
        }
        return scores;
    }
    /**
    * Make a playlist for the specified user comprised of a specified
    * number of music tracks from the most similar users.
    *
    * @param user
    * @param fieldName - USER, RANK, TITLE, ARTIST, ALBUM, GENRE, PLAYS
    * @param method - Euclidean, PEARSON
    * @param numberOfTracks
    * @return
    */
    ArrayList< TrackInfo > makePlaylist( String user, String fieldName,
    String method, int numberOfTracks ) {
        return null;
    }

    ArrayList< KeyValuePair< String, Double > > similarPeople(String user, String fieldName, String method, double filterThreshold) { 
        HashMap< String, Double > testScores = calculateAllSimilarity( user, fieldName, method );        
        ArrayList< KeyValuePair< String, Double > > testScorePairs = new ArrayList<>();

        // ArrayList <String> names = new ArrayList<>();
        
        for (String ComparedUser : getUsers( ) ) {
            if ( ComparedUser.equals( user ) ) {
                continue;
            }
            if ( testScores.get(ComparedUser) >= filterThreshold) {
                testScorePairs.add( new KeyValuePair<>( ComparedUser, testScores.get( ComparedUser) ) );
            }
            //System.out.println( user + ": " + testScores.get( user ) );
        }
        return testScorePairs;

    }

    ArrayList < String > songReccomendations (String user, String fieldName, String method, double filterThreshold) {
        ArrayList < KeyValuePair< String, Double > > names = similarPeople(user, fieldName, method, filterThreshold);
        ArrayList < String > songs = new ArrayList<>();

        names.sort( (a, b) -> { return -1 * a.getValue( ).compareTo( b.getValue( ) ); } );
        
        //iterate throug the people on the list
        for ( KeyValuePair< String, Double > namePair : names ) {
            
            //iterate through the songs of individuals

            for (int j = 0 ; j < getUserTrackMap().get(namePair.getKey( )).size(); j++ ) {


                //Add the song of the person who's name is on the list
                songs.add(getUserTrackMap().get(namePair.getKey( )).get(j).getTitle());
            }
        }
        
        return songs;

    }
    public static void main(String[] args) {
        FinalProgramP4 program = new FinalProgramP4( );
        //Euclidean or PEARSON
        HashMap< String, Double > lucaScores = program.calculateAllSimilarity( "LUCA", "GENRE", "JACCARD" );
        for (String user : program.getUsers( ) ) {
            System.out.println(user + ": " + lucaScores.get(user));
        }
        ArrayList <String> test = program.songReccomendations("LUCA", "GENRE", "JACCARD", 0.30);
        for (int i = 0 ; i < test.size() ; i++) {
            System.out.println(test.get(i));
        }
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

    /*
PART 5

Write a 3 page paper that analyzes the the project and its results.

Possible topics to cover in the report include, but are not limited to:

A comparison between the results of the Euclidian and Pearson similarity methods.
An analysis of the play list results. Are the tracks listed good matches for the user?
How might you improve the relevance of the generated play list tracks?
How might you modify the program to compare tracks across multiple fields (e.g., ARTIST and GENRE, TRACK and RANK, etc.)
An analysis of the efficiency of your code. How might the speed, memory footprint, or accuracy be improved.
What challenges did you face developing the program and how did you overcome them?
    */
}
