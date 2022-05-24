public class App {

    public static void main(String[] args) {

        Repositorio repositorio = new Repositorio();

        PartidaGc partidaGc = new PartidaGc(1, "02/07/2021", 10000, "xispeke1", "22/15/9", 105.5);
        PartidaGc partidaGc1 = new PartidaGc(2, "03/07/2021", 10000, "xispeke1", "09/20/4", 065.8);
        PartidaGc partidaGc2 = new PartidaGc(3, "12/10/2022", 10000, "xispeke1", "35/12/6", 116.7);
        PartidaGc partidaGc3 = new PartidaGc(4, "22/05/2022", 10000, "xispeke1", "29/18/12", 120.3);

        repositorio.save(partidaGc);
        repositorio.save(partidaGc1);
        repositorio.save(partidaGc2);
        repositorio.save(partidaGc3);

        if (repositorio.exportTXT("Partidas")) {
            System.out.println("Arquivo txt gerado com sucesso");
        } else{
            System.out.println("Erro ao gravar arquivo txt");
        }
    }
}
