import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;


//Made By Tom Lazar, Chris Mueller, and Brian ZHU
public class HuffmanRunner
{
	public static void main(String[] args) throws FileNotFoundException
	{
		
		Scanner s = new Scanner(System.in);
		//String filename = s.nextLine();
		File file = new File("/home/tom/Desktop/ex1");

		FrequencyList fl = new FrequencyList(file);

		ArraySortedList<HuffmanNode> sorted = fl.getFrequencyList();
		
		ArraySortedList<HuffmanNode> sorted2 = new ArraySortedList();
		
		for(int i = 0; i < sorted.size();i++){
			sorted2.add(sorted.getNext());
		}

		Huffman huffman = new Huffman(sorted2);

		printTable(sorted, huffman);

		System.out.println();

		compressFile(file, huffman);
	}

	private static void printTable(ArraySortedList<HuffmanNode> sorted, Huffman huffman)
	{
		System.out.println("Huffman Code Table:");
		sorted.reset();
		for (int i = sorted.size(); i > 0; i--)
		{
			HuffmanNode cf = sorted.getNext();
			System.out.println(cf + ": " + huffman.findCode(cf.getLetter()));
		}
	}

	private static void compressFile(File file, Huffman huffman)
	{
		int totalBits = 0;
		int compressedBits = 0;

		System.out.println("Compressed File Contents:");

		try {
			FileReader reader = new FileReader(file);

			int data = reader.read();
			char c;
			while (data != -1) // While there are characters in the file
			{
				c = (char)data;
				if (Character.isLetter(c))
				{
					c = Character.toUpperCase(c);
					String code = huffman.findCode(c);
					System.out.println(c + ": " + code);
					totalBits += 8;
					compressedBits += code.length();
				}
				data = reader.read();
			}
			reader.close();
		} 
		catch (java.io.IOException e)
		{
			System.err.println("Error reading file \"" + file + "\"!");
			System.exit(-1);
		}

		System.out.println();
		System.out.println("Compressed " + totalBits + " bits into " 
						   + compressedBits + " bits.");
		System.out.println("Compression rate " 
						   + ((totalBits - compressedBits) * 100 / totalBits) 
						   + "%");
	}
}
