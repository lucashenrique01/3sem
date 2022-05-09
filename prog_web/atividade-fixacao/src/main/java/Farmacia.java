import java.util.ArrayList;
import java.util.List;

public class Farmacia {

    List<Remedio> remedios;

    public Farmacia() {
        remedios = new ArrayList<>();
    }

    public void addRemedio(Remedio r){
        this.remedios.add(r);
    }


    public String remedioPorTarja(){
        StringBuilder tarjaVermelha = new StringBuilder();
        StringBuilder tarjaPreta = new StringBuilder();
        StringBuilder genericos = new StringBuilder();
        for(Remedio r : remedios){
            if(r instanceof TarjaPreta){
                tarjaPreta.append(r);
            }
            else if(r instanceof TarjaVermelha){
                tarjaVermelha.append(r);
            }
            else {
                genericos.append(r);
            }
        }
        return tarjaVermelha;  //to-do
    }

    //to-do
    public Double totalVendas(){
        Double total = 0.0;
        for(Remedio r : remedios){

        }
        return total;
    }
}
