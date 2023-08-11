package com.APP.SYGEN.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
// // import java.io.File;
import java.util.List;

// // import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RequestParam;
// // import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.APP.SYGEN.model.Datapv;
import com.APP.SYGEN.model.Etudiant;
import com.APP.SYGEN.model.Evaluation;
import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.repository.EvaluationRepository;
import com.APP.SYGEN.service.EtudiantService;
import com.APP.SYGEN.service.ParticipeService;
import com.lowagie.text.DocumentException;

// // import com.APP.SYGEN.service.EtudiantService;
// // import com.APP.SYGEN.service.ParticipeService;

import jakarta.servlet.ServletOutputStream;

// // @RestController
@Controller
@RequestMapping(path = "production")
public class PdfGeneretorController {
    @Autowired
    private ParticipeService participeService;
    @Autowired
    private EvaluationRepository evaluationRepository;

    @Autowired
    private EtudiantService etudiantService;

    @PostMapping(path = "pvcc")
    public String testShow(jakarta.servlet.http.HttpServletResponse response, @ModelAttribute("data") Datapv data) throws DocumentException{
        Datapv datapv = new Datapv();
        String htmlTest =  "<!DOCTYPE html>\n" + //
                "<html lang=\"en\">\n" + //
                "<head>\n" + //
                "    <meta charset=\"UTF-8\">\n" + //
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" + //
                "    <title>Document</title>\n" + //
                "    \n" + //
                "</head>\n" + //
                "<body>\n" + //
                "    <h1>Hello world !!!</h1>\n" + //
                "</body>\n" + //
                "</html>";
        Evaluation evaluation1 = new Evaluation();
        List<Evaluation> evaluation = new ArrayList<Evaluation>();
        evaluation = evaluationRepository.findByTypeEval(data.getTypePv());
        String htmlCorp = "";
        List<Participe> participes = participeService.getParticipeUe("cc", Integer.parseInt(data.getSemestre()), data.getAnnee(), data.getUe());
        // if(participes.isEmpty() == false){    
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
        // }
        // else{
        //     return "Document not founded";

        // }
        
        

    }


    @GetMapping(path = "pageTest")
    public String pageTest(){
        return  "index";
    }

    @GetMapping(path = "pageTest2")
    public String pageTest2(){
        return  "printPdf";
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
