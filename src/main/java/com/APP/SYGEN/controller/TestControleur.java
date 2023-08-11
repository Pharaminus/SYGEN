package com.APP.SYGEN.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.simple.PDFRenderer;

import com.APP.SYGEN.model.Datapv;
import com.APP.SYGEN.model.Etudiant;
import com.APP.SYGEN.model.Evaluation;
import com.APP.SYGEN.model.FilNiv;
import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.model.UE;
import com.APP.SYGEN.repository.EtudiantRepository;
import com.APP.SYGEN.repository.EvaluationRepository;
import com.APP.SYGEN.repository.ParticipeRepository;
import com.APP.SYGEN.repository.UeRepository;
import com.APP.SYGEN.service.EtudiantService;
import com.APP.SYGEN.service.FilNivService;
import com.APP.SYGEN.service.ParticipeService;
import com.itextpdf.text.Document;
// import com.itextpdf.text.PageSize;
// import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
// import com.lowagie.text.DocumentException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;

import jakarta.servlet.ServletOutputStream;





@RestController
@RequestMapping(path = "api")
public class TestControleur {

    @Autowired
    private ParticipeService participeService;

    @Autowired
    private ParticipeRepository participeRepository;
    @Autowired 
    EtudiantService etudiantService;
    @Autowired
    private FilNivService filNivService;
    @Autowired
    private UeRepository ueRepository;
    @Autowired
    private EvaluationRepository evaluationRepository;

    
    @PostMapping(path = "testcc")
    public String testShow(jakarta.servlet.http.HttpServletResponse response, @ModelAttribute("data") Datapv data){
        Datapv datapv = new Datapv();
        Evaluation evaluation1 = new Evaluation();
        List<Evaluation> evaluation = new ArrayList<Evaluation>();
        evaluation = evaluationRepository.findByTypeEval(data.getTypePv());
        String htmlCorp = "";
        List<Participe> participes = participeService.getParticipeUe("cc", Integer.parseInt(data.getSemestre()), data.getAnnee(), data.getUe());
        if(participes.isEmpty() == false){    
            for(int i = 0; i < participes.size(); i++){
                htmlCorp = htmlCorp + "<tr>";
                htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participes.get(i).getMatricule()+"</td>";
                htmlCorp = htmlCorp + "<td>"+ participes.get(i).getNomEtudiant() +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participes.get(i).getNote() +"</td>";
                if(etudiantService.geEtudiantByMatricule(participes.get(i).getMatricule()).isEmpty())
                    htmlCorp = htmlCorp + "<td>"+"Etudiant non autoris\u00E9" +"</td>";
                else
                    htmlCorp = htmlCorp + "<td>"+"ok" +"</td>";
                htmlCorp = htmlCorp + "</tr>";

            }
            try{
            response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=cc.pdf");
            try (ServletOutputStream outputStream = response.getOutputStream()) {
                ITextRenderer renderer = new ITextRenderer();
                renderer.setDocumentFromString(datapv.cCpdfContent(htmlCorp, data.getFiliere(), evaluation.get(0)));
                // renderer.setDocument(new File("index.html"));
                renderer.layout();
                renderer.createPDF(outputStream);
                
                // Flush and close the output stream
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Document builds with sucess!!!";
        }
        else{
            return "Document not founded";

        }
        
        

    }
    
    @PostMapping(path = "test2")
    public String testfunction(jakarta.servlet.http.HttpServletResponse response) throws DocumentException{
        String Dec = "";
        float total = 0;
        List<Participe> participesCc = participeService.getParticipeUe("cc", 1, LocalDate.parse("2023-08-09") , "INF-232");
        List<Participe> participesTp = participeService.getParticipeUe("tp", 1, LocalDate.parse("2023-08-05"), "INF-232");
        List<Participe> participesSn = participeService.getParticipeUe("sn", 1, LocalDate.parse("2023-08-29"), "INF-232");
        Datapv datapv = new Datapv();
        Evaluation evaluation = new Evaluation();
        String htmlCorp = "";
        List<Participe> participes = new ArrayList<Participe>();
        if(participesSn.isEmpty() == false){    
            for(int i = 0; i < participesSn.size(); i++){
                // if()
                total = participesCc.get(i).getNote() + participesSn.get(i).getNote() + participesTp.get(i).getNote();
                htmlCorp = htmlCorp + "<tr>";
                htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesSn.get(i).getMatricule()+"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesSn.get(i).getNomEtudiant() +"</td>";
                htmlCorp = htmlCorp + "<td>"+ "INF-L3" +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesCc.get(i).getAnonymat() +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesCc.get(i).getNote() +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesSn.get(i).getAnonymat() +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesSn.get(i).getNote() +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesTp.get(i).getAnonymat() +"</td>";
                htmlCorp = htmlCorp + "<td>"+ participesTp.get(i).getNote() +"</td>";
                             
                
                if(total <35)
                    Dec = "NC";
                if(total >35 && total < 50)
                    Dec = "CANT";
                if(total > 50)
                    Dec = "CA";
                htmlCorp = htmlCorp + "<td>"+ total  +"</td>";
                htmlCorp = htmlCorp + "<td>"+ Dec +"</td>";
                htmlCorp = htmlCorp + "<td>"+ mention(total) +"</td>";


                // if(etudiantService.geEtudiantByMatricule(participes.get(i).getMatricule()).isEmpty())
                //     htmlCorp = htmlCorp + "<td>"+"Etudiant non autoris\u00E9" +"</td>";
                // else
                //     htmlCorp = htmlCorp + "<td>"+"ok" +"</td>";
                htmlCorp = htmlCorp + "</tr>";

            }
            try{
            response.setContentType("application/pdf");
                response.setHeader("Content-Disposition", "attachment; filename=cc.pdf");
            try (ServletOutputStream outputStream = response.getOutputStream()) {
                ITextRenderer renderer = new ITextRenderer();
                renderer.setDocumentFromString(datapv.uEpdfContent(htmlCorp, "INFI-L1", evaluation));
                Document document = new Document();
                document.setPageSize(PageSize.A4.rotate());
                renderer.layout();
                renderer.createPDF(outputStream);
                // renderer.getSharedContext().setPdfREndererPreferences(PDFRendererPreferences.PDFRendererPreferencesImpl.createCustomPageSize(0,0,orientation.equalsIgnoreCase("")))
                // renderer.setDocumentOrientation(ITextRenderer.Orientation.LANDSCAPE);
                
                // Flush and close the output stream
                outputStream.flush();
                outputStream.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "Document builds with sucess!!!";
        }
        else{
            return "Document not founded";

        }        




        // return participesSn.get(0).getMatricule() +" "+ participesTp.get(0).getNomEtudiant() +" "+ participesCc.get(0).getNote();
        // return participesTp.get(0).getNomEtudiant()+"";
    }


    public String mention(float note){
        String mention = "";
        if(note < 30)
            mention = "F";
        else if(note >= 30 && note < 35)
            mention = "E";
        else if(note >= 35 && note < 39)
            mention = "D";
        else if(note >= 40 && note < 44)
            mention = "D+";
        else if(note >= 45 && note < 49)
            mention = "C-";
        else if(note >= 50 && note < 54)
            mention = "C";
        else if(note >= 55 && note < 59)
            mention = "C+";
        else if(note >= 60 && note < 64)
            mention = "B-";
        else if(note >= 65 && note < 69)
            mention = "B";
        else if(note >= 70 && note < 74)
            mention = "B+";
        else if(note >= 75 && note < 79)
            mention = "A-";
        else if(note >= 80)
            mention = "A";    
        return mention;    
    
}

    @PostMapping(path = "testVue1")
    public String testVue1(@ModelAttribute("data") Datapv data){
        String codeUe = "INF-232";
       List<UE> ue = ueRepository.findByCodeUE(codeUe);
       Evaluation evaluation = new Evaluation(LocalDate.parse("2023-03-23"), 18,"SN" , 1, ue.get(0));
       evaluationRepository.save(evaluation); 
       return "ok";
        
    }

    @PostMapping(path = "printPdf")
    public String printPdf(jakarta.servlet.http.HttpServletResponse response,@ModelAttribute("data") Datapv data){
        
    return "controller is ok";

    }

    @PostMapping(path = "testVue")
    public String testVue(@ModelAttribute("data") Datapv data){
        List<Participe> participes = participeService.getParticipeUe("tp", Integer.parseInt(data.getSemestre()), data.getAnnee(), data.getUe());
       
       return participes.size()+"";
        
    }

    // public List<Integer> VerifieStudent(String matricule){
    //     List<Integer> statusEval = new ArrayList<Integer>();
    //     List<Participe> participesSn = participeService.getParticipeUe("sn", 1, LocalDate.parse("2023-08-29"), "INF-232");
    //     List<Etudiant> etudiants = etudiantService.getAllEtudiant();
    //     for (Participe participant : participesSn) {
    //         if(etudiantService.geEtudiantByMatricule(matricule).get(0).getStatutPaie() == 50000){
    //             statusEval.get(0).intValue() = 1;
    //         }
    //     }
    //     return statusEval;
    // }

}
    
    

   
    

