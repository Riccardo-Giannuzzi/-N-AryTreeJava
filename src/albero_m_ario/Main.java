/*
 * Albero m-ario
 * Nome: Riccardo
 * Cognome:	Giannuzzi
 */

package albero_m_ario;

import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		try {

		/* Costruzione dell'albero con arietà = 3
		 * A[B[C[F[null,null,G[null,null,null]],null,null],D[null,null,null],E[null,null,null]],null,null]
		 * 
		 *	 						a          - 0
		 *		  	  		 /		|	   \
		 *	 				b		x		x  - 1
		 *	 	  	  /  	|	  \ 	
		 *	 	    c   	d     	e		   - 2
		 *	      / | \	  / | \   / | \
		 *	     f  x  x x  x  x x  x  x       - 3
		 *	   / | \
		 *	  x  x  g             			   - 4
		 *        / | \
		 *       x  x  x					   - 5
		 *  
		 */
		Albero_m_ario albero = new Albero_m_ario(3);
		System.out.println("Stampa albero vuoto: "+albero.toString());
		Nodo_m_ario b = albero.aggiungiRadice("B");
		System.out.println("Stampa albero dopo inserimento della radice: "+albero.toString());
		System.out.println("Numero foglie dopo aver inserito la radice B: "+albero.getNumFoglie());
		System.out.println("Altezza dopo aver inserito la radice B: "+albero.getAltezza());
		System.out.println();
		
		Nodo_m_ario a = albero.sostituisciRadice("A", 1);
		System.out.println("Stampa albero dopo la sostituzione della radice: "+albero.toString());
		Nodo_m_ario c = albero.aggiungiFiglio(b, "C", 1);
		Nodo_m_ario d = albero.aggiungiFiglio(b, "D", 2);
		Nodo_m_ario e = albero.aggiungiFiglio(b, "E", 3);
		Nodo_m_ario f = albero.aggiungiFiglio(c, "F", 1);
		Nodo_m_ario g = albero.aggiungiFiglio(f, "G", 3);
		System.out.println("Stampa albero dopo gli inserimenti: "+albero.toString());
		System.out.println();
		
		// Visite
		LinkedList<String> visitaDFS = albero.visitaDFS();
		System.out.println("Visita DFS: "+visitaDFS.toString());
		
		LinkedList<String> visitaBFS = albero.visitaBFS();
		System.out.println("Visita BFS: "+visitaBFS.toString());
		System.out.println();
		
		// Numero nodi
		System.out.println("num nodi tot: "+albero.getNumNodi());
		System.out.println("num figli nodi interni di b: "+albero.getNumFigli(b));
		System.out.println("num figli nodi interni di c: "+albero.getNumFigli(c));
		System.out.println("num figli nodi interni di g: "+albero.getNumFigli(g));
		System.out.println();
		
		// Lista informazioni dei nodi interni figli di un nodo
		System.out.println("info dei figli nodi interni di b: "+albero.getInfoFigli(b).toString());
		System.out.println("info dei figli nodi interni di c: "+albero.getInfoFigli(c).toString());
		System.out.println("info dei figli nodi interni di g: "+albero.getInfoFigli(g).toString());
		System.out.println();
		
		// Modifica del contenuto di un nodo
		System.out.println("Contenuto prima della modifica: a = "+albero.getInfoNodo(a)+", b = "+albero.getInfoNodo(b));
		albero.setInfoNodo(a, "Alpha");
		albero.setInfoNodo(b, "Beta");
		System.out.println("Contenuto dopo la modifica: a = "+albero.getInfoNodo(a)+", b ="+albero.getInfoNodo(b));
		System.out.println("Stampa albero dopo modifica del nodo a e b: "+albero.toString());
		System.out.println();
		
		// Radice dell'albero
		System.out.println("Radice dell'albero: "+albero.getRadice()+"\n");
		
		// Padre di un nodo
		System.out.println("Padre del nodo g: "+albero.getPadreNodo(g));
		System.out.println("Padre del nodo a: "+albero.getPadreNodo(a)+"\n");
		
		// Conta le foglie
		System.out.println("Numero foglie: "+albero.getNumFoglie()+"\n");
		
		// Altezza 
		System.out.println("altezza: " + albero.getAltezza());
		
		// Livello di un nodo
		System.out.println("livello di g: "+albero.getLivelloNodo(g));
		System.out.println("livello di d: "+albero.getLivelloNodo(d));
		System.out.println("livello di e: "+albero.getLivelloNodo(e));
		System.out.println("livello di a: "+albero.getLivelloNodo(a)+"\n");
		
		
		} catch (IndexOfTreeException | ArietaException e){
			System.out.println(e.getMessage());
		}
	
		
	}

}
