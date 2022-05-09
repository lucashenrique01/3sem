package sptech.projetojpa01.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import sptech.projetojpa01.entidade.Salgadinho;
import sptech.projetojpa01.resposta.SalgadinhoSimplesResposta;

import java.util.List;

public interface SalgadinhoRepository
        extends JpaRepository<Salgadinho, Integer> {

    @Query("Select new sptech.projetojpa01.resposta.SalgadinhoSimplesResposta(s.codigo, s.nome) from Salgadinho s")
    List<SalgadinhoSimplesResposta> listaSimples();

    @Transactional
    @Modifying
    @Query("update Salgadinho s set s.preco = ?2 where s.codigo = ?1")
    void atualizarPreco(Integer preco, Double codigo);

    @Transactional
    @Modifying
    @Query("update Salgadinho s set s.preco = ?2, s.apimentado = ?3 where s.codigo = ?1")
    void atualizarPrecoApimentado(Integer codigo, Double preco, Boolean apimentado);
}
