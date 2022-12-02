package com.pi.Plataforma.Integral.service.implement;


import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.pi.Plataforma.Integral.dao.IDonacionDao;
import com.pi.Plataforma.Integral.dao.IDonanteDao;
import com.pi.Plataforma.Integral.dao.IEventoDao;
import com.pi.Plataforma.Integral.dao.IUssuriooooDao;
import com.pi.Plataforma.Integral.models.Donacion;
import com.pi.Plataforma.Integral.models.Evento;
import com.pi.Plataforma.Integral.models.Ussurioooo;
import com.pi.Plataforma.Integral.service.IDonacionService;
import com.pi.Plataforma.Integral.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
@Transactional
@Service
public class DonacionServiceImpl implements IDonacionService {

    @Autowired
    private IDonacionDao donacionDao;

    @Autowired
    private IUssuriooooDao ussuriooooDao;

    public DonacionServiceImpl(){}

    @Override
    @Transactional
    public Donacion save(Donacion donacion) {
        Donacion donacion1=new Donacion();
        donacion1.setTipo_donacion(donacion.getTipo_donacion());
        donacion1.setFecha_registro(donacion.getFecha_registro());
        donacion1.setStock(donacion.getStock());
        donacion1.setFecha_act(donacion.getFecha_act());
        donacion1.setValidado(donacion.isValidado());
        donacion1.setStatus(donacion.isStatus());
        donacion1 = donacionDao.save(donacion1);
        try {
            donacionDao.updateAllRelations(
                    donacion1.getId(), donacion.getUssurioooo().getId());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return donacionDao.getById(donacion1.getId());
    }

    @Override
    public Donacion update(Donacion donacion) {
        return null;
    }

    @Override
    public void delete(Long id) {
        donacionDao.deleteDonacion(id);

    }

    @Override
    public List<Donacion> get() {
        System.out.println(donacionDao.findAll());
        return donacionDao.findAll();
    }

    @Override
    public List<Donacion> getAll() {
        return donacionDao.findAll();
    }

    @Override
    public List<Ussurioooo> getUssurioooo() {
        return donacionDao.getUssurioooo();
    }

    @Override
    public String generatePdf(Long id) throws IOException, DocumentException {
        String pathFile = Constants.DIRECTORIO_UPLOAD + "/pdf/estado_cuenta_" + id + ".pdf";
        File temp = new File(pathFile);
        temp.getParentFile().mkdir();
        createPdf(temp.getPath(), id);
        return pathFile;
    }

    private void createPdf(String path, Long id) throws IOException, DocumentException{
        Donacion donacion = donacionDao.getById(id);
        Document document = new Document(PageSize.A4, 0, 0, 10, 10);
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(path));
        document.open();

        BaseFont typeDynamic = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);

        Font titleBlackBold = new Font(typeDynamic, 8, Font.BOLD, BaseColor.BLACK);
        Font blackBold = new Font(typeDynamic, 6, Font.BOLDITALIC, BaseColor.BLACK);
        Font black = new Font(typeDynamic, 6, Font.NORMAL, BaseColor.BLACK);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        PdfPTable tableDatos = new PdfPTable(new float[]{1, 1, 1, 1, 1, 1});

        PdfPCell titleRow = new PdfPCell(new Phrase("ESTATUS DONACION " + donacion.getUssurioooo().getNombre().toUpperCase(), titleBlackBold));
        titleRow.setColspan(6);
        titleRow.setHorizontalAlignment(Element.ALIGN_CENTER);
        titleRow.setBackgroundColor(new BaseColor(255, 217, 101));
        tableDatos.addCell(titleRow);

        //Row 1
        PdfPCell donanteCell = new PdfPCell(new Phrase("Donante", blackBold));
        tableDatos.addCell(donanteCell);

        PdfPCell donanteValueCell = new PdfPCell(new Phrase(donacion.getUssurioooo().getNombre(), black));
        donanteValueCell.setColspan(2);
        tableDatos.addCell(donanteValueCell);

        PdfPCell fechaCell = new PdfPCell(new Phrase("Fecha", blackBold));
        tableDatos.addCell(fechaCell);

        PdfPCell fechaCellValue = new PdfPCell(new Phrase(dateFormat.format(donacion.getFecha_registro()), black));
        fechaCellValue.setColspan(2);
        tableDatos.addCell(fechaCellValue);

        Image imgBanner = Image.getInstance(Constants.DIRECTORIO_UPLOAD + "/header_pdf.jpg");
        imgBanner.setAlignment(Element.ALIGN_CENTER);
        imgBanner.scaleAbsoluteWidth(400);
        imgBanner.scaleAbsoluteHeight(79);

        document.add(imgBanner);

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));

        document.add(tableDatos);

        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
    }
}
