package springapp.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import springapp.dba.DBAConnection;

public class Client {
    int idClient;
    String nom;
    String prenom;
    String mdp;
    String email;
    float budget;
    int demande;


    public Client() {
    }

    public Client(int idClient, String nom, String prenom, String mdp, String email, float budget, int demande) {
        this.idClient = idClient;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.email = email;
        this.budget = budget;
        this.demande = demande;
    }

    public int getIdClient() {
        return this.idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getBudget() {
        return this.budget;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public float getDemande() {
        return this.demande;
    }

    public void setDemande(int demande) {
        this.demande = demande;
    }

    public Client idClient(int idClient) {
        setIdClient(idClient);
        return this;
    }

    public Client nom(String nom) {
        setNom(nom);
        return this;
    }

    public Client prenom(String prenom) {
        setPrenom(prenom);
        return this;
    }

    public Client mdp(String mdp) {
        setMdp(mdp);
        return this;
    }

    public Client email(String email) {
        setEmail(email);
        return this;
    }

    public Client budget(float budget) {
        setBudget(budget);
        return this;
    }

    public Client demande(int demande) {
        setDemande(demande);
        return this;
    }

    public int UpdateBudget(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int manova = 0;
        try {
            con = DBAConnection.connect();
            ps = con.prepareStatement("update clients set demande = ?, budget = ? where id = ? ");
            ps.setFloat(1, this.getDemande());
            ps.setFloat(2, this.getBudget()+this.getDemande());
            ps.setInt(3, this.getIdClient());

            manova = ps.executeUpdate();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return manova;
    }   


    @Override
    public String toString() {
        return "{" +
            " idClient='" + getIdClient() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", mdp='" + getMdp() + "'" +
            ", email='" + getEmail() + "'" +
            ", budget='" + getBudget() + "'" +
            ", demande='" + getDemande() + "'" +
            "}";
    }

   

}
