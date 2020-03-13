package br.com.basis.prova.recurso;


import br.com.basis.prova.dominio.Professor;
import br.com.basis.prova.dominio.auxiliar.ProfessorDetalhado;
import br.com.basis.prova.servico.ProfessorServico;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/professores")
public class ProfessorRecurso {

    private static final String API_PROFESSORES = "/professores";

    private final ProfessorServico professorServico;

    public ProfessorRecurso(ProfessorServico professorServico) {
        this.professorServico = professorServico;
    }

    @PostMapping
    public ResponseEntity<Professor> salvar(@Valid @RequestBody Professor professor) throws URISyntaxException {
    	Professor result = professorServico.salvar(professor);
        return ResponseEntity.created(new URI(API_PROFESSORES + "/" + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<Professor> editar(@RequestBody Professor professor) throws URISyntaxException {
    	Professor result = professorServico.salvar(professor);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> excluir(@PathVariable("matricula") String matricula) {
        professorServico.excluir(matricula);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<Professor>> consultar() {
        return ResponseEntity.ok(professorServico.consultar());
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<ProfessorDetalhado> detalhar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(professorServico.detalhar(id));
    }

}
