/*
 * Albero m-ario
 * Nome: Riccardo
 * Cognome:	Giannuzzi
 */

package albero_m_ario;

public class IndexOfTreeException extends Exception{
	private static final long serialVersionUID = 1L;
	public IndexOfTreeException(int i, int numFigli) {
		super("La posizione inserita ("+i+") non è valida questo albero può avere un figlio nelle posizioni da 1 a "+numFigli);
	}
}
