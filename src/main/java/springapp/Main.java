package springapp;

import java.sql.Connection;
import springapp.dba.DBAConnection;

public class Main {
    public static void main(String[] args) {
        try (
                Connection con = DBAConnection.connect()) {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
