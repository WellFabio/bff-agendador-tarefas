package com.extremebikebffagendadortarefas.business;


import com.extremebikebffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.extremebikebffagendadortarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;

    public void enviaEmail(TarefasDTOResponse dto){

        emailClient.enviaEmail(dto);
    }


}
