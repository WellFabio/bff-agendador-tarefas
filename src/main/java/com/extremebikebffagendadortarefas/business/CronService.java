package com.extremebikebffagendadortarefas.business;

import com.extremebikebffagendadortarefas.business.dto.in.LoginRequestDTO;
import com.extremebikebffagendadortarefas.business.dto.out.TarefasDTOResponse;
import com.extremebikebffagendadortarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CronService {

   private final TarefasService tarefasService;
   private final EmailService emailService;
   private final UsuarioService usuarioService;

   @Value("${usuario.email}")
   private String email;

   @Value("${usuario.senha}")
   private String senha;


   @Scheduled(cron = "${cron.horario}")
   public void buscaTarefasProximaHora(){
        String token = login(converterParaRequestDTO());
        log.info("Iniciada a busca de tarefas");
       LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
       LocalDateTime horaFurutaMaisCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

       List<TarefasDTOResponse> listaTarefas = tarefasService.buscaTarefasAgendadasPorPeriodo(horaFutura, horaFurutaMaisCinco, token);
       log.info("Tarefas encontradas " + listaTarefas);
        listaTarefas.forEach(tarefa -> {
            emailService.enviaEmail(tarefa);
            log.info("Email enviado para o usuario " + tarefa.getEmailUsuario());
            tarefasService.alteraStatus(StatusNotificacaoEnum.NOTIFICADO, tarefa.getId(),
                    token);
        });
        log.info("Finalizada a busca e notificação de tarefas");
   }
        public String login(LoginRequestDTO dto){
            return usuarioService.loginUsuario(dto);
        }

        public LoginRequestDTO converterParaRequestDTO(){
            return LoginRequestDTO.builder()
                    .email(email)
                    .senha(senha)
                    .build();
        }
}
