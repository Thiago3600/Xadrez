package View;

import javax.swing.JFrame;

public class Janela {

    public Janela(int width, int height, String title) {

        JFrame frame = new JFrame();
        


        frame.add(new Desenha(width, height));
        frame.add(new Movimento(width, height));

        frame.setSize(width, height);
        frame.setTitle(title);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);

    }
}
