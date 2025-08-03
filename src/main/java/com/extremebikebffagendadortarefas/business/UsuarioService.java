package com.extremebikebffagendadortarefas.business;


import com.extremebikebffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.extremebikebffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.extremebikebffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.extremebikebffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.extremebikebffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.extremebikebffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.extremebikebffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.extremebikebffagendadortarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor


public class UsuarioService {

    private final UsuarioClient client;


    public UsuarioDTOResponse salvaUsuario(UsuarioDTORequest usuarioDTO) {

        return client.salvaUsuario(usuarioDTO);

    }

    public String loginUsuario(LoginRequestDTO dto){

        return client.login(dto);
    }

    public UsuarioDTOResponse buscarUsuarioPorEmail(String email, String token){
        return client.buscaUsuarioPorEmail(email, token);

    }

    public void deletaUsuarioPorEmail(String email, String token){
       client.deletaUsuarioPorEmail(email, token);
    }

    public UsuarioDTOResponse atualizacoaDadosUsuario(String token, UsuarioDTORequest dto){
        return client.atualizDadosUsuario(dto, token);
    }

    public EnderecoDTOResponse atualizaEndereco(Long idEndereco, EnderecoDTORequest enderecoDTO, String token){

        return client.atualizaEndereco(enderecoDTO, idEndereco, token);

    }

    public TelefoneDTOResponse atualizaTelefone(Long idTelefone, TelefoneDTORequest dto, String token){
        return client.atualizaTelefone(dto, idTelefone, token);

    }

    public EnderecoDTOResponse cadastraEndereco(String token, EnderecoDTORequest dto){
       return client.cadastroEndereco(dto, token);
    }

    public TelefoneDTOResponse cadastraTelefone(String token, TelefoneDTORequest dto){
       return client.cadastroTelefone(dto, token);
    }
}


