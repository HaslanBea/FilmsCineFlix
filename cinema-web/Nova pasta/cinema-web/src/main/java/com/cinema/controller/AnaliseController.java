package com.cinema.controller;

import com.cinema.model.Analise;
import com.cinema.model.Filme;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/analises")
public class AnaliseController {

    private List<Analise> analises = new ArrayList<>();
    private List<Filme> filmes = new ArrayList<>(); // This should ideally be populated from FilmeController

    @PostMapping("/adicionar")
    public String adicionarAnalise(@RequestParam Long filmeId, @RequestParam String analise, @RequestParam int nota) {
        Filme filme = filmes.stream().filter(f -> f.getId().equals(filmeId)).findFirst().orElse(null);
        if (filme != null) {
            Analise novaAnalise = new Analise();
            novaAnalise.setId((long) (analises.size() + 1)); // Simple ID generation
            novaAnalise.setFilme(filme);
            novaAnalise.setAnalise(analise);
            novaAnalise.setNota(nota);
            analises.add(novaAnalise);
        }
        return "redirect:/filmes/detalhes/" + filmeId;
    }

    @GetMapping("/listar")
    public String listarAnalises(Model model) {
        model.addAttribute("analises", analises);
        return "listar-analises"; // This view should be created to display analyses
    }
}