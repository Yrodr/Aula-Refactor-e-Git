package substituicaodecondicionalporpolimorfismo;

public class CalculadoraImpostoPessoaFisica extends CalculadoraImpostoPessoaJuridica {
    protected static double calcularImpostoPessoaFisica(double valor) {
        return valor * 0.10;
    }
}
