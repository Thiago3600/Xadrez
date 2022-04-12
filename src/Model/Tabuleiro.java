package Model;



public class Tabuleiro{
    
    private int[][] vet;
    public int[][] todasPecas;
    private int tamanho = 9, alturaQuadrado = -60, larguraQuadrado = -60, quadrado = 60;
    private static int TURNO = 0;
    
    public Tabuleiro(){
        vet = new int[getTamanho()][getTamanho()];
        
        //Colocar altura dos quadrados
        for(int i = 0; i < vet.length; i++){
            
            vet[i][0] = getAlturaQuadrado();
            setAlturaQuadrado(getAlturaQuadrado()+getQuadrado());
            
        }
        
        //Colocar largura dos quadrados
        for(int i = 0; i < vet.length; i++){
            
            vet[0][i] = getLarguraQuadrado();
            setLarguraQuadrado(getLarguraQuadrado()+getQuadrado());
            
        }
        
        for (int i = 1; i < vet.length; i++) {
            for (int j = 1; j < vet.length; j++) {
                if( (i % 2) == (j % 2)){
                    vet[i][j] = 0;
                    
                } else {
                    vet[i][j] = 1;
                }
            }
        }
        //System.out.println(vet.length);
        
        //todasPecas = new int[32][0] tipo de peca
        //todasPecas = new int[32][1] indice da peca
        //todasPecas = new int[32][2] endereço X
        //todasPecas = new int[32][3] endereço Y
        //todasPecas = new int[32][4] Cor
        
        todasPecas = new int[32][5]; 
        
    }
    
    
    public void imprimePeca(int peca, int indice, int x, int y, int cor){
        String pc = null, c = null;
        
        if (peca == 0) {
            pc = "Peão";
        }
        if (peca == 1) {
            pc = "Torre";
        }
        if (peca == 2) {
            pc = "Cavalo";
        }
        if (peca == 3) {
            pc = "Bispo";
        }
        if (peca == 4) {
            pc = "Rainha";
        }
        if (peca == 5) {
            pc = "Rei";
        }
        if(cor==0){
            c = "Branca";
        } else if(cor == 1){
            c = "Preto";
        }
        System.out.println("--------------------------");
        System.out.println("Peca: " + pc);
        System.out.println("Indice " + todasPecas[indice][1]);
        System.out.println("Endereço: ["+x+"]["+y+"]");
        System.out.println("Cor " + c);
        System.out.println("--------------------------");

        
    }
    
    public int[] pegaIndice(int[] click){
        
        int[] indice = new int[2];
        
        for (int i = 0; i < vet.length; i++) {
            if (click[0]>=vet[i][0]&&click[0]<=vet[i][0]+getQuadrado()) {
                  indice[0] = i;
            }
        }
        for (int i = 0; i < vet.length; i++) {
            if (click[1]>=vet[0][i]&&click[1]<=vet[0][i]+getQuadrado()) {
                indice[1] = i;
            }
        }
        
        
        return indice;
    }
    
    public int peaoLoc(int[] index, Peao[] peao) {

        int indPeao = -1;

        for (int i = 0; i < peao.length; i++) {
            if (peao[i].getIndexX() == index[0] && peao[i].getIndexY() == index[1]) {
                indPeao = i;
            }
        }
        return indPeao;
    }
    
    public int torreLoc(int[] index, Torre[] torre){
        
        int indTorre = -1;
        
        for (int i = 0; i < torre.length; i++) {
            if (torre[i].getIndexX() == index[0] && torre[i].getIndexY() == index[1]) {
                indTorre = i;
            }
        }
        
        return indTorre;
    }
    public int bispoLoc(int[] index, Bispo[] bispo){
        
        int indBispo = -1;
        
        for (int i = 0; i < bispo.length; i++) {
            if (bispo[i].getIndexX() == index[0] && bispo[i].getIndexY() == index[1]) {
                indBispo = i;
            }
        }
        
        return indBispo;
    }
    
    public int cavaloLoc(int[] index, Cavalo[] cavalo){
        
        int indCavalo = -1;
        
        for (int i = 0; i < cavalo.length; i++) {
            if (cavalo[i].getIndexX() == index[0] && cavalo[i].getIndexY() == index[1]) {
                indCavalo = i;
            }
        }
        
        return indCavalo;
    }
    public int rainhaLoc(int[] index, Rainha[] rainha){
        
        int indRainha = -1;
        
        for (int i = 0; i < rainha.length; i++) {
            if (rainha[i].getIndexX() == index[0] && rainha[i].getIndexY() == index[1]) {
                indRainha = i;
            }
        }
        
        return indRainha;
    }
    public int reiLoc(int[] index, Rei[] rei){
        
        int indRei = -1;
        
        for (int i = 0; i < rei.length; i++) {
            if (rei[i].getIndexX() == index[0] && rei[i].getIndexY() == index[1]) {
                indRei = i;
            }
        }
        
        return indRei;
    }
    
    

    public int[][] getVet() {
        return vet;
    }

    

    public int getAlturaQuadrado() {
        return alturaQuadrado;
    }

    public void setAlturaQuadrado(int alturaQuadrado) {
        this.alturaQuadrado = alturaQuadrado;
    }

    public int getLarguraQuadrado() {
        return larguraQuadrado;
    }

    public void setLarguraQuadrado(int larguraQuadrado) {
        this.larguraQuadrado = larguraQuadrado;
    }
    
    public int getQuadrado() {
        return quadrado;
    }

    public void setQuadrado(int quadrado) {
        this.quadrado = quadrado;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public static int getTURNO() {
        return TURNO;
    }

    public static void setTURNO(int TURNO) {
        Tabuleiro.TURNO = TURNO;
    }

    public int[][] getTodasPecas() {
        return todasPecas;
    }

    public void setTodasPecas(int[][] todasPecas) {
        this.todasPecas = todasPecas;
    }

    

    

    
        
    
    
}
