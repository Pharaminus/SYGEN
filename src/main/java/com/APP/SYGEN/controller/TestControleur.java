package com.APP.SYGEN.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.APP.SYGEN.model.Datapv;
import com.APP.SYGEN.model.Etudiant;
import com.APP.SYGEN.model.Evaluation;
import com.APP.SYGEN.model.FilNiv;
import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.repository.ParticipeRepository;
import com.APP.SYGEN.service.EtudiantService;
import com.APP.SYGEN.service.FilNivService;
import com.APP.SYGEN.service.ParticipeService;
import com.lowagie.text.DocumentException;

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
    
    
    @GetMapping(path = "test")
    public String testShow(jakarta.servlet.http.HttpServletResponse response){
        Datapv datapv = new Datapv();
        Evaluation evaluation = new Evaluation();
        String htmlCorp = "";
        List<Participe> participes = participeService.getParticipeUe("cc", 2, LocalDate.parse("2023-08-01"), "INF-232");
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
                renderer.setDocumentFromString(datapv.cCpdfContent(htmlCorp, "INFI-L1", evaluation));
                // renderer.setDocument(new File("index.html"));
                renderer.layout();
                renderer.createPDF(outputStream);
                
                // Flush and close the output stream
                outputStream.flush();
                outputStream.close();
            } catch (DocumentException | IOException e) {
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
    
    @GetMapping(path = "test2")
    public String testfunction(jakarta.servlet.http.HttpServletResponse response){
        String Dec = "";
        float total = 0;
        List<Participe> participesCc = participeService.getParticipeUe("cc", 1, LocalDate.parse("2023-08-09") , "INF-152");
        List<Participe> participesTp = participeService.getParticipeUe("tp", 1, LocalDate.parse("2023-08-10"), "INF-152");
        List<Participe> participesSn = participeService.getParticipeUe("sn", 1, LocalDate.parse("2023-08-29"), "INF-152");
        Datapv datapv = new Datapv();
        Evaluation evaluation = new Evaluation();
        String htmlCorp = "";
        List<Participe> participes = participeService.getParticipeUe("cc", 2, LocalDate.parse("2023-08-01"), "INF-232");
        if(participesSn.isEmpty() == false){    
            for(int i = 0; i < participesSn.size(); i++){
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
                // htmlCorp = htmlCorp + "<td>"+ i+"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";                
                // htmlCorp = htmlCorp + "<td>"+ i +"</td>";                
                
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
                // renderer.setDocument(new File("index.html"));
                renderer.layout();
                renderer.createPDF(outputStream);
                
                // Flush and close the output stream
                outputStream.flush();
                outputStream.close();
            } catch (DocumentException | IOException e) {
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
}
    
    

   
    

