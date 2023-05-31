package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		Integer saida = null;
		Integer floor = floorRec(getRoot(), numero);
		if (floor != null) {
			saida = floor;
		}
		return saida;
	}

	private Integer floorRec(BSTNode<Integer> node, double numero) {
		Integer result;
		if (node.getData() == null) {
			result = null;
		} else if (numero == node.getData()) {
			result = node.getData();

		} else if (numero < node.getData()) {
			result = floorRec((BSTNode<Integer>) node.getLeft(), numero);
		} else {
			Integer valor = floorRec((BSTNode<Integer>) node.getRight(), numero);
			if (valor != null) {
				result = valor;
			} else {
				result = node.getData();
			}
		}
		return result;
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		Integer saida = null;
		Integer ceil = ceilRec(getRoot(), numero);
		if (ceil != null) {
			saida = ceil;
		}
		return saida;
	}

	private Integer ceilRec(BSTNode<Integer> node, double numero) {
		Integer result;
		if (node.getData() == null) {
			result = null;
		} else if (numero == node.getData()) {
			result = node.getData();

		} else if (numero > node.getData()) {
			result = ceilRec((BSTNode<Integer>) node.getRight(), numero);
		} else {
			Integer valor = ceilRec((BSTNode<Integer>) node.getLeft(), numero);
			if (valor != null) {
				result = valor;
			} else {
				result = node.getData();
			}
		}
		return result;
	}

}
