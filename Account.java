public class Account {
    private String idAccount;
    private double somme;

    public Account(String id,double somme){
        this.idAccount = id;
        this.somme = somme;
    }

    public String getId() {
        return idAccount;
    }

    public double getSomme() {
        return somme;
    }

    public void setId(String id) {
        this.idAccount = id;
    }

    public void setSomme(double somme) {
        this.somme = somme;
    }
    public void deposer(double somme) {
        this.somme += somme;
    }
    public void retirer(double somme){
        this.somme -= somme;
    }
}
