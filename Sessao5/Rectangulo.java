package Sessao5;

/*  
    - Definir e obter os valores da largura e altura.
    - Calcular a área do retângulo.
    - Calcular o perímetro do retângulo.
 */
public class Rectangulo {

    /* Atributes */
    private double lado;
    private double altura;

    /* Constructor */
    public Rectangulo(double altura, double lado) {
        this.altura = altura;
        this.lado = lado;
    }

    /* Setters */
    public void setLado(double lado) {
        this.lado = lado;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    /* Getters */
    public double getLado() {
        return this.lado;
    }

    public double getAltura() {
        return this.altura;
    }

    /* Calculations */
    public double calcularArea() {
        return this.altura * this.lado;
    }

    public double calcularPerimetro() {
        return 2 * (this.altura + this.lado);
    }

    public static void main(String[] args) {
        Rectangulo rectangulo = new Rectangulo(10, 5);

        System.out.println("Área do retângulo: " + rectangulo.calcularArea() + "\n");
        System.out.println("Perímetro do retângulo: " + rectangulo.calcularPerimetro() + "\n");
    }

}
