package View;

import Model.Bispo;
import Model.Cavalo;
import Model.Peao;
import Model.Rainha;
import Model.Rei;
import Model.Tabuleiro;
import Model.Torre;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Desenha extends JPanel {

    int width, height, tamanho = 0, casas = 8, margem = 0;
    Tabuleiro t;
    public Desenha(int width, int height) {
        setWidth(width);
        setHeight(height);

    }

    
    public void desenhaTabuleiro(Graphics g, Tabuleiro t, Peao[] peao, Torre[] torre, Cavalo[] cavalo, Bispo[] bispo, Rainha[] rainha, Rei[] rei){
        g.setColor(Color.gray);
        for(int i = 1; i<t.getVet().length; i++){
            for(int j = 1; j<t.getVet().length; j++){
                if(t.getVet()[i][j] == 0){
                    g.drawRect(t.getVet()[i][0], t.getVet()[0][j], t.getQuadrado(), t.getQuadrado());
                }
                if(t.getVet()[i][j] != 0){
                    g.fillRect(t.getVet()[i][0], t.getVet()[0][j], t.getQuadrado()+1, t.getQuadrado()+1);
                }
            }
        }
        for (int i = 0; i < peao.length; i++) {
          g.drawImage(peao[i].getIcon(), peao[i].getPosAtualX(), peao[i].getPosAtualY(), null);  
        }
        for (int i = 0; i < torre.length; i++) {
          g.drawImage(torre[i].getIcon(), torre[i].getPosAtualX(), torre[i].getPosAtualY(), null);  
        }
        for (int i = 0; i < cavalo.length; i++) {
          g.drawImage(cavalo[i].getIcon(), cavalo[i].getPosAtualX(), cavalo[i].getPosAtualY(), null);  
        }
        for (int i = 0; i < bispo.length; i++) {
          g.drawImage(bispo[i].getIcon(), bispo[i].getPosAtualX(), bispo[i].getPosAtualY(), null);  
        }
        for (int i = 0; i < rainha.length; i++) {
          g.drawImage(rainha[i].getIcon(), rainha[i].getPosAtualX(), rainha[i].getPosAtualY(), null);  
        }
        for (int i = 0; i < rei.length; i++) {
          g.drawImage(rei[i].getIcon(), rei[i].getPosAtualX(), rei[i].getPosAtualY(), null);  
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
