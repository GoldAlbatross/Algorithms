package trash.interfase;

public class Test {

    public static void main(String[] args) {
        Interface anonimclass = new Interface (){
            @Override
            public void m() {
                System.out.println("Implementation one");
            }
        };
        anonimclass.m();
    }


    interface Interface {
        public void m();
    }
}
