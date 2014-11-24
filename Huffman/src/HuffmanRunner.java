import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class HuffmanRunner
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.err.println("Error: must include input filename!");
			System.exit(-1);
		}
		String filename = args[0];
		File file = new File(filename);

		FrequencyList fl = buildFrequencyList(file);

		ArraySortedList<HuffmanNode> sorted = fl.getFrequencyList();

		Huffman huffman = new Huffman(sorted);

		printTable(sorted, huffman);

		System.out.println();

		compressFile(file, huffman);
	}

	private static FrequencyList buildFrequencyList(File file)
	{
		FrequencyList fl = new FrequencyList();
		
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
					fl.add(c); // Add to the Frequency List
				}
				data = reader.read();
			}
			reader.close();
		} 
		catch (java.io.FileNotFoundException e) 
		{
			System.err.println("Error: File \"" + file + "\" not found!");
			System.exit(-1);
		}
		catch (java.io.IOException e)
		{
			System.err.println("Error reading file \"" + file + "\"!");
			System.exit(-1);
		}
		return fl;
	}

	private static void printTable(ArraySortedList<HuffmanNode> sorted, Huffman huffman)
	{
		System.out.println("Huffman Code Table:");
		sorted.reset();
		for (int i = sorted.size(); i > 0; i--)
		{
			HuffmanNode cf = sorted.getNext();
			System.out.println(cf.getLetter() + ": " + huffman.findCode(cf.getLetter()));
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
