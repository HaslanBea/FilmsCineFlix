package com.cinema.controller;

import com.cinema.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/filmes")
public class FilmeController {

    private List<Filme> filmes = new ArrayList<>();
    private int idCounter = 1;

    @GetMapping("/cadastrar")
    public String mostrarFormularioCadastro() {
        return "cadastrar-filme";
    }

    @PostMapping("/cadastrar")
    public String cadastrarFilme(@RequestParam String titulo, 
                                  @RequestParam String sinopse, 
                                  @RequestParam String genero, 
                                  @RequestParam int ano) {
        Filme filme = new Filme(idCounter++, titulo, sinopse, genero, ano);
        filmes.add(filme);
        return "redirect:/filmes/listar";
    }

    @GetMapping("/listar")
    public String listarFilmes(Model model) {
        model.addAttribute("filmes", filmes);
        return "listar-filmes";
    }

    @GetMapping("/detalhes")
    public String detalhesFilme(@RequestParam int id, Model model) {
        for (Filme filme : filmes) {
            if (filme.getId() == id) {
                model.addAttribute("filme", filme);
                return "detalhes-filme";
            }
        }
        return "redirect:/filmes/listar";
    }
}