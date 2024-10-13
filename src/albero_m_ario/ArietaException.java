/*
 * Albero m-ario
 * Nome: Riccardo
 * Cognome:	Giannuzzi
 */

package albero_m_ario;

public class ArietaException extends Exception{
	private static final long serialVersionUID = 1L;
	public ArietaException(int arieta) {
		super("L'arietà inserita ("+arieta+") non è valida, deve essere maggiore o uguale ad 1");
	}
}
