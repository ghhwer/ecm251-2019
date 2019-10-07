package model;

public class Jogo {
    public String nome, lancamento, genero, plataforma;
    public int id;

    public Jogo(String nome, String lancamento, String genero, String plataforma, int id) {
        this.nome = nome;
        this.lancamento = lancamento;
        this.genero = genero;
        this.plataforma = plataforma;
        this.id = id;
    }

    public Jogo(){}

    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + nome + '\'' +
                ", lancamento='" + lancamento + '\'' +
                ", genero='" + genero + '\'' +
                ", plataforma='" + plataforma + '\'' +
                ", id=" + id +
                '}';
    }
}
