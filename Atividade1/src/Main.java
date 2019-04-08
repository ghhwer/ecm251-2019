public class Main {

    public static void main(String[] args) {
        Usuario u1,u2;
        Carteira c1, c2;
        Cartao cd1,cd2,cc2;
        //Cria Cartoes
        cd1 = new Cartao(0.666,1,"Visa","Ttau","Debito","14/03/2019","14/03/2024",669,"123456","1234567845261875",300351);
        cd2 = new Cartao(0.69,2,"Visa","Brazzers","Debito","20/04/2019","20/04/2024",666,"654321","6969696969696969",300352);
        cc2 = new Cartao(0.024,3,"MasterCard","Nubank","Credito","15/01/2019","15/01/2024",420,"010101","4204204204204201",300353);
        //Cria Carteira
        c1 = new Carteira(1,"Olla","laksh@#4",cd1,null);
        c2 = new Carteira(2,"Durex","jiçls@#7",cd2,cc2);
        //Cria Usuario
        u1 = new Usuario("Sasha Gray","sasha.gray@brazzers.com","45287945684","14/03/1988",c1);
        u2 = new Usuario("Lilly Ford","lilly.ford@brazzers.com","45287945684","07/06/1995",c2);

        // Fazer Transacoes
        u2.getCarteira().getCartaoDebito().regEntrada(u1,false,"123456",500.00,u2);

        System.out.println("Extrato de "+u2.getNome());
        System.out.println(u2.getCarteira().getCartaoDebito().getRegistros());
        System.out.println("Extrato de "+u1.getNome());
        System.out.println(u1.getCarteira().getCartaoDebito().getRegistros());
    }
}
