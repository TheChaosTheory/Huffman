import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
public class Huffman {


	private ArrayUnbndSortedQueue include;
	protected int[] count;
	protected String inputFile;
	protected String[] value;
	protected HuffmanNode root;


	public Huffman(ArraySortedList<HuffmanNode> sorted){
		Scanner s = new Scanner(System.in);
		inputFile = s.nextLine();
		read(inputFile);
		if(include == null)return;
		else{

		}
		this.toString();
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
			HuffmanNode one = (HuffmanNode) include.dequeue();
			if(include.isEmpty()){
				include.enqueue(one);
				root = one;
				break;
			}
			HuffmanNode two = (HuffmanNode) include.dequeue();
			int total = one.getFrequency() + two.getFrequency();
			char c = one.getLetter();
			HuffmanNode nNode = new HuffmanNode(c,total,one,two);
			
		}
	}
	
	



	public  void read(String s){
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
		
	}


	public String findCode(char c) {
		
		return null;
	}
}