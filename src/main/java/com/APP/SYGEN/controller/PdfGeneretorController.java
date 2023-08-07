package com.APP.SYGEN.controller;

import java.io.File;
import java.util.List;

import org.apache.catalina.util.ToStringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.APP.SYGEN.model.Datapv;
import com.APP.SYGEN.model.Participe;
import com.APP.SYGEN.service.ParticipeService;

// import com.APP.SYGEN.service.EtudiantService;
// import com.APP.SYGEN.service.ParticipeService;

import jakarta.servlet.ServletOutputStream;

// @RestController
@Controller
@RequestMapping(path = "production")
public class PdfGeneretorController {
    @Autowired
    private ParticipeService participeService;

    @PostMapping(path = "pvcc")
     public void generatePdf(jakarta.servlet.http.HttpServletResponse response, @ModelAttribute("data") Datapv data) {
       List<Participe> participe;
       participe = participeService.getAllParticipe();

        try {
            // String html = "<html><body><h1>Pv CC Good Test</h1> <table style='border:solid black 3px;'><tr><td>Nom </td> <td>Prenom </td> <td>Matricule </td></tr> <tr><td>Balekamen Babatack </td> <td>Landry </td> <td>21T2660 </td></tr></table> </body></html>";
            String htmlcorp = "";
            for(int i = 0; i < participe.size(); i++){
                String type = "cc";
                if(participe.get(i).getEvaluation().getTypeEval().equalsIgnoreCase(type))
                    htmlcorp = htmlcorp + "<tr id='head-pv'><td>"+i+" </td><td>"+ participe.get(i).getMatricule()+"</td><td>"+participe.get(i).getNomEtudiant()+"</td><td>"+participe.get(i).getNote()+"</td><td>Ok</td></tr>";
            }

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=cc.pdf");
           
            String htmlTest = "\n" + //
                    "<html>\n" + //
                    "\n" + //
                    "<head style='background-color:yellow;'>\n" + //
                    " \n" + //
                    "    <title>Document</title>\n" + //
                    "    <style>\n" + //
                    // "        @page{margin-top:0cm; margin-bottom:0cm; margin-left:0cm; margin-rigth:0cm;\n" + //
                    "        main {\n" + //

                    "            margin: 0;\n" + //
                    "            padding: 0;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #block-info {\n" + //
                    // "            display: flex;\n" + //
                    // "            flex-direction: column;\n" + //
                    "            width: 100%;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        header {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        table {\n" + //
                    "            border-collapse: collapse;\n" + //
                    "            font-weight: bold;\n" + //
                    // "            margin-left: 15%;\n" + //
                    "            width:100%;\n" + //

                    "        }\n" + //
                    "\n" + //
                    "        td {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        table,\n" + //
                    "        td {\n" + //
                    "            border: solid 2px rgb(2, 142, 152);\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #head-pv {\n" + //
                    "            font-size: 18px;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #info-pv {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    // "\n" + //
                    "        .info-uv {\n" + //
                    "            text-align: center;\n" + //
                    "            display:inline-block;\n"+//            
                    // "            border:solid 3px blue;\n"+//                  
                    // "            color:blue;\n"+//

                    "            width: 40%;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #logo-uv {\n" + //
                    "            width: 30%;\n" + //
                    "            display:inline-block;\n"+//            

                    "        }\n" + //
                    "    </style>\n" + //
                    "</head>\n" + //
                    "\n" + //
                    "<body style='margin-top:0px; padding-top:0px; '>\n" + //
                    // "    <header>\n" + //
                    // "        <h1> SYGEN </h1>\n" + //
                    // "    </header>\n" + //
                    "    <main>\n" + //
                    "        <div id=\"block-info\" style='margin:0; padding:0;'>\n" + //
                    "            <div class=\"info-uv\" style='margin-left:-2px;'>\n" + //
                    // "                <p>\n" + //
                    "                <h4 style='margin:8px;' >UNIVERSITE DE YAOUNDE I</h4>\n" + //
                    "                <h5 style='margin:8px;'>FACULTE DES SCIENCESFACULTE</h5>\n" + //
                    "                <h6 style='margin:8px;'> BP/P.O.Box 812 Yaound\u00E9-CAMEROUN /</h6>\n" + //
                    "                <h6 style='margin:8px;'> Tel : 222 234 496 / Email:</h6>\n" + //
                    "                <h6 style='margin:8px;'>diplome@facsciences.uy1.cm</h6>\n" + //
                    // "                </p>\n" + //
                    "            </div>\n" + //
                    // "            <div id=\"logo-uv\">\n" + //
                    // "\n" + //
                    // "            </div>\n" + //
                    "            <div class=\"info-uv\" style='margin-left:100px;'>\n" + //
                    // "                <p>\n" + //
                    "                <h4 style='margin:8px;'>UNIVERSITY OF YAOUNDE I</h4>\n" + //
                    "                <h5 style='margin:8px;'>FACULTE DES SCIENCES</h5>\n" + //
                    "                <h6 style='margin:8px;'>BP/P.O.Box 812 Yaound\u00E9-CAMEROUN /</h6>\n" + //
                    "                <h6 style='margin:8px;'>Tel : 222 234 496 / Email:</h6>\n" + //
                    "                <h6 style='margin:8px;'>diplome@facsciences.uy1.cm</h6>\n" + //
                    // "                </p>\n" + //
                    "            </div>\n" + //
                    "        </div>\n" + //
                    "        <div id=\"info-pv\">\n" + //
                    "            <h2 style='margin:3px;'>PROCES VERBAL DE L'UNITE D'ENSEIGNEMENT</h2>\n" + //
                    "            <h3 style='margin:3px;'>INF221-BASES DE DONNEES ET MODELISATION</h3>\n" + //
                    "            <h4 style='margin:3px;'>CONTROLE CONTINU ("+ data.getTypePv() +")</h4>\n" + //
                    "            <h5 style='margin:3px;'>FILIERE : INE - INFORMATIQUE</h5>\n" + //
                    "            <h5 style='margin:3px;'>SPECIALITE : -</h5>\n" + //
                    "        </div>\n" + //
                    "        <table>\n" + //
                    "            <tr id='head-pv'>\n" + //
                    "                <td>Num</td>\n" + //
                    "                <td> Matricul </td>\n" + //
                    "                <td> Nom et prenom </td>\n" + //
                    "                <td>Note </td>\n" + //
                    "                <td> Observation </td>\n" + //
                    "            </tr>\n" + //
                    htmlcorp+
                    "        </table>\n" + //
                    "    </main>\n" + //
                    "</body>\n" + //
                    "\n" + //
                    "</html>";
            
            
          
            
            ServletOutputStream outputStream = response.getOutputStream();

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlTest);
            // renderer.setDocument(new File("index.html"));
            renderer.layout();
            renderer.createPDF(outputStream);
            
            // Flush and close the output stream
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "pvue")
     public void generatePdfUe(jakarta.servlet.http.HttpServletResponse response) {
       List<Participe> participe ;
       participe = participeService.getAllParticipe();

        try {
            // String html = "<html><body><h1>Pv CC Good Test</h1> <table style='border:solid black 3px;'><tr><td>Nom </td> <td>Prenom </td> <td>Matricule </td></tr> <tr><td>Balekamen Babatack </td> <td>Landry </td> <td>21T2660 </td></tr></table> </body></html>";
            String htmlcorp = "";
            String type = "cc";
            String type2 = "sn";
            String type3 = "tp";
            float total = 0;
            
            String Dec = "";
            for(int i = 0; i < participe.size(); i++){
                Dec = participe.get(i).getEvaluation().getTypeEval().toString();
                // if(participe.get(i).getEvaluation().getTypeEval().equalsIgnoreCase(type))
                if(Dec+"" == "cc")
                    htmlcorp = htmlcorp + "<tr id='head-pv'><td>"+i+" </td><td>"+ participe.get(i).getMatricule()+"</td><td>"+participe.get(i).getNomEtudiant()+"</td><td>"+participe.get(i).getEtudiant().getFilNiv().getCode()+"</td><td>"+ participe.get(i).getAnonymat()+"</td><td>"+ participe.get(i).getNote()+"</td><td>";
                    total = total + participe.get(i).getNote();
                // }
                // if(participe.get(i).getEvaluation().getTypeEval().equalsIgnoreCase(type2)){
                    htmlcorp = htmlcorp + participe.get(i).getAnonymat()+"</td><td>"+ participe.get(i).getNote()+"</td><td>";
                //     total = total + participe.get(i).getNote();

                // }
                // if(participe.get(i).getEvaluation().getTypeEval().equalsIgnoreCase(type3)){
                    htmlcorp = htmlcorp + participe.get(i).getAnonymat()+"</td><td>"+ participe.get(i).getNote()+"</td><td>";
                    total = total + participe.get(i).getNote();

                // }
                htmlcorp = htmlcorp + total +"</td><td>";
                // if(total <35)
                //     Dec = "NC";
                // if(total >35 && total < 50)
                //     Dec = "CANT";
                // if(total > 50)
                //     Dec = "CA";
                htmlcorp = htmlcorp + Dec +"</td><td>";
                htmlcorp = htmlcorp + mention(total) +"</td></tr>";
                // htmlcorp = htmlcorp + "ok" +"</td></tr>";



            
            }

            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=pvUe.pdf");
           
            String htmlTest = "\n" + //
                    "<html>\n" + //
                    "\n" + //
                    "<head style='background-color:yellow;'>\n" + //
                    " \n" + //
                    "    <title>Document</title>\n" + //
                    "    <style>\n" + //
                    // "        @page{margin-top:0cm; margin-bottom:0cm; margin-left:0cm; margin-rigth:0cm;\n" + //
                    "        main {\n" + //

                    "            margin: 0;\n" + //
                    "            padding: 0;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #block-info {\n" + //
                    // "            display: flex;\n" + //
                    // "            flex-direction: column;\n" + //
                    "            width: 100%;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        header {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        table {\n" + //
                    "            border-collapse: collapse;\n" + //
                    "            font-weight: bold;\n" + //
                    // "            margin-left: 15%;\n" + //
                    "            width:100%;\n" + //

                    "        }\n" + //
                    "\n" + //
                    "        td {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        table,\n" + //
                    "        td {\n" + //
                    "            border: solid 2px rgb(2, 142, 152);\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #head-pv {\n" + //
                    "            font-size: 10px;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #info-pv {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        .info-uv {\n" + //
                    "            text-align: center;\n" + //
                    "            display:inline-block;\n"+//            
                    // "            border:solid 3px blue;\n"+//                  
                    // "            color:blue;\n"+//

                    "            width: 40%;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #logo-uv {\n" + //
                    "            width: 30%;\n" + //
                    "            display:inline-block;\n"+//            

                    "        }\n" + //
                    "    </style>\n" + //
                    "</head>\n" + //
                    "\n" + //
                    "<body style='margin-top:0px; padding-top:0px; '>\n" + //
                    // "    <header>\n" + //
                    // "        <h1> SYGEN </h1>\n" + //
                    // "    </header>\n" + //
                    "    <main>\n" + //
                    "        <div id=\"block-info\" style='margin:0; padding:0;'>\n" + //
                    "            <div class=\"info-uv\" style='margin-left:-2px;'>\n" + //
                    // "                <p>\n" + //
                    "                <h4 style='margin:8px;' >UNIVERSITE DE YAOUNDE I</h4>\n" + //
                    "                <h5 style='margin:8px;'>FACULTE DES SCIENCESFACULTE</h5>\n" + //
                    "                <h6 style='margin:8px;'> BP/P.O.Box 812 Yaound\u00E9-CAMEROUN /</h6>\n" + //
                    "                <h6 style='margin:8px;'> Tel : 222 234 496 / Email:</h6>\n" + //
                    "                <h6 style='margin:8px;'>diplome@facsciences.uy1.cm</h6>\n" + //
                    // "                </p>\n" + //
                    "            </div>\n" + //
                    // "            <div id=\"logo-uv\">\n" + //
                    // "\n" + //
                    // "            </div>\n" + //
                    "            <div class=\"info-uv\" style='margin-left:100px;'>\n" + //
                    // "                <p>\n" + //
                    "                <h4 style='margin:8px;'>UNIVERSITY OF YAOUNDE I</h4>\n" + //
                    "                <h5 style='margin:8px;'>FACULTE DES SCIENCES</h5>\n" + //
                    "                <h6 style='margin:8px;'>BP/P.O.Box 812 Yaound\u00E9-CAMEROUN /</h6>\n" + //
                    "                <h6 style='margin:8px;'>Tel : 222 234 496 / Email:</h6>\n" + //
                    "                <h6 style='margin:8px;'>diplome@facsciences.uy1.cm</h6>\n" + //
                    // "                </p>\n" + //
                    "            </div>\n" + //
                    "        </div>\n" + //
                    "        <div id=\"info-pv\">\n" + //
                    "            <h2 style='margin:3px;'>PROCES VERBAL DE L'UNITE D'ENSEIGNEMENT</h2>\n" + //
                    "            <h3 style='margin:3px;'>INF221-BASES DE DONNEES ET MODELISATION</h3>\n" + //
                    "            <h4 style='margin:3px;'>CONTROLE CONTINU ("+ "Ue" +")</h4>\n" + //
                    "            <h5 style='margin:3px;'>FILIERE : INE - INFORMATIQUE</h5>\n" + //
                    "            <h5 style='margin:3px;'>SPECIALITE : -</h5>\n" + //
                    "        </div>\n" + //
                    "        <table>\n" + //
                    "            <tr id='head-pv'>\n" + //
                    "                <td>Num</td>\n" + //
                    "                <td> Matricul </td>\n" + //
                    "                <td> Nom et prenom </td>\n" + //
                    "                <td>Niveau</td>\n" + //
                    "                <td>ANO_CC</td>\n" + //
                    "                <td>CC/20</td>\n" + //
                    "                <td>ANO_EE</td>\n" + //
                    "                <td>EE/50</td>\n" + //
                    "                <td>ANO_EP</td>\n" + //
                    "                <td>EP/50</td>\n" + //
                    "                <td>Total/100</td>\n" + //
                    "                <td>DEC</td>\n" + //
                    "                <td>Mention</td>\n" + //
                    "            </tr>\n" + //
                    htmlcorp+
                    "        </table>\n" + //
                    "    </main>\n" + //
                    "</body>\n" + //
                    "\n" + //
                    "</html>";
            
            
          
            
            ServletOutputStream outputStream = response.getOutputStream();

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlTest);
            // renderer.setDocument(new File("index.html"));
            renderer.layout();
            renderer.createPDF(outputStream);
            
            // Flush and close the output stream
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
