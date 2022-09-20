package com.mycompany.examenfinal;

public class main {

    static conexionDB connMongo;

    public static void main(String[] args) {

        connMongo = new conexionDB();
        connMongo.setBD();

       maquinaria formMaquinaria = new maquinaria();
        formMaquinaria.setVisible(true);

    }

}
