


public class HuffmanNode implements Comparable{

	char letter;
	int frequency;
	HuffmanNode leftChild;
	HuffmanNode rightChild;

	public HuffmanNode(char newLetter, int newFrequency){
		letter = newLetter;
		frequency = newFrequency;
	}

	public HuffmanNode(char newLetter, int newFrequency, HuffmanNode newLeftChild, HuffmanNode newRightChild){
		letter = newLetter;
		frequency = newFrequency;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}

	public char getLetter(){
		return letter;
	}

	public int getFrequency(){
		return frequency;
	}

	public HuffmanNode getLeftChild(){
		return leftChild;
	}

	public HuffmanNode getRightChild(){
		return rightChild;
	}

	public int compareTo(Object y) {
		HuffmanNode x = (HuffmanNode)y;
		if (x.getFrequency() < getFrequency()){
			return -1;
		}
		else if (x.getFrequency() > getFrequency()){
			return 1;
		}
		else if (x.getFrequency() == getFrequency()){
			if (x.getLetter() < getLetter()){
				return -1;
			}
			else if (x.getLetter() > getLetter()){
				return 1;
			}
			else if (x.getLetter() == getLetter()){
					return 0;
			}
		}
		return 0;
	}



}
