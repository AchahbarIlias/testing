package model;

public class Meal implements Comparable {
    private String categorie;
    private String allergie;
    private String prijs;
    private String vegan;
    private String titel;

    public Meal(String titel, String categorie, boolean vegan, String allergie, String prijs) {
        setAllergie(allergie);
        setCategorie(categorie);
        setTitel(titel);
        setPrijs(prijs);
        setVegan(vegan);
    }

    public void setAllergie(String allergie) {
        this.allergie = allergie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setPrijs(String prijs) {
        this.prijs = prijs;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setVegan(boolean vegan) {
        this.vegan = vegan ? "ja" : "nee";
    }

    public String getAllergie() {
        return allergie;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getPrijs() {
        return prijs;
    }

    public String getTitel() {
        return titel;
    }

    public String getVegan() {
        return vegan;
    }

    @Override
    public int compareTo(Object o) {
        Meal m = (Meal) o;
        return this.categorie.compareTo(m.categorie);
    }
}
