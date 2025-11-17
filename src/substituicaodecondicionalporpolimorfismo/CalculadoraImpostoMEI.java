package substituicaodecondicionalporpolimorfismo;

public class CalculadoraImpostoMEI extends CalculadoraImpostoOutroTipo {
    protected static double calcularImpostoMEI(double valor) {
        return valor * 0.05;
    }
}
