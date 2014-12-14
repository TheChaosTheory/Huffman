
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
public class Huffman<T> {


	private ArraySortedList<T> include;
	protected int[] count;
	protected String inputFile;
	protected String[] value;
	protected HuffmanNode root;
	protected String code[];


	public Huffman(ArraySortedList<HuffmanNode> sorted){
		include = (ArraySortedList<T>) sorted;
		run();
		this.toString();
		code = new String[26];
		buildCode(code, root,"");
	}
	
	public String freqCount(){
		if(include == null)return "NULL";
		else{
			String output ="Huffman Code Table: \n";
			
			for(int i = 0; i < 26;i++){
				char alph = (char) (i + 65);
				int freq = count[i];
				String num = "00000"+ freq;
				String end = num.substring(num.length()-5);
				output += end + "\n";
			}
			return output;
		}
	}
	
	public void run(){
		while(true){
			include.reset();
			if(include.size() == 1){
				include.reset();
				root = (HuffmanNode) include.getNext();
				break;
			}
			HuffmanNode one = (HuffmanNode) include.dequeue();
			HuffmanNode two = (HuffmanNode) include.dequeue();
			int total = one.getFrequency() + two.getFrequency();
			char c = 65 + 26;
			@SuppressWarnings({ "rawtypes", "unused" })
			HuffmanNode nNode = new HuffmanNode(c,total,two,one);
			include.add(nNode);
			
		}
	}
	
/*	public  void read(String s){
		if(s == null)return;
		else{
			Scanner temp = new Scanner(s);
			count = new int[26];

			while(temp.hasNext()){
				String tString = temp.next();
				for(int i = 0; i < tString.length();i++){
					char x = tString.charAt(i);
					int loc = x - 65;
					count[x]++;
				}
			}
			for(int i = 0;i<26;i++){
				if(count[i]>0)
				include.enqueue(new HuffmanNode((char) (i+65),count[i]));
			}
		}
		
	}*/
	
	public String findCode(char c){
		String output = code[c-65];
		return output;
	}

	private static void buildCode(String[] st, HuffmanNode x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.getLeftChild(),  s + '1');
            buildCode(st, x.getRightChild(), s + '0');
        }
        else {
            st[x.getLetter()-65] = s;
        }
    }
}