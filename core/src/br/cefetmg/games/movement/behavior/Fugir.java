package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

/**
 * Guia o agente de forma a fugir na direção contrária ao alvo.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Fugir extends AlgoritmoMovimentacao {

    private static final char NOME = 'f';

    public Fugir(float maxVelocidade) {
        super(NOME);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();

        Vector3 direction = new Vector3(agente.posicao.x - super.alvo.getObjetivo().x,
                                        agente.posicao.y - super.alvo.getObjetivo().y,
                                        agente.posicao.z - super.alvo.getObjetivo().z);
        direction.nor();
        direction.scl(maxVelocidade);

        output.velocidade = direction;
        agente.olharNaDirecaoDaVelocidade(direction);
        output.rotacao = 0;
        return output;
    }
    
    @Override
    public int getTeclaParaAtivacao() {
        return Keys.F;
    }

}
