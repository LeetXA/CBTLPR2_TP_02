// ADS 471 - Fernanda Cristina Oliveira Pinheiro e Letícia Amaral Xavier
// Exercicío 01: Desenvolver o seguinte sistema, empregando os conhecimentos adquiridos nas aulas sobre interfaces gráficas em java.

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TP02 extends JFrame {

    // Lista que armazena os alunos em memória
    private List<Aluno> alunos = new ArrayList<>();

    // Campos do formulário
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtEndereco;

    // Botões
    private JButton btnOk;
    private JButton btnLimpar;
    private JButton btnMostrar;
    private JButton btnSair;

    public TP02() {

        // Configurações da janela
        setTitle("TP02 - LP2");
        setSize(400, 180);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        // PAINEL SUPERIOR
        JPanel painelSuperior = new JPanel(new GridLayout(3, 2, 10, 10));
        painelSuperior.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblNome = new JLabel("Nome:");
        JLabel lblIdade = new JLabel("Idade:");
        JLabel lblEndereco = new JLabel("Endere\u00E7o:");

        txtNome = new JTextField();
        txtIdade = new JTextField();
        txtEndereco = new JTextField();

        painelSuperior.add(lblNome);
        painelSuperior.add(txtNome);

        painelSuperior.add(lblIdade);
        painelSuperior.add(txtIdade);

        painelSuperior.add(lblEndereco);
        painelSuperior.add(txtEndereco);

        // PAINEL INFERIOR
        JPanel painelInferior = new JPanel(new GridLayout(1, 4, 5, 5));
        painelInferior.setBorder(new EmptyBorder(0, 10, 10, 10));

        btnOk = new JButton("Ok");
        btnLimpar = new JButton("Limpar");
        btnMostrar = new JButton("Mostrar");
        btnSair = new JButton("Sair");

        painelInferior.add(btnOk);
        painelInferior.add(btnLimpar);
        painelInferior.add(btnMostrar);
        painelInferior.add(btnSair);

        // ORGANIZAÇÃO DA JANELA
        setLayout(new BorderLayout());

        add(painelSuperior, BorderLayout.CENTER);
        add(painelInferior, BorderLayout.SOUTH);

        // EVENTO DO BOTÃO OK
        btnOk.addActionListener(e -> cadastrarAluno());

        // EVENTO DO BOTÃO LIMPAR
        btnLimpar.addActionListener(e -> limparCampos());

        // EVENTO DO BOTÃO MOSTRAR
        btnMostrar.addActionListener(e -> mostrarAlunos());

        // EVENTO DO BOTÃO SAIR
        btnSair.addActionListener(e -> System.exit(0));
    }

    // MÉTODO PARA CADASTRAR UM ALUNO
    private void cadastrarAluno() {

        String nome = txtNome.getText().trim();
        String idadeTexto = txtIdade.getText().trim();
        String endereco = txtEndereco.getText().trim();

        // Verifica se os campos estão preenchidos
        if (nome.isEmpty() || idadeTexto.isEmpty() || endereco.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Preencha todos os campos.",
                    "Atenção",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int idade;

        try {

            idade = Integer.parseInt(idadeTexto);

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "A idade deve ser um número inteiro.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Verifica se a idade é válida
        if (idade <= 0) {

            JOptionPane.showMessageDialog(
                    this,
                    "A idade deve ser maior que zero.",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
            );

            return;
        }

        // Cria um novo aluno
        Aluno aluno = new Aluno();

        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setEndereco(endereco);

        // Adiciona o aluno na lista
        alunos.add(aluno);

        JOptionPane.showMessageDialog(
                this,
                "Aluno cadastrado com sucesso!",
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );

        // Limpa os campos depois do cadastro
        limparCampos();
    }

    // MÉTODO PARA LIMPAR OS CAMPOS
    private void limparCampos() {

        txtNome.setText("");
        txtIdade.setText("");
        txtEndereco.setText("");

        txtNome.requestFocus();
    }

    // MÉTODO PARA MOSTRAR OS ALUNOS
    private void mostrarAlunos() {

        if (alunos.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Nenhum aluno cadastrado.",
                    "Resultado",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        StringBuilder mensagem = new StringBuilder();

        mensagem.append("Resultado\n\n");

        for (Aluno aluno : alunos) {

            mensagem.append("Id: ")
                    .append(aluno.getUuid())
                    .append("  Nome: ")
                    .append(aluno.getNome())
                    .append("\n");
        }

        JOptionPane.showMessageDialog(
                this,
                mensagem.toString(),
                "Resultado",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // MÉTODO MAIN
    public static void main(String[] args) {

        TP02 tela = new TP02();

        tela.setVisible(true);
    }
}