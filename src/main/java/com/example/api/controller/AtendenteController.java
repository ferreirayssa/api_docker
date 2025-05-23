package com.example.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.model.Atendente;
import com.example.api.model.JsonResposta;
import com.example.api.model.MetodoPatch;
import com.example.api.model.MetodoPut;

@RestController
@RequestMapping("/api/Atendentes")
public class AtendenteController {
    private List<Atendente> Atendentes = new ArrayList<>();

    public AtendenteController() {
        Atendentes.add(new Atendente(1L, "João Gonçalves Silva", "Recursos Humanos"));
        Atendentes.add(new Atendente(2L, "Maria Eduarda Almeida", "Financeiro"));
    }

    @GetMapping
    public JsonResposta listar() {
        if (Atendentes.isEmpty()) {
            return JsonResposta.builder()
                    .status(false)
                    .mensagem("Nenhum atendente encontrado.")
                    .dados(null)
                    .build();
        } else {
            return JsonResposta.builder()
                    .status(true)
                    .mensagem("Lista de atendentes retornada com sucesso.")
                    .dados(Atendentes)
                    .build();
        }
    }

    @GetMapping("/{id}")
    public JsonResposta buscarPorId(@PathVariable Long id) {
        Atendente atendente = Atendentes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
        if (atendente != null) {
            return JsonResposta.builder()
                    .status(true)
                    .mensagem("Atendente " + atendente.getNome() + " encontrado.")
                    .build();
        } else {
            return JsonResposta.builder()
                    .status(false)
                    .mensagem("Atendente não encontrado.")
                    .build();
        }
    }

    @PostMapping
    public JsonResposta criar(@RequestBody Atendente atendente) {
        Long novoId = Atendentes.stream()
                .mapToLong(Atendente::getId)
                .max()
                .orElse(0L) + 1;
        atendente.setId(novoId);
        Atendentes.add(atendente);
        return JsonResposta.builder()
                .status(true)
                .mensagem("Atendente criado com sucesso.")
                .dados(atendente)
                .build();
    }

    @DeleteMapping("/{id}")
    public JsonResposta deletar(@PathVariable Long id) {
        Atendente removido = Atendentes.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst()
                .orElse(null);

        if (removido != null) {
            Atendentes.remove(removido);
            return JsonResposta.builder()
                    .status(true)
                    .mensagem("Atendente " + removido.getNome() + " removido com sucesso.")
                    .build();
        } else {
            return JsonResposta.builder()
                    .status(false)
                    .mensagem("Atendente não encontrado para remoção.")
                    .build();
        }
    }

    @PutMapping("/{id}")
    public JsonResposta atualizar(@PathVariable Long id, @RequestBody MetodoPut put) {
        for (int i = 0; i < Atendentes.size(); i++) {
            Atendente a = Atendentes.get(i);
            if (a.getId().equals(id)) {
                if (put.getNome() != null) a.setNome(put.getNome());
                if (put.getDepartamento() != null) a.setDepartamento(put.getDepartamento());
                return JsonResposta.builder()
                        .status(true)
                        .mensagem("Atendente atualizado com sucesso.")
                        .dados(a)
                        .build();
            }
        }
        return JsonResposta.builder()
                .status(false)
                .mensagem("Atendente não encontrado para atualização.")
                .dados(null)
                .build();
    }

    @PatchMapping("/{id}")
    public JsonResposta patchAtendente(@PathVariable Long id, @RequestBody MetodoPatch patch) {
        for (int i = 0; i < Atendentes.size(); i++) {
            Atendente atual = Atendentes.get(i);
            if (atual.getId().equals(id)) {
                String nome = atual.getNome();
                String departamentoAntigo = atual.getDepartamento();
                if (patch.getDepartamento() != null) atual.setDepartamento(patch.getDepartamento());
                String departamentoNovo = atual.getDepartamento();
                return JsonResposta.builder()
                        .status(true)
                        .mensagem("O atendente " + nome + " deixou o departamento " + departamentoAntigo + " e foi para o departamento " + departamentoNovo + ".")
                        .dados(patch)
                        .build();
            }
        }
        return JsonResposta.builder()
                .status(false)
                .mensagem("Atendente não encontrado para atualização parcial.")
                .dados(null)
                .build();
    }
}