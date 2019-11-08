package CountWord;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class Model {
	private String result="";
	private String text="";
	private String REGEX = "[^\\p{L}\\d-_À-ž\\u0300-\\u036F]+[-_]*[^\\p{L}\\d-_À-ž\\u0300-\\u036F]*";

	@SuppressWarnings("resource")
	public void countWord(File file) throws IOException {
		text = "";
		Scanner scan = null;
		String lineText;
		String word;
		String[] words;
		int countAll = 0;
		
		String filePath = file.getAbsolutePath();
		
		if (!isFileDoc(filePath) && !isFileDocx(filePath)) {
			throw new IllegalArgumentException("Not file doc or docx");
		}
		
		String bodyText = getFileBodyText(file);
		System.out.println(bodyText);
				
		TreeMap<String, Integer> wordList = new TreeMap<>();
		scan = new Scanner((bodyText));
		while (scan.hasNext()) {
			lineText = scan.nextLine();
			text += lineText+"\n";
			System.out.println("\n\n" + lineText);
			words = lineText.split(REGEX);
			countAll += words.length;
			for (int i = 0; i < words.length; i++) {
				word = words[i].toLowerCase();
				if (word.length() > 0) {
					Integer count = wordList.get(word);
					if (count != null)
						wordList.put(word, count + 1);
					else
						wordList.put(word, 1);
				} else {
					countAll--;
				}
			}

		}
		result = "<div style='font-size: 18px'>Total word: " + countAll + "</div>\n" + "<p style='font-size: 18px'>Word list: </p>\n";
		result += "<table style='border: 1px black solid; background-color: black; font-size: 18px' width='100%' cellspacing='1' cellpadding='2'>";
		for (String wordKey: wordList.keySet()){
			result += "<tr>";
			result += "<td style='background-color: white'>" + wordKey+"</td><td style='background-color: white'>"+wordList.get(wordKey)+"</td>";
			result += "</tr>\n";
		}
		result += "</table>";
		System.out.println(result);
	}
	
	public String getResult(){
		return result;
	}
	public String getText(){
		return text;
	}
	
	private static String getFileExtension(String filePath) {
		String extension="";
		
		int i = filePath.lastIndexOf('.');
		int p = Math.max(filePath.lastIndexOf('/'), filePath.lastIndexOf('\\'));

		if (i > p) {
		    extension = filePath.substring(i+1);
		}
		
		return extension;
	}

	private static boolean isFileDocx(String filePath) {
		String extension = getFileExtension(filePath);
		return extension.equals("docx");
	}
	
	private static boolean isFileDoc(String filePath) {
		String extension = getFileExtension(filePath);
		return extension.equals("doc");
	}
	
	@SuppressWarnings("resource")
	private String getFileBodyText(File file) {
		String bodyText = "";
		String filePath = file.getAbsolutePath();
		
		boolean isFileDocx = isFileDocx(filePath);
		boolean isFileDoc = isFileDoc(filePath);
		
		try (FileInputStream fis = new FileInputStream(file)) {
			if (isFileDocx) {
//				XWPFDocument file = new XWPFDocument(OPCPackage.open(fs));
				XWPFDocument fileDocx = new XWPFDocument(fis);
				XWPFWordExtractor ext = new XWPFWordExtractor(fileDocx);  
				
				bodyText = ext.getText();
			} else if (isFileDoc){
				System.out.println("reading file doc :<");
				
				HWPFDocument fileDoc = new HWPFDocument(fis);
	            WordExtractor ext = new WordExtractor(fileDoc);	

	            bodyText = ext.getText();
			} else {
//				throw 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return bodyText;
	}
}
