package br.com.mirante.eduapi.specifications;

import br.com.mirante.eduapi.models.*;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

import java.util.UUID;

public class SpecTemplate {
    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "email", spec = Equal.class),
            @Spec(path = "telefone", spec = Equal.class),
            @Spec(path = "estado", spec = Equal.class),
            @Spec(path = "cidade", spec = Like.class)

    })
    public interface EscolaSpec extends Specification<Escola> {}

    public interface UsuarioSpec extends Specification<Usuario> {}

    public interface ProfessorSepc extends Specification<Professor> {}

    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "turno", spec = Equal.class)
    })
    public interface SerieSpec extends Specification<Serie>{}

    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "codigo", spec = Equal.class),
            @Spec(path = "status", spec = Equal.class)
    })

    public interface DisciplinaSpec extends Specification<Disciplina>{}
    @And({
            @Spec(path = "nome", spec = Like.class),
            @Spec(path = "turno", spec = Equal.class),
            @Spec(path = "codigo", spec = Equal.class),
            @Spec(path = "status", spec = Equal.class)
    })
    public interface TurmaSpec extends Specification<Turma>{}

    @And({
            @Spec(path = "data", spec = Equal.class)
    })
    public interface BimestreSpec extends Specification<Bimestre>{}

    @And({
            @Spec(path = "nota", spec = Equal.class)
    })
    public interface MediaSpec extends Specification<Media>{}

    @And({
            @Spec(path = "titulo", spec = Equal.class),
            @Spec(path = "descricao", spec = Like.class)
    })
    public interface ConteudoSpec extends Specification<Conteudo>{}

    @And({
            @Spec(path = "nota", spec = Equal.class),
            @Spec(path = "data", spec = Equal.class),
            @Spec(path = "descricao", spec = Like.class),
            @Spec(path = "tipo", spec = Equal.class)

    })
    public interface AvaliacaoSpec extends Specification<Avaliacao>{}

    @And({
            @Spec(path = "titulo", spec = Like.class),
            @Spec(path = "material", spec = Like.class)

    })
    public interface MaterialComplementarSpec extends Specification<MaterialComplementar>{}
}
