package com.extremebikebffagendadortarefas.infrastructure.client;


import com.extremebikebffagendadortarefas.business.dto.in.EnderecoDTORequest;
import com.extremebikebffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.extremebikebffagendadortarefas.business.dto.in.TelefoneDTORequest;
import com.extremebikebffagendadortarefas.business.dto.in.UsuarioDTORequest;
import com.extremebikebffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import com.extremebikebffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import com.extremebikebffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import com.extremebikebffagendadortarefas.business.dto.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader("Authorization") String token);

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);



    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader("Authorization") String token);

    @PutMapping
    UsuarioDTOResponse atualizDadosUsuario(@RequestBody UsuarioDTORequest dto,
                                           @RequestHeader("Authorization") String token);

    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader("Authorization") String token);

    @PostMapping("/endereco")
    EnderecoDTOResponse cadastroEndereco(@RequestBody EnderecoDTORequest dto,
                                         @RequestHeader("Authorization")String token);

    @PostMapping("/telefone")
    TelefoneDTOResponse cadastroTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader("Authorization")String token);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);

}
