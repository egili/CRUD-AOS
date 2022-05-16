package DAOs;

public class test {

    public static void main(String[] args) {

       Integer s = CRUDHelper.getDDDdoCidadao("19988631673");
        System.out.println("ddd " + s);

        Integer a = CRUDHelper.getNumerodoCidadao("19988631673");
        System.out.println("numero " + a);

        String p = CRUDHelper.getGeneroAsChar("masculino");
        System.out.println("g " + p);
    }
}
