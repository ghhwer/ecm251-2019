public class Usuario {

    private String nome;
    private String email;
    private String cpf;
    private String nascimento;
    private Carteira carteira;

    public Usuario(String nome, String email, String cpf, String nascimento, Carteira carteira){
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.nascimento = nascimento;
        this.carteira = carteira;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public Carteira getCarteira() {
        return carteira;
    }

}
