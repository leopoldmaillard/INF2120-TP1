/**
 * Classe utilisee pour les approximations de degre 1
 * Permet de realiser les calculs necessaires a une approximation lineaire 
 */

public class Degre1 extends Equation {
	
/**
 * Constructeur par defaut
 */
	
	public Degre1() {
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
 */

	public Degre1( double x , double h , double y1 , double y2 ) {
		super( x , h , y1 , y2 );
	}
	
/**
 * Calcule la distance entres les images y1 et y2
 * @return le "delta" utile au calcul de l'approximation
 */
	public double delta(){
		return y2 - y1;
	}

/**
 * Calcule et retourne la composante "a" de l'equation d'approximation
 */
	
	public double a() {
		return delta() / h;
	}

/**
 * Calcule et retourne la composante "b" de l'equation d'approximation
 */
	
	public double b() {
		return y1 - a() * x;
	}

/**
 * Ce commentaire s'applique aux 3 methodes res1, res2 et res3
 * Applique l'equation de degre 1 a (x1), (x2) et (x3) et retourne ainsi les resultats de l'approximation
 */
	
	@Override
	public double resultat1() {
		return a() * x1() + b();
	}
	
	public double resultat2() {
		return a() * x2() + b();		
	}
	
	public double resultat3() {
		return a() * x3() + b();		
	}

}