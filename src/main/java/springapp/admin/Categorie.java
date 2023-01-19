package springapp.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import springapp.dba.DBAConnection;

public class Categorie{
    Integer id;
    String nom;
    Integer dureenchere;
    Integer pourcentage;
    ArrayList<TypeProduit> typeProduits;
    Integer nbr_ventes;
    Integer argent_genere;

    public Categorie() {
    }


    public Categorie(Integer id, String nom, Integer dureenchere, Integer pourcentage, ArrayList<TypeProduit> typeProduits, Integer nbr_ventes, Integer argent_genere) {
        this.id = id;
        this.nom = nom;
        this.dureenchere = dureenchere;
        this.pourcentage = pourcentage;
        this.typeProduits = typeProduits;
        this.nbr_ventes = nbr_ventes;
        this.argent_genere = argent_genere;
    }
    
    
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public Integer getDureenchere() {
        return this.dureenchere;
    }

    public void setDureenchere(Integer dureenchere) {
        this.dureenchere = dureenchere;
    }

    public Integer getPourcentage() {
        return this.pourcentage;
    }

    public void setPourcentage(Integer pourcentage) {
        this.pourcentage = pourcentage;
    }


    public Integer getNbr_ventes() {
        return this.nbr_ventes;
    }

    public void setNbr_ventes(Integer nbr_ventes) {
        this.nbr_ventes = nbr_ventes;
    }

    public ArrayList<TypeProduit> getTypeProduits() {
        return this.typeProduits;
    }

    public void setTypeProduits(ArrayList<TypeProduit> typeProduits) {
        this.typeProduits = typeProduits;
    }

    public Integer getArgent_genere() {
        return this.argent_genere;
    }

    public void setArgent_genere(Integer argent_genere) {
        this.argent_genere = argent_genere;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", dureenchere='" + getDureenchere() + "'" +
            ", pourcentage='" + getPourcentage() + "'" +
            ", typeProduits='" + getTypeProduits() + "'" +
            ", nbr_ventes='" + getNbr_ventes() + "'" +
            ", argent_genere='" + getArgent_genere() + "'" +
            "}";
    }
    
    

    public static ArrayList<Categorie> categoriePlusVendus() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Categorie> liste = new ArrayList<>();
        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("select*from v_categplusvendue");

            rs = ps.executeQuery();
            while (rs.next()) {
                Categorie c = new Categorie();
                
                c.setNom(rs.getString("nomcategor"));
                c.setNbr_ventes(rs.getInt("nbvente"));
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
    
    public ArrayList<TypeProduit> findTypePCateg() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<TypeProduit> liste = new ArrayList<>();

        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("select * from v_typeproduitcategories where id = ?");
            ps.setInt(1,this.id);
            rs = ps.executeQuery();
            while (rs.next()) {
                TypeProduit tp = new TypeProduit();
                tp.setNom(rs.getString("typeproduit"));
                liste.add(tp);
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

}