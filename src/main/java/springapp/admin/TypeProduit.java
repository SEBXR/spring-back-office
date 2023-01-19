package springapp.admin;

import java.util.ArrayList;

public class TypeProduit {
    Integer id;
    String nom;
    Categorie categorie;
    Integer nbr_vente;

    public TypeProduit() {
    }

    public TypeProduit(Integer id, String nom, Categorie categorie, Integer nbr_vente) {
        this.id = id;
        this.nom = nom;
        this.categorie = categorie;
        this.nbr_vente = nbr_vente;
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
    
    public String getCategorie() {
        return null;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Integer getNbr_vente() {
        return this.nbr_vente;
    }

    public void setNbr_vente(Integer nbr_vente) {
        this.nbr_vente = nbr_vente;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nom='" + getNom() + "'" +
            ", categorie='" + getCategorie() + "'" +
            "}";
    }
    
    public static ArrayList<TypeProduit> produitPlusVendus(){
        return null;
    }
}
