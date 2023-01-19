package springapp.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import springapp.dba.DBAConnection;

public class Administrateur {
    Integer id;
    String nom;
    String email;
    String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin [id=" + id + ", nom=" + nom + ", email=" + email + ", password=" + password + "]";
    }

    public Administrateur() {
    }

    public Administrateur(Integer id, String nom, String email, String password) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.password = password;
    }

    public Integer Login() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Integer i=0;

        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("select id from Admin where email = ? and mdp = ?");

            ps.setString(1, this.getEmail());
            ps.setString(2, this.getPassword());
            rs = ps.executeQuery();

            while (rs.next()) {
                setId(rs.getInt("id"));
                i=rs.getInt("id");
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return i;
            
    }

    public static ArrayList<Client> findAllDemandesClients() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Client> liste = new ArrayList<>();
        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("select * from Clients where demande > 0");

            rs = ps.executeQuery();
            while (rs.next()) {
                Client c = new Client();
                c.setIdClient(rs.getInt("id"));
                c.setNom(rs.getString("nomclients"));
                c.setPrenom(rs.getString("prenomclients"));
                c.setMdp(rs.getString("mdpclients"));
                c.setEmail(rs.getString("emailclients"));
                c.setBudget(rs.getFloat("budget"));
                c.setDemande(rs.getInt("demande"));
                liste.add(c);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return liste;

    }

    public static ArrayList<Categorie> findAllElements() throws SQLException{
        ArrayList<Categorie> liste = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("select * from categories");

            rs = ps.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setId(rs.getInt("id"));
                c.setNom(rs.getString("nomcategor"));
                c.setDureenchere(rs.getInt("dureenchere"));
                c.setPourcentage(rs.getInt("pourcentage"));
                liste.add(c);
            }
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return liste;


    }
    public static ArrayList<Categorie> ArgentGenere() throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Categorie> liste = new ArrayList<>();

        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("select * from v_categplusdargent");

            rs = ps.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setNom(rs.getString("categorie"));
                c.setArgent_genere(rs.getInt("argentgenere"));
                liste.add(c);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            rs.close();
            ps.close();
            con.close();
        }
        return liste;
    }
}
