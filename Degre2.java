/**
 * Classe utilisee pour les approximations de degre 2
 * Permet de realiser les calculs necessaires a une approximation quadratique
 * 
 * Ajoute une nouvelle valeur image (y3) qui sera utilisee pour le calcul d'approximation
 */

public class Degre2 extends Degre1{
	public double y3;

/**
 * Constructeur par defaut
 */
	
	public Degre2() {
		super();
	}

/**
 * Constructeur avec parametres
 * Les approximations seront calculees en fonction des parametres de l'objet
 * 
 * @param x est le point connu de l'axe des abscisses
 * @param h est la distance sur l'axe des abscisses entres deux valeurs consecutives
 * @param y1 est le point image associe a x
 * @param y2 est le point image associe au point x + h
 * @param y3 est le point image associe au point x + 2h
 */
	
	public Degre2( double x , double h , double y1 , double y2 , double y3 ) {
		super( x , h , y1 , y2 );
		this.y3 = y3;
	}

/**
 * Calcule la distance entres les y
 * @return le "delta2" utile au calcul de l'approximation
 */	
	
	public double delta2() {
		return y3 - y2 - delta();
	}
	
/**
 * Calcule et retourne la composante "a" de l'equation d'approximation
 */
	
	@Override
	public double a() {
		return delta2() / ( 2 * h * h );
	}
	
/**
 * Calcule et retourne la composante "b" de l'equation d'approximation
 */
	
	@Override
	public double b() {
		return ( delta() / h ) - a() * ( x + x + h );
	}
	
/**
 * Calcule et retourne la composante "c" de l'equation d'approximation
 */	
	
	public double c() {
		return y1 - b() * x - a() * x * x;
	}

/**
 * Ce commentaire s'applique aux 3 methodes res1, res2 et res3
 * Applique l'equation de degre 2 a (x1), (x2) et (x3) et retourne ainsi les 
 * resultats de l'approximation
 */ 
	
	@Override
	public double resultat1() {
		return a() * x1() * x1() + b() * x1() + c();
	}
	
	@Override
	public double resultat2() {
		return a() * x2() * x2() + b() * x2() + c();
	}
	
	@Override
	public double resultat3() {
		return a() * x3() * x3() + b() * x3() + c();
	}
}