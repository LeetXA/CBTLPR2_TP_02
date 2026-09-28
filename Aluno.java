// ADS 471 - Fernanda Cristina Oliveira Pinheiro e Letícia Amaral Xavier
// Exercicío 01: Desenvolver o seguinte sistema, empregando os conhecimentos adquiridos nas aulas sobre interfaces gráficas em java.

import java.util.UUID;

public class Aluno {

    private String endereco;
    private int idade;
    private String nome;
    private UUID uuid;

    // Construtor
    public Aluno() {
        this.uuid = UUID.randomUUID();
    }

    // Getter e Setter do endereço
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Getter e Setter da idade
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    // Getter e Setter do nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Getter e Setter do UUID
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}