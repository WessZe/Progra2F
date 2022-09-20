package com.mycompany.examenfinal;

public class main {

    static conexionDB connMongo;

    public static void main(String[] args) {

        connMongo = new conexionDB();
        connMongo.setBD();

        //equipos formEquipos = new equipos();
        //formEquipos.setVisible(true);

    }

}
