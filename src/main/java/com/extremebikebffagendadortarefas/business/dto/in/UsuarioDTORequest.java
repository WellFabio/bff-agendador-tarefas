package com.extremebikebffagendadortarefas.business.dto.in;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UsuarioDTORequest {


    private String nome;
    private String email;
    private String senha;
    private List<EnderecoDTORequest> endereco;
    private List<TelefoneDTORequest> telefone;

}
