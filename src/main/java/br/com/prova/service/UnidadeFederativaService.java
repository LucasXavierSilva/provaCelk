package br.com.prova.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prova.converter.UnidadeFederativaConverter;
import br.com.prova.exception.UnidadeFederativaException;
import br.com.prova.model.UnidadeFederativa;
import br.com.prova.repository.UnidadeFederativaRepository;
import br.com.prova.to.UnidadeFederativaTO;

/**
 * Classe representando o Service da entidade {@link UnidadeFederativa}.
 * 
 * @author Lucas
 *
 */
@Service("unidadeFederativaService")
public class UnidadeFederativaService {
	@Autowired
	UnidadeFederativaConverter unidadeFederativaConverter;
	@Autowired
	UnidadeFederativaRepository unidadeFederativaRepository;

	/**
	 * Busca todas as {@link UnidadeFederativa}
	 * 
	 * @return
	 * @throws UnidadeFederativaException
	 */
	public List<UnidadeFederativaTO> getUFs() throws UnidadeFederativaException {
		return unidadeFederativaConverter.toListTO(unidadeFederativaRepository.findAll());
	}

	/**
	 * Atualiza a {@link UnidadeFederativa} de acordo com a
	 * {@link UnidadeFederativaTO} informado.
	 * 
	 * @param unidadeFederativaTO
	 * @throws UnidadeFederativaException
	 */
	public void removerUF(UnidadeFederativaTO unidadeFederativaTO) throws UnidadeFederativaException {
		if (unidadeFederativaTO == null) {
			throw new UnidadeFederativaException("O campo 'Unidade Federativa' deve ser informado!");
		}
		UnidadeFederativa unidadeFederativa = unidadeFederativaConverter.toEntity(unidadeFederativaTO);
		unidadeFederativaRepository.delete(unidadeFederativa);
	}

	/**
	 * Salva a {@link UnidadeFederativa} de acordo com a
	 * {@link UnidadeFederativaTO} informado.
	 * 
	 * @param unidadeFederativaTO
	 * @return
	 * @throws UnidadeFederativaException
	 */
	public UnidadeFederativaTO salvarUF(UnidadeFederativaTO unidadeFederativaTO) throws UnidadeFederativaException {
		if (unidadeFederativaTO == null) {
			throw new UnidadeFederativaException("O campo 'Unidade Federativa' deve ser informado!");
		}
		unidadeFederativaTO.setData(LocalDateTime.now());
		UnidadeFederativa unidadeFederativa = unidadeFederativaConverter.toEntity(unidadeFederativaTO);
		unidadeFederativaRepository.save(unidadeFederativa);
		return unidadeFederativaConverter.toTO(unidadeFederativa);
	}

}
