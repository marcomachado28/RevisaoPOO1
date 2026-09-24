public class ChaveApi {

    private String token;
    private String plano;
    private int limiteRequisicoes;
    private int requisicoesRealizadas;
    private boolean ativa;

    public ChaveApi(String token, String plano, int limiteRequisicoes) {
        this.token = token;
        this.plano = plano;
        this.limiteRequisicoes = limiteRequisicoes;
        this.requisicoesRealizadas = 0;
        this.ativa = true;
    }

    public void registrarChamada() {

        if (!ativa) {
            throw new RuntimeException(
                    "Acesso negado: Chave inativa."
            );
        }

        if (requisicoesRealizadas >= limiteRequisicoes) {
            throw new RuntimeException("Acesso negado: Limite de requisições excedido.");
        }


        requisicoesRealizadas++;
    }

    public void fazerUpgrade(String novoPlano, int novoLimite) {

        if (novoLimite < limiteRequisicoes) {
            throw new IllegalArgumentException(
                    "O novo limite não pode ser menor que o limite atual."
            );
        }

        this.plano = novoPlano;
        this.limiteRequisicoes = novoLimite;
    }

    public void resetarCiclo() {
        requisicoesRealizadas = 0;
    }

    public void bloquearChave() {
        ativa = false;
    }

    public void desbloquearChave() {
        ativa = true;
    }
}
