package br.com.basis.prova.recurso;

import br.com.basis.prova.dominio.Aluno;
import br.com.basis.prova.dominio.dto.AlunoDTO;
import br.com.basis.prova.dominio.dto.AlunoDetalhadoDTO;
import br.com.basis.prova.dominio.dto.AlunoListagemDTO;
import br.com.basis.prova.servico.AlunoServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import javax.validation.Valid;

@RestController
@CrossOrigin()
@RequestMapping("/api/alunos")
public class AlunoRecurso {

    private static final String API_ALUNOS = "/alunos";
    
    private final AlunoServico alunoServico;

    public AlunoRecurso(AlunoServico alunoServico) {
        this.alunoServico = alunoServico;
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> salvar(@Valid @RequestBody AlunoDTO aluno) throws URISyntaxException {
    	AlunoDTO result = alunoServico.salvar(aluno);
        return ResponseEntity.created(new URI(API_ALUNOS + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<AlunoDTO> editar(@RequestBody AlunoDTO aluno) throws URISyntaxException {
    	AlunoDTO result = alunoServico.salvar(aluno);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{matricula}")
    public ResponseEntity<Void> excluir(@PathVariable("matricula") String matricula) {
        alunoServico.excluir(matricula);
        return ResponseEntity.status(200).build();
    }

    @GetMapping
    public ResponseEntity<List<AlunoListagemDTO>> consultar() {
        return ResponseEntity.ok(alunoServico.consultar());
    }

    @GetMapping("/detalhes/{id}")
    public ResponseEntity<AlunoDetalhadoDTO> detalhar(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(alunoServico.detalhar(id));
    }

}
