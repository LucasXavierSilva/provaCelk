package br.com.prova;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.prova.converter.UnidadeFederativaConverter;
import br.com.prova.model.UnidadeFederativa;
import br.com.prova.repository.UnidadeFederativaRepository;
import br.com.prova.service.UnidadeFederativaService;
import br.com.prova.to.UnidadeFederativaTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnidadeFederativaServiceTests {

	@InjectMocks
	UnidadeFederativaService unidadeFederativaService;

	@Mock
	UnidadeFederativaRepository unidadeFederativaRepository;

	@Mock
	UnidadeFederativaConverter unidadeFederativaConverter;

	@Before(value = "")
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	//Testando instancia no repositório de cliente e analise credito ao enviar um para o método save
    @Test
    public void saveUf() throws Exception
    {
        UnidadeFederativaTO ufTO = new UnidadeFederativaTO(null,"Goias","GO", null);
        UnidadeFederativa uf = unidadeFederativaConverter.toEntity(unidadeFederativaService.salvarUF(ufTO));
        //Verificando se cliente foi salvo
        verify(unidadeFederativaRepository, times(1)).save(uf);
    }
    
    //Teste de caso existir um cliente com o mesmo CPF cadastrado no banco de dados (Esperando uma exceção)
    @Test
    public void saveClientWithDuplicateCPf() throws Exception
    {
    	List<UnidadeFederativaTO> ufs = unidadeFederativaService.getUFs();
    	assertNotNull(ufs);
    }
}
