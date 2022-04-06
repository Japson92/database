package com;


import java.sql.*;
        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.SQLException;

public class Main {

    static String daneZBazy;


    public static void main(String[] args) {

        String polaczenieURL = "jdbc:mysql://127.0.0.1/mesko?user=root&password=Lefsi123";
        //Tworzymy proste zapytanie do bazy danych
        String query = "Select * FROM frezarskie";

        Connection conn;

        try {

            //Ustawiamy dane dotyczące podłączenia
            conn = DriverManager.getConnection(polaczenieURL);

            //Ustawiamy sterownik MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Uruchamiamy zapytanie do bazy danych
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);


            while (rs.next()) {
                wyswietlDaneZBazy(rs);
            }

            conn.close();
        }
        //Wyrzuć wyjątki jężeli nastąpią błędy z podłączeniem do bazy danych lub blędy zapytania o dane
        catch (ClassNotFoundException wyjatek) {
            System.out.println("Problem ze sterownikiem");
        } catch (SQLException wyjatek) {
            //e.printStackTrace();
            System.out.println("Problem z logowaniem\nProsze sprawdzic:\n nazwę użytkownika, hasło, nazwę bazy danych lub adres IP serwera");
            System.out.println("SQLException: " + wyjatek.getMessage());
            System.out.println("SQLState: " + wyjatek.getSQLState());
            System.out.println("VendorError: " + wyjatek.getErrorCode());
        }

    }
// sprobowac wstawic liste danych
    static void wyswietlDaneZBazy(ResultSet rs) {
        try {
            for (int i = 1;i < 12 ; i++ ) {
                // if (rs.next()==true)
                daneZBazy = rs.getString(i);
                System.out.print(daneZBazy + " ");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
