public class Carteira {
    //Variaveis
    private int idCarteira;
    private String nomeCarteira;
    private String senhaAcesso; //String pois accesso digital alfa-numerico
    private Cartao cartaoDebito;
    private Cartao cartaoCredito;

    public Carteira(int idCarteira, String nomeCarteira, String senhaAcesso, Cartao cartaoDebito, Cartao cartaoCredito)
    {
        this.idCarteira    = idCarteira;
        this.nomeCarteira  = nomeCarteira;
        if(!(senhaAcesso.length() >= 8 && senhaAcesso.length() <= 16)) {
            System.out.println("Sua senha deve conter de 8 a 16 caracteres");
            System.err.println("SENHA INCORRETA NA CRIACAO DE CONTA");
            System.exit(1);
        }
        this.senhaAcesso   = senhaAcesso;
        this.cartaoDebito  = cartaoDebito;
        this.cartaoCredito = cartaoCredito;
    }

    //Funcao generica verificacao senha
    private boolean checkSenha(String senhaAcesso,String msg_sucesso){
        if (senhaAcesso == this.senhaAcesso) {
            if (msg_sucesso != "")
                System.out.println(msg_sucesso);
            return true;
        }
        else
            System.out.println("Senha incorreta");
        return false;
    }

    public int getIdCarteira() {
        return idCarteira;
    }

    public String getNomeCarteira() {
        return nomeCarteira;
    }

    public void setSenhaAcesso(String senhaAcessoAntiga, String senhaAcessoNova) {
        if (checkSenha(senhaAcessoAntiga,"Senha alterada com sucesso") && (senhaAcessoNova.length() >= 8 && senhaAcessoNova.length() <= 16))
            this.senhaAcesso = senhaAcessoNova;
        else
            if(!(senhaAcessoNova.length() >= 8 && senhaAcessoNova.length() <= 16))
                System.out.println("Sua senha deve conter de 8 a 16 caracteres");
    }

    public Cartao getCartaoDebito() {
        return cartaoDebito;
    }

    public void setCartaoDebito(String senhaAcesso, Cartao cartaoDebito) {
        if (checkSenha(senhaAcesso,"") && cartaoDebito != null && cartaoDebito.getTipo() == "Debito")
            this.cartaoDebito = cartaoDebito;
        else
            if(!(cartaoDebito != null && cartaoDebito.getTipo() == "Debito"))
                System.out.println("Cartao Invalido");
    }

    public Cartao getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String senhaAcesso, Cartao cartaoCredito) {
        if (checkSenha(senhaAcesso,"") && cartaoCredito != null && cartaoCredito.getTipo() == "Credito")
            this.cartaoCredito = cartaoCredito;
        else
            if(!(cartaoCredito != null && cartaoCredito.getTipo() == "Credito"))
                System.out.println("Cartao Invalido");
    }


}
