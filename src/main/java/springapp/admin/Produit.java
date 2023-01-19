package springapp.admin;

public class Produit {
    Integer id;
    TypeProduit typeProduit;
    String description;
    String img;
    Float prixMin;
    Client client;
    Integer statut;

    public Produit() {
    }

    public Produit(Integer id, TypeProduit typeProduit, String description, String img, Float prixMin, Client client,
            Integer statut) {
        this.id = id;
        this.typeProduit = typeProduit;
        this.description = description;
        this.img = img;
        this.prixMin = prixMin;
        this.client = client;
        this.statut = statut;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeProduit getTypeProduit() {
        return this.typeProduit;
    }

    public void setTypeProduit(TypeProduit typeProduit) {
        this.typeProduit = typeProduit;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return this.img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Float getPrixMin() {
        return this.prixMin;
    }

    public void setPrixMin(Float prixMin) {
        this.prixMin = prixMin;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getStatut() {
        return this.statut;
    }

    public void setStatut(Integer statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", typeProduit='" + getTypeProduit() + "'" +
                ", description='" + getDescription() + "'" +
                ", img='" + getImg() + "'" +
                ", prixMin='" + getPrixMin() + "'" +
                ", client='" + getClient() + "'" +
                ", statut='" + getStatut() + "'" +
                "}";
    }

}
