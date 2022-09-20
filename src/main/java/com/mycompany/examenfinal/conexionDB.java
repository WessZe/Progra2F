package com.mycompany.examenfinal;

import com.mongodb.MongoException;
import com.mongodb.client.*;
import com.mongodb.client.result.*;
import static com.mongodb.client.model.Filters.*;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.bson.conversions.Bson;

public class conexionDB {

    MongoClient conn;
    String servidor = "localhost";
    Integer puerto = 27017;

    MongoDatabase dataBaseSelect;

    public conexionDB() {
        try {
            this.conn = MongoClients.create("mongodb://" + servidor + ":" + puerto.toString());
            System.out.println("Conexion exitosa");
        } catch (MongoException error) {
            System.out.println("Error en conexion: " + error.toString());
        }
    }

    public void setBD() {
        dataBaseSelect = conn.getDatabase("dbLigaNacional");
        System.out.println("DB Selecionada: " + dataBaseSelect.toString());
    }

    public MongoDatabase getDB() {

        return dataBaseSelect;
    }

}
