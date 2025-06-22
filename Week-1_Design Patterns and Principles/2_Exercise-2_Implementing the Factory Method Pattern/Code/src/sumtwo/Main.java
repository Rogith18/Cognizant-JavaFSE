package sumtwo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordDocumentFactory wordFactory=new WordDocumentFactory();
		WordDocument wordDoc = wordFactory.createDocument();
	    wordDoc.openWord();
	    
	    PdfDocumentFactory pdfFactory = new PdfDocumentFactory();
	    PdfDocument pdfDoc = pdfFactory.createDocument();
	    pdfDoc.openPdf();
	      
	    ExcelDocumentFactory excelFactory = new ExcelDocumentFactory();
	    ExcelDocument excelDoc = excelFactory.createDocument();
	    excelDoc.openExcel();

	}

}
