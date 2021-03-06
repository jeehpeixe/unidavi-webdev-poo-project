package unidavi;


/**
 *
 * @author jessicapeixe
 */
public enum SituacaoJogoEnum {
    
    AGUARDANDO(1), ANDAMENTO(2), ENCERRADO(3);
    
    private final int situacaoJogo;

    private SituacaoJogoEnum(int situacaoJogo) {
        this.situacaoJogo = situacaoJogo;
    }
}
