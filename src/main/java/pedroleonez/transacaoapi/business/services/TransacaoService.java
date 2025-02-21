package pedroleonez.transacaoapi.business.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pedroleonez.transacaoapi.controller.dtos.TransacaoRequestDTO;
import pedroleonez.transacaoapi.infra.exceptions.UnprocessableEntity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {

    private final List<TransacaoRequestDTO> listaTransacoes = new ArrayList<>();

    public void adicionarTransacao(TransacaoRequestDTO dto) {
        log.info("Iniciando processo de gravar transação {}", dto);

        if (dto.dataHora().isAfter(OffsetDateTime.now())) {
            log.info("Data e hora da transação não podem ser futuras");
            throw new UnprocessableEntity("Data e hora da transação não podem ser futuras");
        }
        if (dto.valor() <= 0) {
            log.info("Valor da transação deve ser maior que zero");
            throw new UnprocessableEntity("Valor da transação deve ser maior que zero");
        }

        listaTransacoes.add(dto);
        log.info("Transação gravada com sucesso");
    }

    public void limparTransacoes() {
        log.info("Iniciando processo de limpar transações");
        listaTransacoes.clear();
        log.info("Transações limpas com sucesso");
    }

    public List<TransacaoRequestDTO> buscarTransacoes(Integer intervaloBusca){
        log.info("Inicadas buscas de transações por tempo {}", intervaloBusca);
        OffsetDateTime dataHoraIntervalo = OffsetDateTime.now().minusSeconds(intervaloBusca);

        log.info("Retorno de transações com sucesso");
        return listaTransacoes.stream()
                .filter(transacao -> transacao.dataHora()
                        .isAfter(dataHoraIntervalo)).toList();

    }

}
