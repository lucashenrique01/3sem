package sptech.projetojpa06.rest.mockapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "mockapi", url ="https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/")
public interface ClientMockApi {

    @GetMapping("/racas/{idRaca}")
    RacaResposta getRaca(@PathVariable String idRaca);

    @PostMapping
    void postLog(@RequestBody LogResposta log);

}
