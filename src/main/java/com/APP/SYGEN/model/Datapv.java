package com.APP.SYGEN.model;

import java.time.LocalDate;


public class Datapv {
    private String ue;
    private String filiere;
    private String niveau;
    private String semestre;
    private String typePv;
    private LocalDate annee;
    private String contentPdf;
    
    public String getUe() {
        return ue;
    }
    public void setUe(String ue) {
        this.ue = ue;
    }
    public String getFiliere() {
        return filiere;
    }
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    public String getNiveau() {
        return niveau;
    }
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public String getTypePv() {
        return typePv;
    }
    public void setTypePv(String typePv) {
        this.typePv = typePv;
    }
    public LocalDate getAnnee() {
        return annee;
    }
    public void setAnnee(LocalDate annee) {
        this.annee = annee;
    }
    public void DataForm() {
    }
    public void DataForm(String ue, String filiere, String niveau, String semestre, String typePv, LocalDate annee) {
        this.ue = ue;
        this.filiere = filiere;
        this.niveau = niveau;
        this.semestre = semestre;
        this.typePv = typePv;
        this.annee = annee;
    }

    // methode permettant de creer le pdf d'un controle continue

    public String cCpdfContent(String htmlCorp, String filiere, Evaluation evaluation){
        if(evaluation.getTypeEval().equals("cc"))
            evaluation.setTypeEval("CONTROLE CONTINU ( CC )");
        else if(evaluation.getTypeEval().equals("tp"))
            evaluation.setTypeEval("TRAVAUX PRATIQUES ( TP )");    
        this.contentPdf = "\n" + //
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
                    "            width: 110%;\n" + //
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
                    "         p {\n" + //
                    "            font-size: 10px;\n" + //
                    "        }\n" + //                    
                    "\n" + //
                    "        #info-pv {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    // "\n" + //
                    "        .info-uv-1 {\n" + //
                    "            text-align: center;\n" + //
                    "            display:inline-block;\n"+//  
                    "             margin-left:-62px;\n" + //
                    "             margin-right:0;\n" + //  
                    // "             padding-right:-20%;\n" + //                              

                    // "            border:solid 3px blue;\n"+//                  
                    // "            color:blue;\n"+//

                    "            width: 40%;\n" + //
                    "        }\n" + //
                    "        .info-uv-2 {\n" + //
                    "            text-align: center;\n" + //
                    "             margin-left:26%;\n" + //
                    "             margin-right:-10px;\n" + //
                    "             padding:0;\n" + //
                    // "            display: flex;\n" + //
                    // "            flex-direction: column;\n" + //
                                "display:inline-block;\n" + //            
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
                    "            <div class=\"info-uv-1\" >\n" + //
                    // "                <p>\n" + //
                    "                <h5 style='margin:8px; padding-left:0;'>REPUBLIQUE DU CAMEROUN</h5>\n"+//
                    "                <p style='margin:8px;'>Paix -Travail - Patrie</p>\n"+//
                    "                <h6 style='margin:8px;' >UNIVERSITE DE YAOUNDE I</h6>\n" + //
                    "                <p style='margin:8px;'>FACULTE DES SCIENCES</p>\n" + //
                    "                <p style='margin:8px;'> BP/P.O.Box 812 Yaound\u00E9-CAMEROUN /</p>\n" + //
                    "                <p style='margin:8px;'> Tel : 222 234 496 / Email:</p>\n" + //
                    "                <p style='margin:8px;'>diplome@facsciences.uy1.cm</p>\n" + //
                    // "                </p>\n" + //
                    "            </div>\n" + //
                    // "            <div id=\"logo-uv\">\n" + //
                    // "\n" + //
                    // "            </div>\n" + //
                    "            <div class=\"info-uv-2\" >\n" + //
                    // "                <p>\n" + //
                    "                <h5 style='margin:8px;'>REPUBLIQUE DU CAMEROUN</h5>\n"+//
                    "                <p style='margin:8px;'>Paix -Travail - Patrie</p  >\n"+//
                    "                <h6 style='margin:8px;' >UNIVERSITE DE YAOUNDE I</h6>\n" + //
                    "                <p style='margin:8px;'>FACULTE DES SCIENCES</p>\n" + //
                    "                <p style='margin:8px;'> BP/P.O.Box 812 Yaound\u00E9-CAMEROUN /</p >\n" + //
                    "                <p style='margin:8px;'> Tel : 222 234 496 / Email:</p >\n" + //
                    "                <p style='margin:8px;'>diplome@facsciences.uy1.cm</p  >\n" + //
                    // "                </p>\n" + //
                    "            </div>\n" + //
                    "        </div>\n" + //
                    "        <div id=\"info-pv\">\n" + //
                    "            <h2 style='margin:3px;'>PROCES VERBAL DE L'UNITE D'ENSEIGNEMENT</h2>\n" + //
                    "            <h3 style='margin:3px;'>"+evaluation.getUE().getCodeUE()+" "+evaluation.getUE().getIntutile()+"</h3>\n" + //
                    "            <h4 style='margin:3px;'>"+ evaluation.getTypeEval()+"</h4>\n" + //
                    "            <h5 style='margin:3px;'>FILIERE : INE - "+filiere+"</h5>\n" + //
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
                                htmlCorp+//

                    "        </table>\n" + //

                    "    </main>\n" + //
                    "</body>\n" + //
                    "\n" + //
                    "</html>";
        return this.contentPdf;
    }


    // methode permettant de creer le pdf du pv d'une unite d'enseignement
    public String uEpdfContent(String htmlCorp, String filiere, Evaluation evaluation){
        String contentPdf = "\n" + //
                    "<html>\n" + //
                    "\n" + //
                    "<head style='background-color:yellow;'>\n" + //
                    " \n" + //
                    "    <title>Document</title>\n" + //
                    "    <style>\n" + //
                    "        @media print{ \n" + //
                    "       @page{size:landscape;}}\n"+ //
                    "        main {\n" + //

                    "            margin: 0;\n" + //
                    "            padding: 0;\n" + //
                    "        }\n" + //
                    "\n" + //
                    "        #block-info {\n" + //
                    // "            display: flex;\n" + //
                    // "            flex-direction: column;\n" + //
                    "            width: 110%;\n" + //
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
                    // "            font-size: 18px;\n" + //
                    "        }\n" + //
                    "         p {\n" + //
                    "            font-size: 10px;\n" + //
                    "        }\n" + //                    
                    "\n" + //
                    "        #info-pv {\n" + //
                    "            text-align: center;\n" + //
                    "        }\n" + //
                    // "\n" + //
                    "        .info-uv-1 {\n" + //
                    "            text-align: center;\n" + //
                    "            display:inline-block;\n"+//  
                    "             margin-left:-46px;\n" + //
                    "             margin-right:0;\n" + //  
                    // "             padding-right:-20%;\n" + //                              

                    // "            border:solid 3px blue;\n"+//                  
                    // "            color:blue;\n"+//

                    "            width: 40%;\n" + //
                    "        }\n" + //
                    "        .info-uv-2 {\n" + //
                    "            text-align: center;\n" + //
                    "             margin-left:20%;\n" + //
                    "             margin-right:-10px;\n" + //
                    "             padding:0;\n" + //
                    // "            display: flex;\n" + //
                    // "            flex-direction: column;\n" + //
                                "display:inline-block;\n" + //            
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
                    "            <div class=\"info-uv-1\">\n" + //
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
                    "            <div class=\"info-uv-2\">\n" + //
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
                    "            <h3 style='margin:3px;'>"+"evaluation.getUE().getCodeUE()"+" "+ "evaluation.getUE().getIntutile()"+"</h3>\n" + //
                    "            <h4 style='margin:3px;'>"+ "evaluation.getTypeEval()"+"</h4>\n" + //
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
                    htmlCorp+ //
                    "        </table>\n" + //
                    "    </main>\n" + //
                    "</body>\n" + //
                    "\n" + //
                    "</html>";
        return contentPdf;
    }
    

    

}
