package CountWord;

import java.io.FileInputStream;

import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.hwpf.HWPFDocument;

public class Test {
	public static void main(String args[]){
		String fileWord = "src/convit.doc";
		String bodyText="";
		
		boolean isFileDocx = isFileDocx("docx");
		boolean isFileDoc = isFileDocx("doc");
		
		try (FileInputStream fs = new FileInputStream(fileWord)) {
			if (isFileDocx) {
//				XWPFDocument file = new XWPFDocument(OPCPackage.open(fs));
				XWPFDocument file = new XWPFDocument(fs);
				XWPFWordExtractor ext = new XWPFWordExtractor(file);  
				
				bodyText = ext.getText();
			} else if (isFileDoc){
				HWPFDocument doc = new HWPFDocument(fs);
	            WordExtractor ext = new WordExtractor(doc);	

	            bodyText = ext.getText();
			} else {
//				throw 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	
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
}
