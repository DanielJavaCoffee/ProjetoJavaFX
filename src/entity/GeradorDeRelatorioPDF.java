package entity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeradorDeRelatorioPDF {

	public static void geradorDePDFCliente(ArrayList<Cliente> cliente) {

		Document documento = new Document(PageSize.A4);
		try {

			OutputStream outputStream = new FileOutputStream("Cliente.PDF");
			PdfWriter.getInstance(documento, outputStream);
			documento.open();
			Paragraph paragraph = new Paragraph("Clientes.PDF");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			documento.add(paragraph);
			for (int i = 0; i < cliente.size(); i++) {
				Paragraph paragraph2 = new Paragraph("\n" + cliente.get(i).toString());
				documento.add(paragraph2);
			}
			documento.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void GeradorDePDFProduto(ArrayList<Produto> produto) {

		Document documento = new Document(PageSize.A4);
		try {

			OutputStream outputStream = new FileOutputStream("Produto.PDF");
			PdfWriter.getInstance(documento, outputStream);
			documento.open();
			Paragraph paragraph = new Paragraph("Produtos.PDF");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			documento.add(paragraph);
			for (int i = 0; i < produto.size(); i++) {
				Paragraph paragraph2 = new Paragraph("\n" + produto.get(i).toString());
				documento.add(paragraph2);
			}
			documento.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
	
	public static void geradorDePDFServico(ArrayList<Servicos> servicos) {
		
		Document documento = new Document(PageSize.A4);
		try {

			OutputStream outputStream = new FileOutputStream("Servico.PDF");
			PdfWriter.getInstance(documento, outputStream);
			documento.open();
			Paragraph paragraph = new Paragraph("Servicos.PDF");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			documento.add(paragraph);
			for (int i = 0; i < servicos.size(); i++) {
				Paragraph paragraph2 = new Paragraph("\n" + servicos.get(i).toString());
				documento.add(paragraph2);
			}
			documento.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void GeradorDePDFOrcamento(ArrayList<Orcamento> orcamentos) {

		Document documento = new Document(PageSize.A4);
		try {

			OutputStream outputStream = new FileOutputStream("Orcamento.PDF");
			PdfWriter.getInstance(documento, outputStream);
			documento.open();
			Paragraph paragraph = new Paragraph("Orcamentos.PDF");
			paragraph.setAlignment(Element.ALIGN_CENTER);
			documento.add(paragraph);
			for (int i = 0; i < orcamentos.size(); i++) {
				Paragraph paragraph2 = new Paragraph("\n" + orcamentos.get(i).toString());
				documento.add(paragraph2);
			}
			documento.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	}
}
