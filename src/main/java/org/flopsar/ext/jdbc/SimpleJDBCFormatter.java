package org.flopsar.ext.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;




public class SimpleJDBCFormatter {

    private static final char SEPARATOR = 0x1E;

    private static ThreadLocal<String> SQL = new ThreadLocal<String>(){
        protected synchronized String initialValue(){
            return "NA";
        }
    };


    public static String formatExecute(Object[] input){
        try {
            String query = (String)input[1];
            return "SQL"+ SEPARATOR +query;
        } catch (Throwable e) {
            return "Error"+ SEPARATOR +e.getMessage();
        }
    }



    public static String formatExecuteUpdate(Object[] input){
        try {
            String query = (String)input[1];
            return "SQL"+ SEPARATOR +query;
        } catch (Throwable e) {
            return "Error"+ SEPARATOR +e.getMessage();
        }
    }

    public static String formatExecuteQuery(Object[] input){
        try {
            String query = (String)input[1];
            return "SQL"+ SEPARATOR +query;
        } catch (Throwable e) {
            return "Error"+ SEPARATOR +e.getMessage();
        }
    }





    private static String formatStatement(Statement statement){
        try {
            return "URL"+ SEPARATOR +statement.getConnection().getMetaData().getURL()
                    + SEPARATOR +"SQL"+ SEPARATOR +statement;
        } catch (Throwable e) {
            return "Error"+ SEPARATOR +e.getMessage();
        }
    }



    public static String formatPreparedStatement(Object[] input){
        try {
            Object _this = input[0];
            PreparedStatement ps = (PreparedStatement)input[1];
            String ssql = SQL.get();

            return "URL"+ SEPARATOR +ps.getConnection().getMetaData().getURL()
                    + SEPARATOR +"SQL"+ SEPARATOR +ssql;
        } catch (Throwable e) {
            return "Error"+ SEPARATOR +e.getMessage();
        }
    }


}
