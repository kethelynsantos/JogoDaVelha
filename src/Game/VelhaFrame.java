package Game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class VelhaFrame extends JFrame {

    private JButton[] button;
    private JButton novoJogo;
    private JLabel jogador1;
    private JLabel jogador2;
    private JLabel Pont1;
    private JLabel Pont2;
    private int jogador = 0;
    private int pnt1 = 0;
    private int pnt2 = 0;
    private JLabel guia;

    public void jogada(int bnt) {
        String XO;
        if (jogador == 0) {
            XO = "X";
            jogador = 1;
            guia.setText("Vez do Jogador 2");
        } else {
            XO = "O";
            jogador = 0;
            guia.setText("Vez do Jogador 1");

        }

        button[bnt].setText(XO); // Define o símbolo (X ou O) no tabuleiro
        button[bnt].setEnabled(false); // Desabilita o botão
        verifica(XO);
    }

    public boolean verifica(String XO) {

        //verificações horizontais
        if ((button[0].getText().equals(XO)) && (button[1].getText().equals(XO)) && (button[2].getText().equals(XO))) {
            // Se os botões nas posições 0, 1 e 2 tiverem o mesmo texto, eles ficam verdes
            button[0].setBackground(Color.green);
            button[1].setBackground(Color.green);
            button[2].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[3].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[5].getText().equals(XO))) {
            button[3].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[5].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[6].getText().equals(XO)) && (button[7].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[6].setBackground(Color.green);
            button[7].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }

        //verificaçoes verticais
        if ((button[0].getText().equals(XO)) && (button[3].getText().equals(XO)) && (button[6].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[3].setBackground(Color.green);
            button[6].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[1].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[7].getText().equals(XO))) {
            button[1].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[7].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[2].getText().equals(XO)) && (button[5].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[2].setBackground(Color.green);
            button[5].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }

        //verificações diagonais
        if ((button[0].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[8].getText().equals(XO))) {
            button[0].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[8].setBackground(Color.green);
            ganhou(XO);
            return true;
        }
        if ((button[2].getText().equals(XO)) && (button[4].getText().equals(XO)) && (button[6].getText().equals(XO))) {
            button[2].setBackground(Color.green);
            button[4].setBackground(Color.green);
            button[6].setBackground(Color.green);
            ganhou(XO);
            return true;
        }

        //verifica se deu velha
        if ((button[0].getText() != "   ") && (button[1].getText() != "   ") && (button[2].getText() != "   ") && (button[3].getText() != "   ") && (button[4].getText() != "   ") && (button[5].getText() != "   ") && (button[6].getText() != "   ") && (button[7].getText() != "   ") && (button[8].getText() != "   ")) {
            // Se todos os botões estiverem preenchidos, eles ficam vermelho.
            for (int i = 0; i < 9; i++) {
                button[i].setBackground(Color.red);
            }
            velha();
            return true;
        }
        return true;
    }

    public void velha() {
        // Desabilita todos os botões
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        novoJogo.setVisible(true); // Torna o botão visível
        guia.setText("Deu Velha"); // Atualiza a mensagem na label guia
    }

    public void ganhou(String XO) {
        // Desabilita todos os botões
        for (int i = 0; i < 9; i++) {
            button[i].setEnabled(false);
        }
        String texto; // Determina qual jogador venceu
        if (XO == "X") {
            texto = "Jogador 1 Venceu";
            pnt1++; // Incrementa o número de vitórias do Jogador 1
        } else {
            texto = "Jogador 2 Venceu";
            pnt2++; // Incrementa o número de vitórias do Jogador 2
        }
        // Atualiza as labels de pontuação
        Pont1.setText(Integer.toString(pnt1));
        Pont2.setText(Integer.toString(pnt2));
        novoJogo.setVisible(true); // Torna visível o botão novoJogo
        guia.setText(texto); // Atualiza a mensagem na guia
    }

    public void newGame() {
        novoJogo.setVisible(false); // Torna o botão "novoJogo" invisível
        guia.setText("Vez do Jogador 1");
        jogador = 0;
        // limpa os botões e reativa eles
        for (int i = 0; i < 9; i++) {
            button[i].setText("   ");
            button[i].setBackground(novoJogo.getBackground()); // Define a cor de fundo dos botões de volta
            button[i].setEnabled(true); // Reativa os botões
        }
    }

    public VelhaFrame() {
        super(); // Chama o construtor da classe pai
        setTitle("Jogo da Velha");
        Toolkit tk = Toolkit.getDefaultToolkit(); // Obtém o Toolkit padrão
        Dimension d = tk.getScreenSize();
        Box editBox = Box.createVerticalBox();
        Box[] box = new Box[8];
        button = new JButton[9];
        guia = new JLabel("Vez do Jogador 1");

        for (int i = 0; i < 8; i++) {
            box[i] = Box.createHorizontalBox();
        }
        for (int i = 0; i < 9; i++) {
            button[i] = new JButton("   ");
        }

        novoJogo = new JButton("Novo Jogo");
        novoJogo.setVisible(false);
        jogador1 = new JLabel();
        jogador2 = new JLabel();
        jogador1.setText("Jogador 1");
        jogador2.setText("Jogador 2");
        Pont1 = new JLabel();
        Pont2 = new JLabel();
        Pont1.setText("0");
        Pont2.setText("0");

        box[0].add(jogador1);
        box[0].add(Box.createHorizontalStrut(30));
        box[0].add(jogador2);
        box[1].add(Pont1);
        box[1].add(Box.createHorizontalStrut(30));
        box[1].add(Pont2);
        box[2].add(guia);
        box[3].add(button[0]);
        box[3].add(button[1]);
        box[3].add(button[2]);
        box[4].add(button[3]);
        box[4].add(button[4]);
        box[4].add(button[5]);
        box[5].add(button[6]);
        box[5].add(button[7]);
        box[5].add(button[8]);
        box[6].add(novoJogo);

        editBox.add(box[0]);
        editBox.add(box[1]);
        editBox.add(Box.createVerticalStrut(30));
        editBox.add(box[2]);
        editBox.add(box[3]);
        editBox.add(box[4]);
        editBox.add(box[5]);
        editBox.add(box[6]);
        editBox.add(box[7]);

        Container container = getContentPane();
        container.setLayout(new FlowLayout());
        container.add(editBox);
        setSize(230, 250);
        setLocation((d.width - 230) / 2, (d.height - 250) / 2);
        setVisible(true);

        button[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(0);
            }
        });
        button[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(1);
            }
        });
        button[2].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(2);
            }
        });
        button[3].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(3);

            }
        });
        button[4].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(4);
            }
        });
        button[5].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(5);
            }
        });
        button[6].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(6);
            }
        });
        button[7].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(7);
            }
        });
        button[8].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                jogada(8);
            }
        });
        novoJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                newGame();
            }
        });
    }
}
