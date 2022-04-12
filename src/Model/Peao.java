package Model;

import static Model.Tabuleiro.getTURNO;
import static Model.Tabuleiro.setTURNO;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Peao extends Pecas {
    

    // Cor é 0´pra Brancas e 1 pra Pretas
    public Peao(int cor, int indexX, int indexY, Tabuleiro tab) {

        setCor(cor);

        if (getCor() == 0) {
            setIcon(new ImageIcon(getClass().getResource("/Imagem/Xadrez_pecas/Brancas/Peao_Branca.png")));
        } else if (getCor() == 1) {
            setIcon(new ImageIcon(getClass().getResource("/Imagem/Xadrez_pecas/Pretas/Peao_Pretas.png")));
        }

        setIconWidth(Icon.getIconWidth());
        setIconHeight(Icon.getIconHeight());

        tabX = new int[tab.getVet().length];
        tabY = new int[tab.getVet().length];

        for (int i = 0; i < tab.getVet().length; i++) {
            tabX[i] = tab.getVet()[i][0];
            tabY[i] = tab.getVet()[0][i];
        }

        setIndexX(indexX);
        setIndexY(indexY);

        setPosAtualX(getIndexX());
        setPosAtualY(getIndexY());

    }

    public void mover(Point p, boolean mousePressionado, int[] click, Tabuleiro tab) {

        if (mousePressionado) {
            setMovendo(true);
            
            setPosAtualX(p.x - getIconWidth() / 2);
            setPosAtualY(p.y - getIconHeight() / 2);

            setMovendo(false);

        } else {
            if (getTURNO() == getCor()) {

                boolean ok = false;

                if (getCor() == 0) {
                    int mb = 1;
                    if (getIndexY() == 7) {
                        mb = 2;
                    }
                    if (click[1] < getIndexY() && click[1] >= getIndexY() - mb && getIndexX() == click[0]) {
                        
                        
                        if (!verificaObstaculo(click, tab)) {
                            ok = true;
                        }
                        
                        
                    }
                } else if (getCor() == 1) {

                    int mp = 1;
                    if (getIndexY() == 2) {
                        mp = 2;
                    }
                    if (click[1] > getIndexY() && click[1] <= getIndexY() + mp && getIndexX() == click[0]) {
                        if (!verificaObstaculo(click, tab)) {
                            ok = true;
                        }
                    }
                }
                if (ok) {
                    setIndexX(click[0]);
                    setIndexY(click[1]);
                    if (getCor() == 0) {
                        setTURNO(1);
                    }
                    if (getCor() == 1) {
                        setTURNO(0);
                    }
                }

            }

            setPosAtualX(getIndexX());
            setPosAtualY(getIndexY());

        }
    }
    
    public void capturar(){
        
        
        
    }
    public boolean verificaObstaculo(int[] clickFinal, Tabuleiro tab){
        
        boolean ok = false;
        
        for (int i = 0; i < tab.todasPecas.length; i++) {
            if (getCor() == 0) {
                if (getIndexY() - 1 == tab.todasPecas[i][3]&&getIndexX() == tab.todasPecas[i][2]) {
                    ok = true;
                }
            }
            if (getCor() == 1) {
                if (getIndexY() + 1 == tab.todasPecas[i][3]&&getIndexX() == tab.todasPecas[i][2]) {
                    
                    ok = true;
                }
            }
        }
        
        
        
        return ok;
    }
}
