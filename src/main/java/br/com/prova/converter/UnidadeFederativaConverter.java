package br.com.prova.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.prova.model.UnidadeFederativa;
import br.com.prova.to.UnidadeFederativaTO;

/**
 * @author Lucas
 *
 */
@Component
public class UnidadeFederativaConverter {

	/**
	 * Converte {@link UnidadeFederativaTO} para {@link UnidadeFederativa}
	 * @param unidadeFederativaTO
	 * @return
	 */
	public UnidadeFederativa toEntity(UnidadeFederativaTO unidadeFederativaTO) {
		if(unidadeFederativaTO == null) {
			return null;
		}

		UnidadeFederativa unidadeFederativa = new UnidadeFederativa();
		unidadeFederativa.setId(unidadeFederativaTO.getId());
		unidadeFederativa.setNome(unidadeFederativaTO.getNome());
		unidadeFederativa.setSigla(unidadeFederativaTO.getSigla());
		unidadeFederativa.setData(unidadeFederativaTO.getData());

		return unidadeFederativa;
	}

	/**
	 * Converte {@link UnidadeFederativa} para {@link UnidadeFederativaTO}
	 * @param unidadeFederativa
	 * @return
	 */
	public UnidadeFederativaTO toTO(UnidadeFederativa unidadeFederativa) {
		if(unidadeFederativa == null) {
			return null;
		}
	
		return new UnidadeFederativaTO(unidadeFederativa.getId(), unidadeFederativa.getNome(), unidadeFederativa.getSigla(), unidadeFederativa.getData());
	}

	/**
	 * Converte {@link UnidadeFederativa} para {@link UnidadeFederativaTO}
	 * @param unidadesFederativas
	 * @return
	 */
	public List<UnidadeFederativaTO> toListTO(List<UnidadeFederativa> unidadesFederativas) {
		List<UnidadeFederativaTO> unidadesFederativasTO = new ArrayList<>();
		if(unidadesFederativas == null || unidadesFederativas.isEmpty()) {
			return unidadesFederativasTO;
		}

		unidadesFederativas.forEach(uf -> {
			unidadesFederativasTO.add(new UnidadeFederativaTO(uf.getId(), uf.getNome(), uf.getSigla(), uf.getData()));
		});
		return unidadesFederativasTO;
	}
}
