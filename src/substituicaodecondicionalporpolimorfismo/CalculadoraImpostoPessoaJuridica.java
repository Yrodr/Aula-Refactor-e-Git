package substituicaodecondicionalporpolimorfismo;

public class CalculadoraImpostoPessoaJuridica extends CalculadoraImpostoMEI {
    protected static double calcularImpostoPesooaJuridica(double valor) {
        return valor * 0.15;
    }
}
