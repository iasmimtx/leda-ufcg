package sorting.test;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import sorting.AbstractSorting;
import sorting.simpleSorting.BubbleSort;
import sorting.simpleSorting.InsertionSort;
import sorting.simpleSorting.SelectionSort;
import sorting.variationsOfBubblesort.BidirectionalBubbleSort;
import sorting.variationsOfBubblesort.RecursiveBubbleSort;
import sorting.variationsOfSelectionsort.RecursiveSelectionSort;

public class StudentSortingTest {


	private Integer[] vetorTamPar;
	private Integer[] vetorTamImpar;
	private Integer[] vetorVazio = {};
	private Integer[] vetorValoresRepetidos;
	private Integer[] vetorValoresIguais;

	private Integer[] vetorOrdenado;
	private Integer[] vetorInversamenteOrdenado;
	private Integer[] vetorValoresNegativos;
	private String[] vetorStrings;
	private Double[] vetorDouble;
	private Integer[] vetorUmElemento;
	private Integer[] vetorGeral;

	private Integer[] vetorNull = null;

	public AbstractSorting<Integer> implementation;

	@Before
	public void setUp() {
		populaVetorTamanhoPar(new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23,
				31 });
		populaVetorTamanhoImpar(new Integer[] { 6, 41, 32, 7, 26, 4, 37, 49,
				11, 18, 36 });
		populaVetorRepetido(new Integer[] { 4, 9, 3, 4, 0, 5, 1, 4 });
		populaVetorIgual(new Integer[] { 6, 6, 6, 6, 6, 6 });

		popularVetorOrdenado(new Integer[] {-130, -6, -4, -3, 0, 3, 4, 5, 6, 7, 1000});
		popularVetorInversamenteOrdenado(new Integer[] {10, 9, 8, 7, 6, 5, 4,
				3, 2, 1});
		popularVetorValoresNegativos(new Integer[] { 30, 28, -7, 29, -11, 26, -4,
				22, -23, 31 });
		popularVetorStrings(new String[] {"ab", "ba", "ab", "a1", "a2"});
		popularVetorDouble(new Double[] {1.345, 2.004, -0.32456, -5.0, -100.999, 0.0, 200.5});
		popularVetorUmElemento( new Integer[] {30});
		popularVetorGeral(new Integer[] {2, 4, 6, 8, 7, 6, 5, 4, -10, -10, 4, 4, 4, 4, -4, -90});

		getImplementation();
	}





	// // MÉTODOS AUXILIARES DA INICIALIZAÇÃO
	/**
	 * Método que inicializa a implementação a ser testada com a implementação
	 * do aluno
	 */
	private void getImplementation() {
		// TODO O aluno deve instanciar sua implementação abaixo ao invés de
		// null
		this.implementation = new BubbleSort<Integer>();
		//Assert.fail("Implementation not provided");
	}

	public void populaVetorTamanhoPar(Integer[] arrayPadrao) {
		this.vetorTamPar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorTamanhoImpar(Integer[] arrayPadrao) {
		this.vetorTamImpar = Arrays.copyOf(arrayPadrao, arrayPadrao.length);
	}

	public void populaVetorRepetido(Integer[] arrayPadrao) {
		this.vetorValoresRepetidos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void populaVetorIgual(Integer[] arrayPadrao) {
		this.vetorValoresIguais = Arrays
				.copyOf(arrayPadrao, arrayPadrao.length);
	}


	private void popularVetorOrdenado(Integer[] arrayPadrao) {
		this.vetorOrdenado = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void popularVetorInversamenteOrdenado(Integer[] arrayPadrao) {
		this.vetorInversamenteOrdenado = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void popularVetorValoresNegativos(Integer[] arrayPadrao) {
		this.vetorValoresNegativos = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	public void popularVetorStrings(String[] arrayPadrao) {
		this.vetorStrings = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}

	private void popularVetorUmElemento(Integer[] arrayPadrao) {
		this.vetorUmElemento = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);
	}


	private void popularVetorGeral(Integer[] arrayPadrao) {
		this.vetorGeral = Arrays.copyOf(arrayPadrao,
				arrayPadrao.length);

	}

	private void popularVetorDouble(Double[] doubles) {
		this.vetorDouble = Arrays.copyOf(doubles, doubles.length);
	}
	// FIM DOS METODOS AUXILIARES DA INICIALIZAÇÃO

	// MÉTODOS DE TESTE

	public void genericTest(Integer[] array) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array);
		Arrays.sort(copy1);
		Assert.assertArrayEquals(copy1, array);
	}

	public void subSetTest(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}
		implementation.sort(array, leftIndex, rightIndex);
		Arrays.sort(copy1, leftIndex, rightIndex + 1);

		Assert.assertArrayEquals(copy1, array);
	}

	public void noSortTest(Integer[] array, int leftIndex, int rightIndex) {
		Integer[] copy1 = {};
		if(array.length > 0){
			copy1 = Arrays.copyOf(array, array.length);
		}

		implementation.sort(array, leftIndex, rightIndex);

		Assert.assertArrayEquals(copy1, array);
	}

	@Test
	public void testSortVetorTamPar01() {
		genericTest(vetorTamPar);
	}

	@Test
	public void testSort02() {
		genericTest(vetorTamImpar);
	}

	@Test
	public void testSort03() {
		genericTest(vetorVazio);
	}

	@Test
	public void testSort04() {
		genericTest(vetorValoresIguais);
	}

	@Test
	public void testSort05() {
		genericTest(vetorValoresRepetidos);
	}

	// MÉTODOS QUE OS ALUNOS PODEM CRIAR
	/**
	 * O ALUNO PODE IMPLEMENTAR METODOS DE ORDENAÇÃO TESTANDO O SORT COM TRES
	 * ARGUMENTOS PARA TESTAR A ORDENACAO EM UM PEDAÇO DO ARRAY. DICA: PROCUREM
	 * SEGUIR A ESTRUTURA DOS MÉTODOS DE TESTE ACIMA DESCRITOS, ORDENANDO APENAS
	 * UMA PARTE DO ARRAY.
	 */
	@Test
	public void testVetorOrdenado() {
		genericTest(vetorOrdenado);
	}

	@Test
	public void testVetorInversamenteOrdenado() {
		genericTest(vetorInversamenteOrdenado);
	}

	@Test
	public void testVetorValoresNegativos() {
		genericTest(vetorValoresNegativos);
	}

	@Test
	public void testVetorString() {
		AbstractSorting<String> implementation2 = new RecursiveBubbleSort<String>();
		String[] copy1 = {};
		if(vetorStrings.length > 0){
			copy1 = Arrays.copyOf(vetorStrings, vetorStrings.length);
		}
		implementation2.sort(vetorStrings);
		Arrays.sort(copy1);

		Assert.assertArrayEquals(copy1, vetorStrings);
	}

	@Test
	public void testVetorDouble() {
		AbstractSorting<Double> implementation2 = new BubbleSort<Double>();
		Double[] copy1 = {};
		if(vetorDouble.length > 0){
			copy1 = Arrays.copyOf(vetorDouble, vetorDouble.length);
		}
		implementation2.sort(vetorDouble);
		Arrays.sort(copy1);

		Assert.assertArrayEquals(copy1, vetorDouble);
	}

	@Test
	public void testVetorUmElemento() {
		genericTest(vetorUmElemento);
	}

	@Test
	public void testSubVetor() {
		subSetTest(vetorGeral, 1, vetorGeral.length - 1);
	}

	@Test
	public void testSubVetorValoresTamImpar() {
		subSetTest(vetorGeral, 4, 8);
	}

	@Test
	public void testSubVetorValoresTamPar() {
		subSetTest(vetorGeral, 4, 7);
	}

	@Test
	public void testSubVetorValoresTamUm() {
		subSetTest(vetorGeral, 4, 4);
	}

	@Test
	public void testSubVetorLeftMaiorQueRight() {
		subSetTest(vetorGeral, 5, 4);
	}

	// Testes onde a lista não deve ser ordenada e Arrays.sort()
	// lançaria uma excessão.

	@Test
	public void testSubVetorLeftMaiorQueRight2() {
		noSortTest(vetorGeral, 5, 1);
	}

	@Test
	public void testSubVetorLeftMenorQue0() {
		noSortTest(vetorGeral, -1, 1);
	}

	@Test
	public void testSubVetorLeftMenorQue0_2() {
		noSortTest(vetorGeral, -4, 1);
	}

	@Test
	public void testSubVetorRightMaiorQueLengthArrayMenos1_2() {
		noSortTest(vetorGeral, 1, vetorGeral.length + 5);
	}

}