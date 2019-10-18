/**
 * 
 */
package br.com.prova.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.prova.exception.UnidadeFederativaException;
import br.com.prova.service.UnidadeFederativaService;
import br.com.prova.to.UnidadeFederativaTO;

/**
 * @author Lucas
 *
 */
@RestController
@RequestMapping(value = "/unidadeFederativa", produces = "application/json")
public class UnidadeFederativaController {

	private UnidadeFederativaService unidadeFederativaService;
	Logger logger;
	
	@Autowired(required=true)
	@Qualifier(value="unidadeFederativaService")
	public void setUnidadeFederativaService(UnidadeFederativaService uf){
		this.unidadeFederativaService = uf;
	}

	@RequestMapping(value= "/uf", method = RequestMethod.GET)
	@ResponseBody
	public List<UnidadeFederativaTO> getUFs() throws Exception {
		List<UnidadeFederativaTO> ufs = this.unidadeFederativaService.getUFs();
		return ufs;
	}

	@PostMapping(value= "/uf/salvar")
	public UnidadeFederativaTO adicionarUF(@RequestBody UnidadeFederativaTO uf) throws Exception {
		try {
			uf = this.unidadeFederativaService.salvarUF(uf);
			return uf;
		} catch (UnidadeFederativaException e) {
			logger.error("Falha ao salvar UF: ", e);
			throw new Exception(e);
		}
	}

	@RequestMapping(value= "/uf/deletar", method = RequestMethod.POST)
	@ResponseBody
	public void removerUF(@ModelAttribute("uf") UnidadeFederativaTO unidadeFederativaTO) throws Exception {
		try {
			this.unidadeFederativaService.removerUF(unidadeFederativaTO);
		} catch (UnidadeFederativaException e) {	
			logger.error("Falha ao remover UF: ", e);
			throw new Exception(e);
		}
	}
}
