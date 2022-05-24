import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TesteRepositorio {

  @Test
  public void save(){
    PartidaGc temaLivreObjetoTest = new PartidaGc(1, "01-01-2022");

    Repositorio repositorioTest = new Repositorio();

    repositorioTest.save(temaLivreObjetoTest);

    assertEquals(1, repositorioTest.getContadorOperacoes());
    assertEquals(1, repositorioTest.getObjetosTemaLivre().size());
    assertEquals(1, repositorioTest.getObjetosTemaLivre().get(0).getId());
    assertEquals("01-01-2022", repositorioTest.getObjetosTemaLivre().get(0).getData());
    assertEquals(1, repositorioTest.getPilhaOperacao().peek());

  }

  @Test
  public void deleteById(){
    PartidaGc temaLivreObjetoTest01 = new PartidaGc(1, "01-01-2022");
    PartidaGc temaLivreObjetoTest02 = new PartidaGc(2, "02-01-2022");
    PartidaGc temaLivreObjetoTest03 = new PartidaGc(3, "03-01-2022");

    Repositorio repositorioTest = new Repositorio();

    repositorioTest.save(temaLivreObjetoTest01);
    repositorioTest.save(temaLivreObjetoTest02);
    repositorioTest.save(temaLivreObjetoTest03);

    repositorioTest.deleteById(1);

    assertEquals(2, repositorioTest.getObjetosTemaLivre().size());
    assertEquals(2, repositorioTest.getObjetosTemaLivre().get(0).getId());
    assertEquals("02-01-2022", repositorioTest.getObjetosTemaLivre().get(0).getData());

    assertThrows(IllegalArgumentException.class, () -> repositorioTest.deleteById(100));

  }

  @Test
  public void updateDate(){
    PartidaGc temaLivreObjetoTest01 = new PartidaGc(1, "01-01-2022");

    Repositorio repositorioTest = new Repositorio();

    repositorioTest.save(temaLivreObjetoTest01);
    repositorioTest.updateDate(1, "23-05-2022");

    assertEquals("23-05-2022", repositorioTest.getObjetosTemaLivre().get(0).getData());
    assertThrows(IllegalArgumentException.class, () -> repositorioTest.updateDate(100, "23-05-2022"));

  }

  @Test
  public void undo(){
    PartidaGc temaLivreObjetoTest01 = new PartidaGc(1, "01-01-2022");
    PartidaGc temaLivreObjetoTest02 = new PartidaGc(2, "02-01-2022");
    PartidaGc temaLivreObjetoTest03 = new PartidaGc(3, "03-01-2022");

    Repositorio repositorioTest = new Repositorio();

    repositorioTest.save(temaLivreObjetoTest01);
    repositorioTest.save(temaLivreObjetoTest02);
    repositorioTest.save(temaLivreObjetoTest03);

    repositorioTest.undo(2);

    assertEquals(1, repositorioTest.getContadorOperacoes());
    assertEquals(1, repositorioTest.getObjetosTemaLivre().size());
    assertEquals(1, repositorioTest.getObjetosTemaLivre().get(0).getId());
    assertEquals("01-01-2022", repositorioTest.getObjetosTemaLivre().get(0).getData());
    assertEquals(1, repositorioTest.getPilhaOperacao().peek());


    assertThrows(IllegalArgumentException.class, () -> repositorioTest.deleteById(100));

  }

  @Test
  public void delaySave(){
    PartidaGc temaLivreObjetoTest01 = new PartidaGc(1, "01-01-2022");
    PartidaGc temaLivreObjetoTest02 = new PartidaGc(2, "02-01-2022");
    PartidaGc temaLivreObjetoTest03 = new PartidaGc(3, "03-01-2022");

    Repositorio repositorioTest = new Repositorio();

    repositorioTest.delaySave(temaLivreObjetoTest01);
    repositorioTest.delaySave(temaLivreObjetoTest02);
    repositorioTest.delaySave(temaLivreObjetoTest03);

    assertEquals(1, repositorioTest.getFilaOperacao().peek().getId());
    assertEquals("01-01-2022", repositorioTest.getFilaOperacao().peek().getData());
  }

  @Test
  public void flush(){
    PartidaGc temaLivreObjetoTest01 = new PartidaGc(1, "01-01-2022");
    PartidaGc temaLivreObjetoTest02 = new PartidaGc(2, "02-01-2022");
    PartidaGc temaLivreObjetoTest03 = new PartidaGc(3, "03-01-2022");

    PartidaGc temaLivreObjetoTest04 = new PartidaGc(4, "04-01-2022");
    PartidaGc temaLivreObjetoTest05 = new PartidaGc(5, "05-01-2022");

    Repositorio repositorioTest = new Repositorio();

    repositorioTest.delaySave(temaLivreObjetoTest01);
    repositorioTest.delaySave(temaLivreObjetoTest02);
    repositorioTest.delaySave(temaLivreObjetoTest03);
    repositorioTest.save(temaLivreObjetoTest04);
    repositorioTest.save(temaLivreObjetoTest05);

    repositorioTest.flush();

    assertEquals(5, repositorioTest.getContadorOperacoes());
    assertEquals(5, repositorioTest.getObjetosTemaLivre().size());
    assertEquals(4, repositorioTest.getObjetosTemaLivre().get(0).getId());
    assertEquals("04-01-2022", repositorioTest.getObjetosTemaLivre().get(0).getData());
    assertEquals(3, repositorioTest.getPilhaOperacao().peek());
    assertTrue(repositorioTest.getFilaOperacao().isEmpty());
  }

}
