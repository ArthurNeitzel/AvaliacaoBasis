package br.com.basis.prova.recurso;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.basis.prova.dominio.Avaliacao;
import br.com.basis.prova.dominio.Disciplina;
import br.com.basis.prova.servico.AvaliacaoServico;
import br.com.basis.prova.servico.DisciplinaServico;

@RestController
@CrossOrigin()
@RequestMapping("/api/avaliacoes")
public class AvaliacaoRecurso {
	private static final String API_AVALIACOES = "/avaliacoes/";

    private final AvaliacaoServico avaliacaoServico;

	public AvaliacaoRecurso(AvaliacaoServico avaliacaoServico) {
		this.avaliacaoServico = avaliacaoServico;
	}
	
	@PostMapping
	public ResponseEntity<Avaliacao> salvar(@Valid @RequestBody Avaliacao avaliacao) throws URISyntaxException {
		Avaliacao result = avaliacaoServico.salvar(avaliacao);
        return ResponseEntity.created(new URI(API_AVALIACOES + result.getId())).body(result);
    }
	
	@GetMapping("/aluno/{id}")
    public ResponseEntity<List<Avaliacao>> consultaAluno(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(avaliacaoServico.consultaAluno(id));
    }
	
	@GetMapping("/disciplina/{id}")
    public ResponseEntity<List<Avaliacao>> consultaDisciplina(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(avaliacaoServico.consultaDisciplina(id));
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Avaliacao> detalhar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(avaliacaoServico.consultar(id));
    }
    
}
