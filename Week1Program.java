import java.util.Calendar;

/**
 * Week1Program: Solves problems in RadioCarbon Dating
 *
 * @author Bennie And The Jets, Marcus, Michelle, Freya, Albert
 */
public class Week1Program {

    /**
     * Given the age of an artifact in years, return the percent of C14 left in it. Here a percentage is a
     * double in the range [0.0, 1.0]. Remember that N / N0 is the percent of C14 remaining in the object.
     * @param age - the age of an artifact in years
     * @return the percent of C14 remaining in the artifact
     */
    double radiocarbonPercent ( int age ) {
        // Fill in the required expressions
        double percentOfCarbonRemaining = Math.pow( Math.E , ( age * ( -0.693 ) ) / 5730 );
        return percentOfCarbonRemaining;
    }

    /**
     * Given the percentage of C14 remaining in an artifact, return the age of the artifact in years.
     * Here a percentage is a double in the range [0.0, 1.0].
     * Your result should be truncated, not rounded.
     * @param p - the percentage of C14 remaining in an artifact
     * @return the age of the artifact in years
     */
    int radiocarbonAge ( double p ) {
        // Fill in the required expressions
        double ageOfArtifact = ( Math.log(p) / -0.693 ) * 5730.0;
        return (int) ageOfArtifact;
    }

    /**
     * Given the percentage of C14 remaining in an artifact, return the year of the artifact was created or the
     * organism died. The date is the current year minus the age of the artifact.
     * Your result should be truncated, not rounded.
     * @param p the percentage of C14
     * @return The date is the current year minus the age of the artifact.
     */
    int radiocarbonDate ( double p ) {
        // Fill in the required expressions
        int currentYear = Calendar.getInstance( ).getWeekYear( );
        int artifactYear = currentYear - radiocarbonAge( p );
        return artifactYear;
    }

    // Test code
    public static void main ( String [ ] args ) {
        Week1Program self = new Week1Program( );

        System.out.println( "Test radiocarbonPercent( age )." );
        int age = 1845;
        double percentage = self.radiocarbonPercent( age );
        System.out.printf( "radiocarbonPercent( %d ) = %f%%. ", age, percentage );
        if ( (int) ( percentage * 100 ) == 80 ) {
            System.out.println( "Success!\n" );
        } else {
            System.out.println( "FAILED!\n" );
        }

        System.out.println( "Test radiocarbonAge( percentage )." );
        percentage = 0.80;
        age = self.radiocarbonAge( percentage );
        System.out.printf( "radiocarbonAge( %f ) = %d years old. ", percentage, age );
        if ( Math.abs(age - 1845) <= 1.0 ) {
            System.out.println( "Success!\n" );
        } else {
            System.out.println( "FAILED!\n" );
        }

        System.out.println( "Test radiocarbonDate( percentage )." );
        percentage = 0.80;
        int year = self.radiocarbonDate( percentage );
        age = 1845;
        System.out.printf( "radiocarbonDate( %f ) = the year %d. ", percentage, year );
        if ( Math.abs( year - (Calendar.getInstance().get(Calendar.YEAR) - age ) ) <= 5.0) {
            System.out.println( "Success!\n" );
        } else {
            System.out.println( "FAILED!\n" );
        }
    }

}
