package Model;


import java.awt.Image;
import javax.swing.ImageIcon;


public class Pecas{
    
    ImageIcon Icon;
    private int iconWidth, iconHeight, cor, indexX, indexY, posAtualX, posAtualY;
    protected int[] tabX, tabY;
    private boolean movendo = false;
    
    
    private final int quadrado = 60; 
    private int posIndexX, posIndexY;
    
    public Pecas(){}
    
    public boolean verificaObstaculoX(int[] clickFinal, Tabuleiro tab) {

        boolean ok = false;
        int idX = tab.getTamanho();
        int idY = 0;
        boolean dir = false;

        for (int i = 0; i < tab.todasPecas.length; i++) {

            if (tab.todasPecas[i][3] == getIndexY() && getIndexX() != tab.todasPecas[i][2]) {
                if (tab.todasPecas[i][2] >= getIndexX()) {
                    if (tab.todasPecas[i][2]<=idX) {
                        idX = tab.todasPecas[i][2];
                        idY = tab.todasPecas[i][3];
                    }
                }
                if (tab.todasPecas[i][2] <= getIndexX()) {
                    if (tab.todasPecas[i][2] >= idY) {
                        dir = true;
                        
                        idY = tab.todasPecas[i][2];
                        idX = tab.todasPecas[i][3];
                    }
                }

            }
        }
        if (dir) {
            int temp = idY;
                idY = idX;
                idX = temp;
            
        }
        
        
        if (!dir&&clickFinal[0]<idX) {
            ok = true;
        } else if(dir&&clickFinal[0]>idX){
            ok = true;
        }
        
        return ok;
    }

    public boolean verificaObstaculoY(int[] clickFinal, Tabuleiro tab) {

        boolean ok = false;
        int idY = tab.getTamanho();
        int idX = 0;
        boolean dir = false;

        for (int i = 0; i < tab.todasPecas.length; i++) {

            if (tab.todasPecas[i][2] == getIndexX() && getIndexY() != tab.todasPecas[i][3]) {
                if (tab.todasPecas[i][3] >= getIndexY()) {
                    if (tab.todasPecas[i][3]<=idY) {
                        idX = tab.todasPecas[i][2];
                        idY = tab.todasPecas[i][3];
                    }
                    //tab.imprimePeca(tab.todasPecas[i][0], tab.todasPecas[i][1], tab.todasPecas[i][2], tab.todasPecas[i][3], tab.todasPecas[i][4]);
                }
                if (tab.todasPecas[i][3] <= getIndexY()) {
                    if (tab.todasPecas[i][3]>=idX) {
                        dir = true;
                        
                        idY = tab.todasPecas[i][2];
                        idX = tab.todasPecas[i][3];
                    }
                }

            }
        }
        if (dir) {
            int temp = idY;
                idY = idX;
                idX = temp;
            
        }
        
        
        if (!dir&&clickFinal[1]<idY) {
            ok = true;
        } else if(dir&&clickFinal[1]>idY){
            ok = true;
        }
        
        return ok;
    }
    
    public boolean obstaculoDiagonal(int[] clickFinal, Tabuleiro tab) {
        boolean ok = false;
        boolean dir = false;
        int idX = tab.getTamanho(), idY = 0;

        for (int i = 0; i < tab.todasPecas.length; i++) {
            if (getIndexX() + getIndexY() == tab.todasPecas[i][2] + tab.todasPecas[i][3]) {
                if (getIndexX() != tab.todasPecas[i][2] && getIndexY() != tab.todasPecas[i][3]) {
                    if (tab.todasPecas[i][2] >= getIndexX()) {
                        if (tab.todasPecas[i][2] <= idX) {
                            idX = tab.todasPecas[i][2];
                            idY = tab.todasPecas[i][3];
                        }
                    }
                    if (tab.todasPecas[i][2] <= getIndexX()) {
                        if (tab.todasPecas[i][2] >= idY) {
                            dir = true;

                            idY = tab.todasPecas[i][2];
                            idX = tab.todasPecas[i][3];
                        }
                    }

                }

            }
        }
        
        
        if (dir) {
            int temp = idY;
                idY = idX;
                idX = temp;
            
        }
        System.out.println("Peca ["+idX+"]["+idY+"]");
        if (!dir&&clickFinal[0]<idX) {
            ok = true;
        }
        if(dir&&clickFinal[0]>idX){
            ok = true;
        }

        return ok;
    }
    public boolean obstaculoPerpendicular(int[] clickFinal, Tabuleiro tab) {
        boolean ok = false;
        boolean dir = false;
        int idX = tab.getTamanho(), idY = 0;

        for (int i = 0; i < tab.todasPecas.length; i++) {
            if (getIndexX() - getIndexY() == tab.todasPecas[i][2] - tab.todasPecas[i][3]) {
                if (getIndexX() != tab.todasPecas[i][2] && getIndexY() != tab.todasPecas[i][3]) {
                    if (tab.todasPecas[i][2] >= getIndexX()) {
                        if (tab.todasPecas[i][2] <= idX) {
                            idX = tab.todasPecas[i][2];
                            idY = tab.todasPecas[i][3];
                        }
                    }
                    if (tab.todasPecas[i][2] <= getIndexX()) {
                        if (tab.todasPecas[i][2] >= idY) {
                            dir = true;
                            idY = tab.todasPecas[i][2];
                            idX = tab.todasPecas[i][3];
                        }
                    }
                    tab.imprimePeca(tab.todasPecas[i][0], tab.todasPecas[i][1], tab.todasPecas[i][2], tab.todasPecas[i][3], tab.todasPecas[i][4]);
                }

            }
        }
        
        
        if (dir) {
            int temp = idY;
                idY = idX;
                idX = temp;
            
        }
        System.out.println("Peca ["+idX+"]["+idY+"]");
        if (!dir&&clickFinal[0]<idX) {
            ok = true;
        }
        if(dir&&clickFinal[0]>idX){
            ok = true;
        }

        return ok;
    }
    

    public int getQuadrado() {
        return quadrado;
    }

    

    public int getPosIndexX() {
        return posIndexX;
    }

    public void setPosIndexX(int posIndexX) {
        this.posIndexX = posIndexX;
    }

    public int getPosIndexY() {
        return posIndexY;
    }

    public void setPosIndexY(int posIndexY) {
        this.posIndexY = posIndexY;
    }

    public Image getIcon() {
        return Icon.getImage();
    }

    public void setIcon(ImageIcon Icon) {
        this.Icon = Icon;
    }

    public int getIconWidth() {
        return iconWidth;
    }

    public void setIconWidth(int iconWidth) {
        this.iconWidth = iconWidth;
    }

    public int getIconHeight() {
        return iconHeight;
    }

    public void setIconHeight(int iconHeight) {
        this.iconHeight = iconHeight;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getIndexX() {
        return indexX;
    }

    public void setIndexX(int indexX) {
        this.indexX = indexX;
    }

    public int getIndexY() {
        return indexY;
    }

    public void setIndexY(int indexY) {
        this.indexY = indexY;
    }

    public int getPosAtualX() {
        return posAtualX;
    }

    public void setPosAtualX(int indexX) {
       if (isMovendo()) {
            this.posAtualX = indexX;
        } else {
            for (int i = 1; i <= tabX.length; i++) {
                if (i == indexX) {
                    this.posAtualX = tabX[i] + ((getQuadrado() - getIconWidth()) / 2);
                }
            }
        }
    }

    public int getPosAtualY() {
        return posAtualY;
    }

    public void setPosAtualY(int indexY) {
        if (isMovendo()) {
            this.posAtualY = indexY;
        } else {
            for (int i = 1; i <= tabY.length; i++) {
                if (i == indexY) {
                    this.posAtualY = tabY[i] + ((getQuadrado() - getIconHeight()) / 2);
                }
            }
        }
    }

    public boolean isMovendo() {
        return movendo;
    }

    public void setMovendo(boolean movendo) {
        this.movendo = movendo;
    }
    
    
    
    
   

    
    
    
    
    
}
