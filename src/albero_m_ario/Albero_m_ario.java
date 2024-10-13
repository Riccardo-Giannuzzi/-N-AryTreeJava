/*
 * Albero m-ario
 * Nome: Riccardo
 * Cognome:	Giannuzzi
 */

package albero_m_ario;

import java.util.*;

public class Albero_m_ario {
	
	//	Attributi  //
	
	private Nodo_m_ario radice;
	private int arieta; // Numero di figli di un nodo
	private int numNodi; // Contatore per la gestione del numero totale dei nodi nell'albero
	
	//	Costruttore  //
	
	public Albero_m_ario(int arieta) throws ArietaException {
		//  controllo per assicurarsi che l'arietà non sia minore di 1 
		if(arieta<1)
			throw new ArietaException(arieta);
		else
			this.arieta = arieta;
		numNodi = 0;
	}
	
	//	Metodi  //
	
	/**
	 * Crea un nuovo nodo contenente l'informazione passata, lo imposta come radice e lo restituisce.
	 * Se l'albero non è vuoto non aggiunge la radice e restituisce null.
	 * @param info L'informazione che conterrà la radice
	 * @return Il nodo impostato come radice
	 */
	public Nodo_m_ario aggiungiRadice(String info) {
		if (radice!=null)
            return null;
		
		this.radice = new Nodo_m_ario(arieta);
		this.radice.setInfo(info);
		
		// Gestione numero nodi
		numNodi++;
		
		return radice;
	}
	
	/**
	 * Crea e inserisce un nuovo nodo con l'informazione passata come figlio i-esimo di un nodo U.
	 * Restituisce il nodo appena inserito.
	 * Se è già presente un nodo nella posizione passata come parametro, restituisce null e non aggiunge ulteriori nodi.
	 * @param padre Il nodo padre a cui sarà aggiunto un figlio
	 * @param info L'informazione del nuovo nodo figlio
	 * @param i Posizione del nuovo nodo figlio (i ∈ {1, 2, . . . , m})
	 * @return Il nodo appena inserito
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione i passata non è valida
	 */
	public Nodo_m_ario aggiungiFiglio(Nodo_m_ario padre,String info, int i) throws IndexOfTreeException {
		
		// Controllo per verificare se è già presente un figlio in quella posizione
		if(padre.hasFiglio(i)) {
			return null;
		}
		
		// Creazione e inserimento  del nodo
		Nodo_m_ario u = new Nodo_m_ario(this.arieta);
		u.setInfo(info);
		u.setPadre(padre);
		padre.setFiglio(i, u);
		
		// Gestione numero nodi
		numNodi++;
		
		return u;
	}
	
	/**
	 * Variante dell'inserimento in cui invece dell'informazione come parametro si ha un oggetto Nodo_m_ario figlio.
	 * Non viene quindi creato un nuovo nodo ma si inserisce un nodo già esistente.
	 * Se è già presente un nodo nella posizione passata come parametro, restituisce null e non aggiunge ulteriori nodi.
	 * @param padre Il nodo padre a cui sarà aggiunto un figlio
	 * @param figlio Il nodo che verrà inserito
	 * @param i Posizione del nuovo nodo figlio (i ∈ {1, 2, . . . , m})
	 * @return Il nodo appena inserito
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione i passata non è valida
	 */
	public Nodo_m_ario aggiungiFiglio(Nodo_m_ario padre,Nodo_m_ario figlio, int i) throws IndexOfTreeException {
		
		// Controllo per verificare se è già presente un figlio in quella posizione
		if(padre.hasFiglio(i)) {
			return null;
		}
		
		// Inserimento del nodo figlio
		figlio.setPadre(padre);
		padre.setFiglio(i, figlio);
		
		// Gestione numero nodi
		numNodi++;
		
		return figlio;
	}
	
	/**
	 * Crea e inserisce una nuova radice e rende la vecchia radice il figlio i-esimo della nuova radice.
	 * Se è già presente un nodo nella posizione passata come parametro, restituisce null e non aggiunge ulteriori nodi.
	 * Restituisce il nuovo nodo radice.
	 * @param info Informazione che conterrà il nuovo nodo radice
	 * @param i Posizione in cui finirà la vecchia radice (i ∈ {1, 2, . . . , m})
	 * @return La nuova radice appena inserita
	 * @throws IndexOfTreeException Eccezione lanciata se la posizione i passata non è valida
	 */
	public Nodo_m_ario sostituisciRadice(String info, int i) throws IndexOfTreeException {
		
		// Controllo per verificare se è già presente un figlio nella posizione in cui finirebbe la radice
		if(radice.hasFiglio(i)) {
			return null;
		}
		
		// Creazione del nuovo nodo radice
		Nodo_m_ario temp = radice;
		radice = new Nodo_m_ario(arieta);
		radice.setInfo(info);
		aggiungiFiglio(radice,temp,i);
		return radice;
	}
	
	/**
	 * Visita in profondità (anticipata) algoritmo iterativo.
	 * Utilizza uno stack per gestire l'ordine in cui visitare i nodi non ancora chiusi.
	 * @return Restituisce una lista contenente le informazioni dei nodi visitati
	 */
	public LinkedList<String> visitaDFS(){
		
		Stack<Nodo_m_ario> stack = new Stack<Nodo_m_ario>();
		LinkedList<String> listaNodi = new LinkedList<String>();
		stack.push(radice); // push aggiunge in cima
		while(!stack.isEmpty()) {
			Nodo_m_ario n = stack.pop(); // pop togli l'ultimo elemento inserito
			if(n != null) {
				listaNodi.add(n.toString()); // Chiusura del nodo
				Nodo_m_ario[] figli = n.getFigli();
				//Quando indaga un nodo mette i suoi figli in cima alla pila prima degli altri nodi già presenti
				for(int i = arieta-1; i>=0; i--) { 
					// Aggiunge figli del nodo alla pila partendo dall'ultimo
					stack.push(figli[i]); 
				}
			}
		}
		
		return listaNodi;
		
	}
	
	/**
	 * Visita in ampiezza (per livelli) algoritmo iterativo.
	 * Utilizza una coda per gestire l'ordine in cui visitare i nodi non ancora chiusi.
	 * @return Restituisce una lista contenente le informazioni dei nodi visitati
	 */
	public LinkedList<String> visitaBFS(){
		Queue<Nodo_m_ario> coda = new LinkedList<Nodo_m_ario>(); // come coda viene utilizzata una lista
		LinkedList<String> listaNodi = new LinkedList<String>();
		coda.add(radice); // add aggiunge in fondo
		while(!coda.isEmpty()) {
			Nodo_m_ario n = coda.remove(); // remove senza parametro toglie il primo
			if(n != null) {
				listaNodi.add(n.toString()); // chiusura del nodo
				Nodo_m_ario[] figli = n.getFigli();
				//Quando indaga un nodo mette i suoi figli in fondo alla coda dopo gli altri nodi già presenti
				for(Nodo_m_ario m : figli) { // aggiunge figli del nodo alla coda partendo dal primo
					coda.add(m);
				}
			}
		}
		
		return listaNodi;
		
	}
	
	/**
	 * Visita in ampiezza (per livelli) algoritmo iterativo.
	 * Utilizza una coda per gestire l'ordine in cui visitare i nodi non ancora chiusi.
	 * @return Restituisce una lista contenente i nodi visitati
	 */
	//Variante che si può utilizzare per individuare il nodo con il livello più alto dell'albero (l'ultimo della lista)
	public LinkedList<Nodo_m_ario> visitaBFS_Nodi() {
		Queue<Nodo_m_ario> coda = new LinkedList<Nodo_m_ario>(); // simulo la coda con una lista
		LinkedList<Nodo_m_ario> listaNodi = new LinkedList<Nodo_m_ario>();
		coda.add(radice); // add aggiunge in fondo
		while(!coda.isEmpty()) {
			Nodo_m_ario n = coda.remove(); // remove senza parametro toglie il primo
			if(n != null) {
				listaNodi.add(n); // chiusura del nodo
				Nodo_m_ario[] figli = n.getFigli();
				//Quando indaga un nodo mette i suoi figli in fondo alla coda dopo gli altri nodi già presenti
				for(Nodo_m_ario m : figli) { // aggiunge figli del nodo alla coda
					coda.add(m);
				}
			}
		}
		
		return listaNodi;
		
	}
	
	/**
	 * Calcola l'altezza dell'albero con il livello dell'ultimo nodo visitato dalla vista in ampiezza (BFS).
	 * @return Altezza dell'albero
	 */
	public int getAltezza() {
		if(radice != null) {
			LinkedList<Nodo_m_ario> listaNodi = this.visitaBFS_Nodi();
			return listaNodi.get(listaNodi.size()-1).getLivello()+1; //+1 perché si considerano anche le foglie dell'ultimo nodo
		} else {
			return 0;
		}
	}
	
	/**
	 * Il numero dei nodi dell'albero viene gestito da un contatore incrementato ad ogni inserimento.
	 * @return Il numero di nodi dell'albero
	 */
	public int getNumNodi() {
		return numNodi;
	}
	
	/**
	 * Indaga tutti i figli del nodo passato come parametro e se non sono null incrementa il contatore.
	 * @param nodo Il nodo di cui verranno contati i figli
	 * @return Il numero di nodi interni figli di un nodo interno
	 */
	public int getNumFigli(Nodo_m_ario nodo) {
		int numeroNodi = 0;
		Nodo_m_ario[] figli = nodo.getFigli();
		// controlla se ogni figlio è null, se non lo è incrementa il contatore
		for(Nodo_m_ario m: figli) {
			if(m != null)
				numeroNodi++;
		}
		return numeroNodi;
	}
	
	/**
	 * Scorre tutti i figli del nodo e verifica se sono figli e se lo sono aggiunge la loro informazione alla lista
	 * @param nodo Il nodo di cui verranno visitati i figli
	 * @return Una lista contenente le informazioni dei figli del nodo passato che siano nodi interni
	 */
	public LinkedList<String> getInfoFigli(Nodo_m_ario nodo){
		LinkedList<String> listaInfoFigli = new LinkedList<String>();
		Nodo_m_ario[] figli = nodo.getFigli();
		// controlla se ogni figlio è null, se non lo è aggiugne la sua informazione alla lista
		for(Nodo_m_ario m: figli) {
			if(m != null)
				listaInfoFigli.add(m.getInfo());
		}
		return listaInfoFigli;
	}
	
	/**
	 * Restuisce l'informazione di un nodo interno
	 * @param nodo Il nodo di cui si vuole il contenuto
	 * @return Il contenuto del nodo interno passato come parametro
	 */
	public String getInfoNodo(Nodo_m_ario nodo) {return nodo.getInfo();}
	

	/**
	 * Cambia l'informazione di un nodo interno e restituisce la vecchia informazione contenuta
	 * @param nodo Il nodo di cui si cambia il contenuto
	 * @param info La nuova informazione da inserire nel nodo
	 * @return La string che conteneva il nodo priam della modifica
	 */
	public String setInfoNodo(Nodo_m_ario nodo,String info) {
		String oldInfo = nodo.getInfo();
		nodo.setInfo(info);
		return oldInfo;
		}
	
	/**
	 * Restituisce la radice dell'albero
	 * @return La radice dell'albero
	 */
	public Nodo_m_ario getRadice() {return radice;}
	
	/**
	 * Restituisce il padre di un nodo interno
	 * @param nodo il nodo di cui si vuole il padre
	 * @return Il padre del nodo
	 */
	public Nodo_m_ario getPadreNodo(Nodo_m_ario nodo) {return nodo.getPadre();}
	
	/**
	 * Restituisce il livello di un nodo interno
	 * @param nodo Il nodo di cui si calcola il livello
	 * @return Il livello del nodo
	 */
	public int getLivelloNodo(Nodo_m_ario nodo) {return nodo.getLivello();}
	

	/**
	 * Calcola il numero delle foglie dell'albero.
	 * Il numero di foglie viene calcolato ricorsivamente investigando partendo dalla radice ogni nodo figlio.
	 * @return Il numero di foglie dell'albero
	 */
	public int getNumFoglie() {
			return contaFoglie(radice);
	}
	
	/**
	 * Restituisce il numero delle foglie del nodo interno passato come parametro e dei suoi figli nodi interni.
	 * Il numero di foglie viene calcolato ricorsivamente investigando partendo dal nodo passato ogni nodo figlio.
	 * @param nodo Il nodo da cui parte la ricerca delle foglie
	 * @return Il numero di foglie del nodo e dei suoi figli nodi interni
	 */
	public int contaFoglie(Nodo_m_ario nodo) {
		
		int numFoglie = 0;	
		
		Nodo_m_ario[] figli = nodo.getFigli();
		for(Nodo_m_ario m : figli) {
			if(m==null)
				numFoglie++;
			else
				// Se non è una foglia allora controllo anche il figlio
				numFoglie += contaFoglie(m);
		}
		return numFoglie;
	}
	
	
	/**
	 * Partendo dalla radice stampa ricorsivamente il contenuto di tutti i nodi dell'albero
	 * Le foglie vengono indicate con null
	 * @return Una String rappresentativa del contenuto dell'albero
	 */
	public String toString() {
		String s = "";
		s = stampaRicorsiva(radice,s);
		return s;
	}
	
	private String stampaRicorsiva(Nodo_m_ario n, String s) {
		if(n == null) {
			s= s + "null";
			return s;
		}
		
		s = s + n.toString()+"[";
		
		Nodo_m_ario[] figli = n.getFigli();
		
		s = stampaRicorsiva(figli[0],s);
		for(int i = 1; i < arieta; i++) {
			s=s+",";
			s = stampaRicorsiva(figli[i],s);		
		}
		s = s + "]";
		
		return s;
	}
	
}
