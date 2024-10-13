/*
 * Albero m-ario
 * Nome: Riccardo
 * Cognome:	Giannuzzi
 */

package albero_m_ario;

public class Nodo_m_ario {
	
	//	Attributi  //
	
	private String info;
	private Nodo_m_ario padre;
	private Nodo_m_ario[] figli;  //  Dato che il numero di figli è fisso uso un vettore
	
	//	Costruttore  //
	
	public Nodo_m_ario(int arieta) {
		this.info = null;
		this.padre = null;
		this.figli = new Nodo_m_ario[arieta];
	}
	
	//	Accessori  //
	
	/**
	 * Accessore informazione
	 * @return Informazione
	 */
	public String getInfo() {return info;}
	
	/**
	 * Accessore arietà
	 * @return Arietà
	 */
	public int getArieta() {return figli.length;}
	
	/**
	 * Accessore al padre
	 * @return Padre
	 */
	public Nodo_m_ario getPadre() {return padre;}
	
	/**
	 * Accessore al vettore di figli
	 * @return Riferimento al vettore che contiene i figli
	 */
	public Nodo_m_ario[] getFigli() {return figli;};
	
	/**
	 * Accessore informazione di un figlio i-esimo
	 * @param i Posizione i (i ∈ {1, 2, . . . , m})
	 * @return String contenente l'informazione del figlio i-esimo
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione passata non è valida
	 */
	public String getInfoFiglio(int i) throws IndexOfTreeException {
		if(i<1 || i>figli.length)
			throw new IndexOfTreeException(i, figli.length);
		return figli[i-1].getInfo();
		}
	
	/**
	 * Accessore al figlio i-esimo
	 * @param i Posizione i (i ∈ {1, 2, . . . , m})
	 * @return Il figlio i-esimo
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione passata non è valida
	 */
	public Nodo_m_ario getFiglio(int i) throws IndexOfTreeException {
		if(i<1 || i>figli.length)
			throw new IndexOfTreeException(i, figli.length);
		return figli[i-1];
		}
	
	
	
	//	Mutatori  //
	
	/**
	 * Mutatore informazione
	 * @param info La nuova String
	 */
	public void setInfo(String info) {this.info = info;}
	
	/**
	 * Mutatore padre
	 * @param padre Il nuovo padre
	 */
	public void setPadre(Nodo_m_ario padre) {this.padre = padre;}
	
	/**
	 * Mutatore vettore figli
	 * @param Nodo_m_ario[] figli riferimento al vettore contenente i nodi figli
	 */
	public void setFigli(Nodo_m_ario[] figli) {this.figli = figli;}
	
	/**
	 * Mutatore informazione di un figlio i-esimo
	 * @param i Posizione i (i ∈ {1, 2, . . . , m})
	 * @param informazione String
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione passata non è valida
	 */
	public void setInfoFiglio(int i, String info) throws IndexOfTreeException {
		if(i<1 || i>figli.length)
			throw new IndexOfTreeException(i, figli.length);
		figli[i-1].setInfo(info);
		}
	
	/**
	 * Mutatore nodo figlio in posizione i-esima
	 * @param i Posizione i (i ∈ {1, 2, . . . , m})
	 * @param nuovoFiglio Nodo_m_ario
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione passata non è valida
	 */
	public void setFiglio(int i,Nodo_m_ario nuovoFiglio) throws IndexOfTreeException {
		if(i<1 || i>figli.length)
			throw new IndexOfTreeException(i, figli.length);
		figli[i-1] = nuovoFiglio;
		}
	
	
	//	Metodi //
	
	/**
	 * Metodo toString
	 * @return String contenente l'informazione del nodo
	 */
	public String toString() {return info;}
	
	
	/**
	 * Calcola il livello del nodo seguendo i puntatori padre
	 * @return il livello del nodo
	 */
	public int getLivello() {
		int livello = 0;
		Nodo_m_ario u = this.padre; 
		while(u != null) {
			livello++;
			u = u.getPadre();
		}
		return livello;
	}
	
	/**
	 * Metodo che controlla se il nodo ha un figlio nodo interno in posizione i-esima
	 * Se lo ha restituisce true altrimenti restituisce false
	 * @param i posizione i (i ∈ {1, 2, . . . , m})
	 * @return Boolean esito: true se ha un figlio nodo interno o false se non lo ha
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione passata non è valida
	 */
	public boolean hasFiglio(int i) throws IndexOfTreeException {
		if(i<1 || i>figli.length)
			throw new IndexOfTreeException(i, figli.length);
		return (this.figli[i-1]) != null;
		}
	
}
