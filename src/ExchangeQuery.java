import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ExchangeQuery {
    public double exchange(String base,String target,double value){
        try{
            File file = new File("apikey.txt");
            Scanner scan = new Scanner(file);
            String key = scan.nextLine();
            scan.close();

            URI url = new URI("https://v6.exchangerate-api.com/v6/"+key+"/pair/"+base+"/"+target+"/"+value);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(url).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            ConversionRate conversionRate = gson.fromJson(response.body(), ConversionRate.class);

            if(conversionRate.getErrorType() != null){
                System.out.println("Ocurrió un error al intentar conectarse a la API: "+conversionRate.getErrorType());
                return -1;
            }

            return conversionRate.getConversionResult();
        }catch (NullPointerException | FileNotFoundException | NoSuchElementException e){
            System.out.println("Debe crear un archivo apikey.txt en la base de el proyecto y agregarle la apikey sin espacions o acentuaciones");
            return -1;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
