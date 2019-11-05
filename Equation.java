/**
 * Comporte les elements necessaires au calcul de chaque approximation.
 * 
 * x est le point connu de l'axe des abscisses.
 * h est la distance sur l'axe des abscisses entres deux valeurs consecutives.
 * y1 est le point image associe a� x.
 * y2 est le point image associe au point x + h.
 *
 * Donne les 3 coordonnees des points d'abscisses intermediaires (x1, x2 et x3).
 */

public abstract class Equation {
	public double x , h , y1 , y2;
	
	public Equation() {
	}

	public Equation( double x , double h , double y1 , double y2 ) {
		this.x = x;
		this.h = h;
		this.y1 = y1;
		this.y2 = y2;
	}

/**
 * Ce commentaire s'applique aux 3 methodes x1, x2 et x3
 * 
 * Calcule les 3 valeurs ajoutees par le programme entres (x) et (x + h)
 * @return les 3 nouvelles abscisses 
 */
	
	public double x1() {
		return x + 0.25 * h; 
	}
	
	public double x2() {
		return x + 0.50 * h; 
	}
	
	public double x3() {
		return x + 0.75 * h; 
	}
	
/**
 * Ce commentaire s'applique aux 3 methodes res1, res2 et res3
 * 
 * Calculera les 3 nouveaux points calcules entres deux echantillons
 * Methodes abstraites qui seront Override pour adapter le resultat a chaque degre 
 * d'equation
 * 	
 * @return les 3 valeurs associees a chaque intervalle (celles qui seront 
 * affichees dans le fichier de resultat)
 */
	
	abstract double resultat1();
	abstract double resultat2();
	abstract double resultat3();
	
/**
 * Affiche les 3 nouveaux points calcules
 */
	
	public void resultat() {
		System.out.println( y1 + "\n" + resultat1() + "\n" + resultat2() + "\n" + resultat3() + "" );
	}
}