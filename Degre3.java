/**
 * Classe utilisee pour les approximations de degre 3
 * Permet de realiser les calculs necessaires a une approximation cubique
 * 
 * Ajoute une nouvelle valeur image (y4) qui sera utilisee pour le calcul 
 * d'approximation
 */

public class Degre3 extends Degre2{
	public double y4;
	
/**
 * Constructeur par defaut
 */

	public Degre3() {
		super();
	}

/**
 * Constructeur avec parametres
 * Les approximations seront calculees en fonction des parametres de l'objet
 * 
 * @param x est le point connu de l'axe des abscisses
 * @param h est la distance sur l'axe des abscisses entres deux valeurs consecutives
 * @param y1 est le point image associe a� x
 * @param y2 est le point image associe au point x + h
 * @param y3 est le point image associe au point x + 2h
 * @param y4 est le point image associe au point x + 3h
 */
	
	public Degre3( double x , double h , double y1 , double y2 , double y3 , double y4 ) {
		super( x , h , y1 , y2 , y3 );
		this.y4 = y4;
	}
	
	/**
	 * Calcule la distance entres les y
	 * @return le "delta3" utile au calcul de l'approximation
	 */	
	
	public double delta3() {
		return y4 - y3 - y3 + y2 - delta2();
	}
	
/**
 * Calcule et retourne la composante "a" de l'equation d'approximation
 */
	
	@Override
	public double a() {
		return delta3() / ( 6 * h * h * h );
	}

/**
 * Calcule et retourne la composante "b" de l'equation d'approximation
 */
	
	@Override
	public double b() {
		return ( delta2() / ( 2 * h * h ) ) - a() * ( x + x + h + x + h + h );
	}
	
/**
 * Calcule et retourne la composante "c" de l'equation d'approximation
 */	
	
	@Override
	public double c() {
		return ( delta() / h ) - b() * ( x + x + h) - a() * ( x * x + x * ( x + h ) + ( x + h ) * ( x + h ) );
	}
	
/**
 * Calcule et retourne la composante "d" de l'equation d'approximation
 */
	
	public double d() {
		return y1 - c() * x - b() * x * x - a() * x * x * x;
	}

/**
 * Ce commentaire s'applique aux 3 methodes res1, res2 et res3
 * Applique l'equation de degre 2 a (x1), (x2) et (x3) et retourne ainsi les 
 * resultats de l'approximation
 */
	
	@Override
	public double resultat1() {
		return a() * x1() * x1() * x1() + b() * x1() * x1() + c() * x1() + d();
	}
	
	@Override
	public double resultat2() {
		return a() * x2() * x2() * x2() + b() * x2() * x2() + c() * x2() + d();
	}
	
	@Override
	public double resultat3() {
		return a() * x3() * x3() * x3() + b() * x3() * x3() + c() * x3() + d();
	}
	
}
