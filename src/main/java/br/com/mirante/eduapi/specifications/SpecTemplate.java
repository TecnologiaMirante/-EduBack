package br.com.mirante.eduapi.specifications;

import br.com.mirante.eduapi.models.*;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.data.jpa.domain.Specification;

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

    public interface SerieSpec extends Specification<Serie>{}

    public interface DisciplinaSpec extends Specification<Disciplina>{}

    public interface TurmaSpec extends Specification<Turma>{}

    public interface BimestreSpec extends Specification<Bimestre>{}

    public interface MediaSpec extends Specification<Media>{}

    public interface ConteudoSpec extends Specification<Conteudo>{}

    public interface AvaliacaoSpec extends Specification<Avaliacao>{}

    public interface MaterialComplementarSpec extends Specification<MaterialComplementar>{}
}
