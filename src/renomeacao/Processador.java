package renomeacao;

/**
 * EXERCÍCIO: Renomeação
 * 
 * PROBLEMA: Os nomes das variáveis e métodos não são claros e não expressam bem sua intenção.
 * 
 * TAREFA: Renomeie as variáveis e métodos para nomes mais descritivos e expressivos.
 * 
 * DICA: Nomes devem revelar a intenção do código. Evite abreviações e nomes genéricos.
 */
public class Processador {
    
    public void textoRepete(String texto, int quantidadeRepete) {
        String repeteTexto = "";
        for (int i = 0; i < quantidadeRepete; i++) {
            repeteTexto = repeteTexto + texto;
        }
        System.out.println(repeteTexto);
    }
    
    public int calc(int primeiroNum, int segundoNum) {
        return primeiroNum * segundoNum + primeiroNum + segundoNum;
    }
}

