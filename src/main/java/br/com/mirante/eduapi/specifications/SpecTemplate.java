package br.com.mirante.eduapi.specifications;

import br.com.mirante.eduapi.models.Escola;
import br.com.mirante.eduapi.models.Professor;
import br.com.mirante.eduapi.models.Serie;
import br.com.mirante.eduapi.models.Usuario;
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

}
