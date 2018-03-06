public class Fracao {

    private int num;
    private int den;

    /**
     * Construtor da classe
     * @param num Numerador
     * @param den Denominador
     */
    public Fracao(int num, int den){
        this.num = num;
        this.den = den;
    }

    /**
     * Devolve o numerador da fracao
     * @return num
     */
    public int getNumerador() {
        return num;
    }

    /**
     * Devolve o denominador da fracao
     * @return den
     */
    public int getDenominador() {
        return den;
    }


    /**
     * Verifica se esta fração representa o número zero
     * @return true Se num == 0
     */
    public boolean ehZero(){
        return num == 0;
    }

    /**
     * Verifica se esta fração representa um número inteiro
     * @return true se numerador / denominador tem resto 0
     */
    public boolean ehInteira(){
        return (num % den) == 0;
    }

    /**
     * Verifica se esta fração representa um número positivo
     * @return true se ambos o denominador e o numerador forem > 0
     */
    public boolean ehPositiva(){
        return (num > 0 && den > 0);
    }

    /**
     * Devolve uma nova fração que é a inversa desta fração
     * @return Nova Fracao (den, num)
     */
    public Fracao inversa(){
        return new Fracao(den, num);
    }

    /**
     *
     * @param f
     * @return
     */
    public Fracao soma (Fracao f){

        if(this.den == f.getDenominador()){
            return new Fracao(num + f.getNumerador(), den);
        }else{
            Fracao a = new Fracao(num * f.getDenominador(), den * f.getDenominador());
            Fracao b = new Fracao(f.getNumerador() * den, f.getDenominador() * den);
            return new Fracao(a.getNumerador() + b.getNumerador(), a.getDenominador());
        }

    }

    /**
     *
     * @param f
     * @return
     */
    public Fracao produto (Fracao f){

        return new Fracao(num * f.getNumerador(), den * f.getDenominador());
    }

    /**
     *
     * @param f
     * @return
     */
    public Fracao divisao(Fracao f){
        return this.produto(f.inversa());
    }

    //todo
    public Fracao copia(){
        return new Fracao(num, den);
    }

    //todo
    public boolean equivalente(Fracao f){

        return false;
    }

    //todo
    public String toString(){
        return "";
    }


}
