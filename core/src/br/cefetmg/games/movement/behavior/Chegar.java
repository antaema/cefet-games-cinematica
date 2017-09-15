package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;

public class Chegar extends AlgoritmoMovimentacao {

    private static final char NOME = 'c';
    private float raio, aceleracao;

    public Chegar(float maxVelocidade, float raio, float aceleracao) {
        this(NOME, maxVelocidade, raio, aceleracao);
    }

    protected Chegar(char nome, float maxVelocidade, float raio, float aceleracao) {
        super(nome);
        this.maxVelocidade = maxVelocidade;
        this.raio = raio;
        this.aceleracao = aceleracao;
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();

        Vector3 direction = new Vector3(super.alvo.getObjetivo().x - agente.posicao.x,
                                        super.alvo.getObjetivo().y - agente.posicao.y,
                                        super.alvo.getObjetivo().z - agente.posicao.z);

        agente.olharNaDirecaoDaVelocidade(direction);
        
        if(direction.len() >= raio) { 
            output.velocidade = direction;
            agente.olharNaDirecaoDaVelocidade(direction);
            output.rotacao = 0;
            output.velocidade.scl(aceleracao);
            
            if (output.velocidade.len() > maxVelocidade) {
                output.velocidade.nor();
                output.velocidade.scl(maxVelocidade);
            }
        }
      

        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.C;
    }
}
