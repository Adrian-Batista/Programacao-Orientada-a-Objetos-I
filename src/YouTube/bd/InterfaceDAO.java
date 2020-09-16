package YouTube.bd;

import java.util.List;

/*
 * Uma interface funciona como um contrato entre as classes. Nela, adicionamos
 * apenas a assinatura dos m�todos que as classes que forem seguir este contrato 
 * precisam implementar. Desta forma, podemos utilizar o polimorfismo dizendo que 
 * nossa refer�ncia � do tipo InterfaceDAO, sendo que o objeto em si poder� ser
 * de qualquer classe que implemente o contrato InterfaceDAO.
 */
public interface InterfaceDAO<T> {
	/*
	 * Ao declarar um <Tipo> gen�rico ao lado do nome da classe, estamos dizendo que
	 * esta classe poder� ser utilizada para qualquer tipo de objeto. � assim que as
	 * classes List<T> e ArrayList<T> funcionam tamb�m com classes que n�s criamos.
	 */

	/*
	 * Uma DAO (Data Access Object) � um padr�o de projeto (disciplina do quinto
	 * per�odo). Este padr�o de projeto centraliza em um �nico objeto a comunica��o
	 * com o banco de dados em rela��o a uma �nica entidade ou a um conjunto de
	 * entidades.
	 */
	public void adicionar(T referencia);
	
	public void atualizar(T referencia);

	public void remover(T referencia);

	public List<T> todos();

	/*
	 * Como o m�todo para recuperar um �nico objeto depende do identificador de cada
	 * classe, n�o vamos implement�-lo na Interface, que serve como um contrato
	 * gen�rico para todas as classes de DAO.
	 */
}
