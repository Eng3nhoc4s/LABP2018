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
     * Soma duas funcoes
     * @param f A funcao a ser somada com
     * @return Uma funcao resultante da soma das duas funcoes
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

    /**
     *
     * @return
     */
    public Fracao copia(){

        return new Fracao(num, den);
    }

    /**
     * Verifica se duas funcoes são equivalentes
     * @param f a funcao a ser comparada com
     * @return true Se as funcoes sao equivalentes
     */
    public boolean equivalente(Fracao f){

        return num * f.getDenominador() == den * f.getDenominador();
    }

    /**
     * Apresenta uma função de modo textual
     * @return String com o texto que representa a fracao
     */
    public String toString(){

        Fracao temp = reduzirFracao(this);

        //Se é zero... é zero... ez pz
        if(temp.getNumerador() == 0) {
            return "0";

        //Se é numero inteiro... também ez pz
        } else if(temp.ehInteira()) {
            return (temp.getNumerador() / temp.getDenominador()) + "";

        //Se o numerador é < 0 e o den > 0, tá chill
        } else if (temp.getNumerador() < 0 && temp.getDenominador() > 0){
            return temp.getNumerador() + "/" + temp.getDenominador();

        //Denominador < 0, trocar os business
        } else if (temp.getNumerador() > 0 && temp.getDenominador() < 0){
            return temp.getNumerador() * (-1) + "/" + temp.getDenominador() * (-1);

        } else if (temp.getNumerador() < 0 && temp.getDenominador() < 0){
            return temp.getNumerador() * (-1) + "/" + temp.getDenominador() * (-1);
        }else{
            return temp.getNumerador() + "/" + temp.getDenominador();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if ( this == obj )
            return true;
        if ( !(obj instanceof Fracao) )
            return false;

        Fracao f = (Fracao) obj;

        return (this.toString() == f.toString());
    }

    /**
     * Devolve o maior divisor comum entre a e b
     * @param a Valor a
     * @param b Valor b
     * @return Maior divisor comum entre eles
     */
    private static int maiorDivisorComum (int a, int b) {

        return b == 0 ? a : maiorDivisorComum(b, a%b);
    }

    /**
     * Devolve uma Fracao na forma reduzida
     * @param f Fracao a reduzir
     * @return Fracao reduzida
     */
    private Fracao reduzirFracao(Fracao f){

        int mdc = maiorDivisorComum(f.getNumerador(), f.getDenominador());

        return new Fracao(f.getNumerador() / mdc, f.getDenominador() / mdc);
    }
}
