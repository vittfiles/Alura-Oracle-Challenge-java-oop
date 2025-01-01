import javax.swing.text.html.Option;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.US);
        int option = 0;
        double value = 0;
        ExchangeQuery exchangeQuery = new ExchangeQuery();
        OptionsExchange optionsExchange = new OptionsExchange();
        String welcomeMsg = """
                ******************************************************
                Sea bienvenido/a al Conversor de Monedas =]""";
        String optionsMsg = """
                
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real Brasileño
                4) Real Brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción válida
                ******************************************************""";

        System.out.println(welcomeMsg);

        while(option != 7){
            System.out.println(optionsMsg);

            try{
                option = Integer.parseInt(input.nextLine());

                if(option == 7){
                    break;
                }

                if(option >= 1 && option <= optionsExchange.getLimit()){
                    System.out.println("\nIngrese el valor que desea convertir:");
                    value = Double.parseDouble(input.nextLine());

                    String from = optionsExchange.getFrom(option-1);
                    String to = optionsExchange.getTo(option-1);
                    double result = exchangeQuery.exchange(from, to, value);

                    if(result != -1){
                        System.out.println("El valor "+value+" ["+from+"]"+" corresponde al valor final de =>>> "+result+" ["+to+"]");
                    }
                }
            }catch (NumberFormatException e){
                System.out.println("*** Ingrese un número entero o con punto para separar la parte decimal ***");
            }
        }

        input.close();
    }
}