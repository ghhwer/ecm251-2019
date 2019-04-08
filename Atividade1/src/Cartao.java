public class Cartao {
    private double taxaConversaoDolar;
    private int idCartao;
    private String label;
    private String emissorCartao;
    private String tipo;
    private String dataEmissao;
    private String validade;
    private int ccv;
    private String senha;
    private String numeroCartao; //String pois numero muito grande
    private int numeroConta;
    private String registros = "";

    public Cartao(double taxaConversaoDolar, int idCartao, String label, String emissorCartao, String tipo, String dataEmissao, String validade, int ccv, String senha, String numeroCartao, int numeroConta){
        this.taxaConversaoDolar = taxaConversaoDolar;
        this.idCartao = idCartao;
        this.label = label;
        this.emissorCartao = emissorCartao;
        this.tipo = tipo;
        this.dataEmissao = dataEmissao;
        this.validade = validade;
        this.ccv = ccv;
        if(!(senha.length() == 6)) {
            System.out.println("Sua senha deve conter de 6 DIGITOS");
            System.err.println("SENHA INCORRETA NA CRIACAO DE CARTAO");
            System.exit(1);
        }
        this.senha = senha;
        this.numeroCartao = numeroCartao;
        this.numeroConta = numeroConta;
    }

    //Funcao generica verificacao senha
    private boolean checkSenha(String senhaAcesso,String msg_sucesso){
        if (senhaAcesso == this.senha) {
            if (msg_sucesso != "")
                System.out.println(msg_sucesso);
            return true;
        }
        else
            System.out.println("Senha incorreta");
        return false;
    }

    public String getRegistros(){
        return this.registros;
    }

    public boolean regEntrada(Usuario saida, boolean useCreditoSaida, String senhaSaida, double vlrTransac, Usuario entrada) {
        Cartao cartaoSaida;
        Cartao cartaoDestino = this;
        if (useCreditoSaida)
            cartaoSaida = saida.getCarteira().getCartaoCredito();
        else
            cartaoSaida = saida.getCarteira().getCartaoDebito();
        if (cartaoSaida == null) {
            System.out.println("Usuario de saida não possui cartao do tipo especificado");
            return false;
        }
        if(cartaoSaida.regSaida(entrada, cartaoDestino,senhaSaida,vlrTransac)) {
            cartaoDestino.registros += "ENTRADA - DE:" + saida.getNome() + " CONTA:" + cartaoSaida.getNumeroConta() + " no valor de R$" + vlrTransac + "\n";
            return true;
        }
        else{
            System.out.println("Erro durante registro de saida de: "+ saida.getNome() + " com conta:" + cartaoSaida.getNumeroConta());
        }
        return false;
    }

    public boolean regSaida(Usuario entrada, Cartao cartaoEntrada, String senhaAcesso, double vlrTransac){
        if(checkSenha(senhaAcesso,"")){
            this.registros += "SAIDA - PARA:" + entrada.getNome() + " CONTA:" + cartaoEntrada.getNumeroConta() + " no valor de R$" + vlrTransac + "\n";
            return true;
        }
        else
            return false;
    }

    public double getTaxaConversaoDolar() {
        return taxaConversaoDolar;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public String getLabel() {
        return label;
    }

    public String getEmissorCartao() {
        return emissorCartao;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getValidade() {
        return validade;
    }

    public boolean validadeCcv(int ccv) {
        if (ccv == this.ccv)
            return true;
        else
            System.out.println("Codigo Invalido");
        return false;
    }

    public void setSenha(String senhaAcessoAntiga, String senhaAcessoNova) {
        if (checkSenha(senhaAcessoAntiga,"Senha alterada com sucesso") && (String.valueOf(senhaAcessoNova).length() == 6))
            this.senha = senhaAcessoNova;
        else
            if (!(senhaAcessoNova.length() == 6))
                System.out.println("Sua senha deve conter de 6 digitos");
    }

    public String getNumeroCartao() {
        return new String("xxxx-xxxx-xxxx-"+numeroCartao.substring(String.valueOf(numeroCartao).length()-4,String.valueOf(numeroCartao).length()));
    }

    public int getNumeroConta() {
        return numeroConta;
    }

}
