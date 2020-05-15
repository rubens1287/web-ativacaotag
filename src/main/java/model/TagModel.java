package model;


import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.SQLException;

import static core.driver.DriverManager.configuration;

@Log4j2

public class TagModel {

    @Getter @Setter
    private static String tagId;

    public String selectTagId(){
        String tagId =null;
        try ( Connection conn = java.sql.DriverManager.getConnection(
                configuration.hostDb(),
                configuration.userDb(),
                configuration.passDb())) {

            DSLContext create = DSL.using(conn);

            Result<Record> result = create.fetch("SELECT TOP 1 t.NumeroSerie FROM tag t (NOLOCK) \n" +
                                                        "WHERE t.StatusTagId IN (2,4) \n" +
                                                        "ORDER BY tagid DESC");
            for (Record record : result){
               tagId = String.valueOf(record.get("NumeroSerie"));
            }
            conn.close();
        } catch (SQLException e) {
            log.error("Erro na integração com banco de dados: " + e);
        }
        return tagId;
    }
}
