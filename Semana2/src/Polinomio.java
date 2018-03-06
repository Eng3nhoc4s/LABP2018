public class Polinomio {

    private Fracao [] coefs;

    public Fracao [] getCoefs () {
        return coefs;
    }

    public Polinomio(Fracao[] coefs){

        //Inverte os coeficientes de modo ao monomios de grau 0 ficar na pos 0 do array
        for (int i = 0; i < coefs.length; i++) {
            this.coefs[i] = coefs[coefs.length - 1 - i];
        }
    }

    public int grau() {
        return coefs.length - 1;
    }

    public boolean ehZero() {
        return grau() == 0;
    }

    public boolean ehConstante(){
        return ehZero();
    }

    public boolean ehIgual(Polinomio p){

        Fracao [] pCoefs = p.getCoefs();

        if(this.grau() != p.grau()) {
            return false;
        } else {
            for (int i = 0; i < coefs.length; i++) {
                if (!this.coefs[i].equals(pCoefs[i])){
                    return false;
                }
            }

            return true;
        }
    }

    public Polinomio escalar(Fracao f){

    }




}
