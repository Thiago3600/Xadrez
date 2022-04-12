package View;

import Model.Bispo;
import Model.Cavalo;
import Model.Peao;
import Model.Rainha;
import Model.Rei;
import Model.Tabuleiro;
import Model.Torre;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;


public class Movimento extends JPanel implements Runnable, MouseListener{
    
    Thread th;
    Desenha d;
    Tabuleiro tab;
    Peao[] peao;
    Torre[] torre;
    Cavalo[] cavalo;
    Bispo[] bispo;
    Rainha[] rainha;
    Rei[] rei;
    boolean mousePressionado = false;
    int[] clickInicial, clickRealeased, index, indexFinal;
    
    public Movimento(int width, int height){
        addMouseListener(this);
        
        clickInicial = new int[2];
        clickRealeased = new int[2];
        index = new int[2];
        
        for (int i = 0; i < 2; i++) {
            clickInicial[i] = 0;
            clickRealeased[i] = 0;
        }
        
        th = new Thread(this);
        d = new Desenha(width, height);
        tab = new Tabuleiro();

        inicioPecas();
        
        th.start();
    }
    
    public void inicioPecas(){
        
        peao = new Peao[16];
        torre = new Torre[4];
        cavalo = new Cavalo[4];
        bispo = new Bispo[4];
        rainha = new Rainha[2];
        rei = new Rei[2];
        
        
        
        
        // peao 0
        for(int i = 0; i<peao.length; i++){
            if(i<peao.length/2){
                peao[i] = new Peao(0, i+1, 7, tab);
            } else {
                peao[i] = new Peao(1, (i+1-(peao.length/2)), 2, tab);
            }
            
        }
        //torre 1
        torre[0] = new Torre(0, 1, 8, tab);
        torre[1] = new Torre(0, 8, 8, tab);
        torre[2] = new Torre(1, 1, 1, tab);
        torre[3] = new Torre(1, 8, 1, tab);
        
        // cavalo 2
        cavalo[0] = new Cavalo(0, 2, 8, tab);
        cavalo[1] = new Cavalo(0, 7, 8, tab);
        cavalo[2] = new Cavalo(1, 2, 1, tab);
        cavalo[3] = new Cavalo(1, 7, 1, tab);
        // bispo 3
        bispo[0] = new Bispo(0, 3, 8, tab);
        bispo[1] = new Bispo(0, 6, 8, tab);
        bispo[2] = new Bispo(1, 3, 1, tab);
        bispo[3] = new Bispo(1, 6, 1, tab);
        // rainha 4
        rainha[0] = new Rainha(0, 4, 8, tab);
        rainha[1] = new Rainha(1, 4, 1, tab);
        // rei 5
        rei[0] = new Rei(0, 5, 8, tab);
        rei[1] = new Rei(1, 5, 1, tab);
        
        atualizaCoorPecas();
    }
    
    public void atualizaCoorPecas(){
        int pc = 0;
        int j = 0;
        for (int i = 0; i < 6; i++) {

            if (i == 0) {
                pc = peao.length;
            }
            if (i == 1) {
                pc = torre.length;
            }
            if (i == 2) {
                pc = cavalo.length;
            }
            if (i == 3) {
                pc = bispo.length;
            }
            if (i == 4) {
                pc = rainha.length;
            }
            if (i == 5) {
                pc = rei.length;
            }

            for (int k = 0; k < pc; j++, k++) {
                tab.todasPecas[j][0] = i;
                tab.todasPecas[j][1] = k;
                if (i == 0) {
                    tab.todasPecas[j][2] = peao[k].getIndexX();
                    tab.todasPecas[j][3] = peao[k].getIndexY();
                    tab.todasPecas[j][4] = peao[k].getCor();
                }
                if (i == 1) {
                    tab.todasPecas[j][2] = torre[k].getIndexX();
                    tab.todasPecas[j][3] = torre[k].getIndexY();
                    tab.todasPecas[j][4] = torre[k].getCor();
                }
                if (i == 2) {
                    tab.todasPecas[j][2] = cavalo[k].getIndexX();
                    tab.todasPecas[j][3] = cavalo[k].getIndexY();
                    tab.todasPecas[j][4] = cavalo[k].getCor();
                }
                if (i == 3) {
                    tab.todasPecas[j][2] = bispo[k].getIndexX();
                    tab.todasPecas[j][3] = bispo[k].getIndexY();
                    tab.todasPecas[j][4] = bispo[k].getCor();
                }
                if (i == 4) {
                    tab.todasPecas[j][2] = rainha[k].getIndexX();
                    tab.todasPecas[j][3] = rainha[k].getIndexY();
                    tab.todasPecas[j][4] = rainha[k].getCor();
                }
                if (i == 5) {
                    tab.todasPecas[j][2] = rei[k].getIndexX();
                    tab.todasPecas[j][3] = rei[k].getIndexY();
                    tab.todasPecas[j][4] = rei[k].getCor();
                }
            }

        }
        
    }
    
    public void point() {
        Point ponto = getMousePosition();
        index = tab.pegaIndice(clickInicial);
        indexFinal = tab.pegaIndice(clickRealeased);
        
        
        if(tab.peaoLoc(index, peao) >=0){
           
            peao[tab.peaoLoc(index, peao)].mover(ponto, mousePressionado, indexFinal, tab);
            
        } 
        else if(tab.torreLoc(index, torre) >= 0){
            torre[tab.torreLoc(index, torre)].mover(ponto, mousePressionado, indexFinal, tab);
        } 
        else if(tab.cavaloLoc(index, cavalo) >= 0){
            cavalo[tab.cavaloLoc(index, cavalo)].mover(ponto, mousePressionado, indexFinal, tab);
        }
        else if(tab.bispoLoc(index, bispo) >= 0){
            bispo[tab.bispoLoc(index, bispo)].mover(ponto, mousePressionado, indexFinal, tab);
        }
        else if(tab.rainhaLoc(index, rainha) >= 0){
            rainha[tab.rainhaLoc(index, rainha)].mover(ponto, mousePressionado, indexFinal, tab);
        }
        else if(tab.reiLoc(index, rei) >= 0){
            rei[tab.reiLoc(index, rei)].mover(ponto, mousePressionado, indexFinal, tab);
        }
        atualizaCoorPecas();
        
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        
        d.desenhaTabuleiro(g, tab, peao, torre, cavalo, bispo, rainha, rei);
    }

    @Override
    public void run() {
        while (true) {
            tick();
            repaint();
        }
    }

    private void tick() {
        
            point();
        
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        clickInicial[0] = e.getX();
        clickInicial[1] = e.getY();
        clickRealeased[0] = 0;
        clickRealeased[1] = 0;
        
        
        setMousePressionado(true);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
        clickRealeased[0] = e.getX();
        clickRealeased[1] = e.getY();
        
        
        
        setMousePressionado(false);
        
        
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    public boolean isMousePressionado() {
        return mousePressionado;
    }

    public void setMousePressionado(boolean mousePressionado) {
        this.mousePressionado = mousePressionado;
    }

    public int[] getClickRealeased() {
        return clickRealeased;
    }

    public void setClickRealeased(int[] clickRealeased) {
        this.clickRealeased = clickRealeased;
    }
    
    
    
    
}
