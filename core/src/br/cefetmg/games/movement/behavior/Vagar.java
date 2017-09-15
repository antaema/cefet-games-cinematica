package br.cefetmg.games.movement.behavior;

import br.cefetmg.games.movement.AlgoritmoMovimentacao;
import br.cefetmg.games.movement.Direcionamento;
import br.cefetmg.games.movement.Pose;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector3;
import java.util.Random;

/**
 * Movimenta o agente em uma direção aleatória, vagando pelo cenário.
 *
 * @author Flávio Coutinho <fegemo@cefetmg.br>
 */
public class Vagar extends AlgoritmoMovimentacao {

    private static final char NOME = 'v';
    private float maxAngular = 30f;
    private Random r;

    public Vagar() {
        super(NOME);
    }

    public Vagar(float tangencial, float angular) {
        super(NOME);
        maxVelocidade = tangencial;
        maxAngular = angular;
        r = new Random();
    }

    @Override
    public Direcionamento guiar(Pose agente) {
        Direcionamento output = new Direcionamento();
        
        Vector3 direction = agente.getOrientacaoComoVetor();
        direction.scl(maxVelocidade);
        
        output.velocidade = direction;
        output.rotacao = (r.nextFloat() - r.nextFloat())* maxAngular; 

        return output;
    }

    @Override
    public int getTeclaParaAtivacao() {
        return Keys.V;
    }
}
