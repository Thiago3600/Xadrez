package Model;

import static Model.Tabuleiro.getTURNO;
import static Model.Tabuleiro.setTURNO;
import java.awt.Point;
import javax.swing.ImageIcon;

public class Bispo extends Pecas {

    public Bispo(int cor, int indexX, int indexY, Tabuleiro tab) {

        setCor(cor);

        if (getCor() == 0) {
            setIcon(new ImageIcon(getClass().getResource("/Imagem/Xadrez_pecas/Brancas/Bispo_Branca.png")));
        } else if (getCor() == 1) {
            setIcon(new ImageIcon(getClass().getResource("/Imagem/Xadrez_pecas/Pretas/Bispo_Pretas.png")));
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

                //Esse if verifica se a peca esta na diagonal
                if ((click[0] + click[1] == getIndexX() + getIndexY()) && click[0] != 0 && click[1] != 0) {
                    ok = obstaculoDiagonal(click, tab);
                }
                //Esse if verifica se a peca esta na perpendicular
                if ((click[0] - click[1] == getIndexX() - getIndexY()) && click[0] != 0 && click[1] != 0) {
                    ok = obstaculoPerpendicular(click, tab);
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

    

}
