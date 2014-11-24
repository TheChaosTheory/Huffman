
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//----------------------------------------------------------------------------
// FrequencyList.java            by Dale/Joyce/Weems                 Chapter 8
//
// Displays a word frequency list of the words listed in the input file.
// Prompts user for minSize and minFreq.
// Does not process words less than minSize in length.
// Does not output words unless their frequency is at least minFreq.
//----------------------------------------------------------------------------

public class FrequencyList
{
	private ArraySortedList list;
	
	public FrequencyList(File fl) throws FileNotFoundException{
		list = new ArraySortedList();
		list = sort(fl);
	}

	public FrequencyList() {
		// TODO Auto-generated constructor stub
	}

	public ArraySortedList getFrequencyList() {
		return list;
	}

	public void add(char c) {
		// TODO Auto-generated method stub
		
	}
	
	private ArraySortedList sort(File fi) throws FileNotFoundException{
		if(fi == null)return null;
		else{
			ArraySortedList output = new ArraySortedList();
			int[] counter = new int[26];
			
			Scanner s = new Scanner(fi);
			while(s.hasNext()){
				String test = s.next();
				for(int i = 0; i < test.length();i++){
					Character t = test.charAt(i);
					t = t.toUpperCase(t);
					counter[t -65] += 1;
				}
			}
			for(int i = 0; i < 26; i++){
				char x = (char)(i + 65);
				int y = counter[i];
				output.add(new HuffmanNode(x,y));
			}
			return output;
		}
	}
} 