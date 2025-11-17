package extracaodevariaveis;

/**
 * EXERCÍCIO: Extração de Variáveis
 * 
 * PROBLEMA: A expressão no return é complexa e difícil de entender.
 * 
 * TAREFA: Extraia partes da expressão em variáveis com nomes descritivos.
 * 
 * DICA: Variáveis extraídas tornam o código mais legível e facilitam a depuração.
 */
public class CalculadoraPreco {
    
    public double calcularPrecoFinal(double precoBase, int quantidade, double taxaImposto) {
        double subtotal = precoBase * quantidade;
        double taxaFixa = 5.0;
        double calculoImposto = subtotal * (1 + taxaImposto);
        double calculoDesconto = subtotal * 0.1;
        return calculoImposto - calculoDesconto + taxaFixa;
    }
    
    public boolean podeAplicarDesconto(double preco, int quantidade, boolean clienteVIP) {
        boolean caomparaPrcoQuant = preco > 100 && quantidade > 5;
        boolean comparaVipPreco = clienteVIP && preco > 50;
        return caomparaPrcoQuant || comparaVipPreco;
    }
}

