package Printer;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FilePrinter {

	public static void main(String args[])
	{
		FilePrinter fp=new FilePrinter();
		String path = System.getProperty("user.dir")+"//src//wordfile.txt";
		System.out.println(path);
		fp.doesFileExist(path);
	}
	
	private void doesFileExist(String path)
	{
		try {
			List<String> allLines = Files.readAllLines(Paths.get(path),Charset.defaultCharset());
			for(String line : allLines)
			{
				String[] liner = line.split("–");
				if(liner[0].length()>0)
				{
					//Print Word
					System.out.println(liner[0]);					
				}
				
				if(liner.length>1)
				{
					String[] meaning = liner[1].split(",");
					//Print meanings
					for(String item : meaning)
					{
						System.out.println(item.trim());
					}
				}
			}
					
		}catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
