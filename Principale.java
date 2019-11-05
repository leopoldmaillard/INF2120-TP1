import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Principale {
	
	public static void main( String[] args ) {
/**
 * Scanner va permettre de rentrer le nom du fichier texte au clavier
 */
		Scanner sc = new Scanner ( System.in );
		int degre = 0;
/**
 * Le ArrayList stockera toutes les valeurs des y1,y2,...,yn renseignees dans le fichier texte
 */
		ArrayList < Double > y = new ArrayList < Double > ( );
		double h = 0.0;
		double x = 0.0;
		
		System.out.println ( " Entrez le nom du fichier : " );
		String data = sc.nextLine ( );
		sc.close ( );
		
		recupererDonnees ( degre , data , h , x , y );

	}
	
/**
 * Extrais les donnees du fichier texte
 * Applique les conditions pour que le programme soit interrompu si le fichier 
 * texte n'est pas correctement redige ou si il y a une erreur 
 * (fichier non trouve, etc..)
 * 	
 * @param deg : degre de l'approximation
 * @param data
 * @param h : distance sur l'axe des abscisses entres deux valeurs consecutives
 * @param x  : correspond � x0
 * @param y : liste des (y) renseignes dans le fichier
 */
	
	public static void recupererDonnees ( int deg , String data , double h , 
			double x , ArrayList<Double> y ) {
		try {
			double temp;
			
			FileReader fr = new FileReader ( data );
			BufferedReader fichier = new BufferedReader ( fr );
			Scanner sc = new Scanner ( fichier );
			sc.useLocale ( Locale.CANADA );
			
			// check if the scanner's next token is an int
			if ( sc.hasNextInt( ) ) {
				deg = sc.nextInt( );
			}
			
			// returns true if and only if this scanner has another token
			while ( sc.hasNext( ) ) {
				
				// check if the scanner's next token is an double
				if ( sc.hasNextDouble( ) ) {
					temp = sc.nextDouble( );
					y.add( temp );
				}
			}
			sc.close ( ) ;
			
			} catch ( FileNotFoundException e ) {
				System.out.println( "Le fichier n'existe pas. Arret du programme.. \n");
				System.err.println( e );
				System.exit( -1 );
			
			} catch ( IOException e ) {
				System.out.println( " Probleme de lecture de fichier " );
				System.err.println( e );
				System.exit( -1 );
			}
	
		h = y.get( 0 );
		x = y.get( 1 );
		y.remove( 0 );
		y.remove( 0 );
		
		ecrireResultat( deg , y , h , x );
	}

/**
 * Calcule et affiche les resultats des approximations en fonction du degre 
 * renseigne dans le fichier texte
 */
	public static void ecrireResultat ( int deg, ArrayList < Double > y , double h , double x ) {
		
		Equation fonction = null;
		switch ( deg )
		{
		case 1 :
			int i;
			for ( i = 0 ; i < y.size() - 1 ; i ++ ) {
				fonction = new Degre1( x + i * h , h , y.get( i ), y.get( 1 + i ));
				fonction.resultat( );
			}
			System.out.println( y.get( i ) );
			break;
			
		case 2:
			for ( i = 0 ; i < y.size() - 2 ; i ++ ) {
				fonction = new Degre2( x , h , y.get( i ) , y.get( i + 1 ) , y.get( i + 2 ));
				fonction.resultat( );
			}
			System.out.println( y.get ( i ) );
			break;
			
		case 3:
			for ( i = 0 ; i < y.size() - 3 ; i ++ ) {
				fonction = new Degre3( x , h , y.get( i ) , y.get( i + 1 ) , y.get( i + 2 ) , y.get( i + 3 ));
				fonction.resultat( );
			}
			System.out.println( y.get( i ) );
			break;
			
		default: 
			System.out.println( " Le degre n'est pas valide. " );
		}
	}
}
