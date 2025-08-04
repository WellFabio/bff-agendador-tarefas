package com.extremebikebffagendadortarefas.infrastructure.client;


import com.extremebikebffagendadortarefas.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificacao", url = "${notificacao.url}")
public interface EmailClient {

    void enviaEmail(@RequestBody TarefasDTOResponse dto);

}
