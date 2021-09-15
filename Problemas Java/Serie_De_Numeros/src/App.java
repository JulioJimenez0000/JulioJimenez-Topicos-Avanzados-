public class App {
    public static void main(String[] args) throws Exception {

int a = 1;
int b = 2;
int Suma = 0;
int c = 0;


        System.out.println("Hola usuario, a continuacion se imprimiran los siguientes numeros");

System.out.println(a);
System.out.println(b);


while(c < 10){

    Suma = a + b;
    
    System.out.println(Suma);

    a = b; 
    b = Suma;
    c++;

    }
}

}
