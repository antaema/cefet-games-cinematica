package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;


public class Buscar extends AlgoritmoMovimentacao {

    private static final char NOME = 'b';

    public Buscar(float maxVelocidade) {
        this(NOME, maxVelocidade);
    }

    protected Buscar(char nome, float maxVelocidade) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();

        Vector3 direction = new Vector3(super.alvo.getObjetivo().x - agente.posicao.x,
                                        super.alvo.getObjetivo().y - agente.posicao.y,
                                        super.alvo.getObjetivo().z - agente.posicao.z);
        direction.nor();
        direction.scl(maxVelocidade);

        output.velocidade = direction;
        agente.olharNaDirecaoDaVelocidade(direction);
        output.rotacao = 0;
        return output;

    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.B;
    }
}
