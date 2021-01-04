package org.springframework.samples.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Actor;
import org.springframework.samples.petclinic.service.ActorService;
import org.springframework.samples.petclinic.service.exceptions.SaldoException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreditoController {

	private final ActorService actorService;

	@Autowired
	public CreditoController(ActorService actorService) {
		this.actorService = actorService;
	}

	/**
	 * Comprueba que un número de cuenta bancaria IBAN es válido
	 */
	public boolean isBankAccountNumberValid(String bankAccountNumber) {
		String length;
		switch(bankAccountNumber.substring(0, 2)) {
		case "AD": length = "24"; break;
		case "AE": length = "23"; break;
		case "AT": length = "20"; break;
		case "BA": length = "20"; break;
		case "BE": length = "16"; break;
		case "BH": length = "22"; break;
		case "BG": length = "22"; break;
		case "CH": length = "21"; break;
		case "CR": length = "22"; break;
		case "CY": length = "28"; break;
		case "CZ": length = "24"; break;
		case "DE": length = "22"; break;
		case "DK": length = "18"; break;
		case "EE": length = "20"; break;
		case "ES": length = "24"; break;
		case "FI": length = "18"; break;
		case "FO": length = "18"; break;
		case "FR": length = "27"; break;
		case "GB": length = "22"; break;
		case "GE": length = "22"; break;
		case "GI": length = "23"; break;
		case "GL": length = "18"; break;
		case "GR": length = "27"; break;
		case "GT": length = "28"; break;
		case "HR": length = "21"; break;
		case "HU": length = "28"; break;
		case "IE": length = "22"; break;
		case "IM": length = "22"; break;
		case "IS": length = "26"; break;
		case "IT": length = "27"; break;
		case "JE": length = "22"; break;
		case "JO": length = "30"; break;
		case "KW": length = "30"; break;
		case "KZ": length = "20"; break;
		case "LB": length = "28"; break;
		case "LI": length = "21"; break;
		case "LT": length = "20"; break;
		case "LU": length = "20"; break;
		case "LV": length = "21"; break;
		case "MC": length = "27"; break;
		case "MD": length = "24"; break;
		case "ME": length = "22"; break;
		case "MK": length = "19"; break;
		case "MT": length = "31"; break;
		case "NO": length = "15"; break;
		case "NL": length = "18"; break;
		case "PL": length = "28"; break;
		case "PS": length = "29"; break;
		case "PT": length = "25"; break;
		case "QA": length = "29"; break;
		case "RO": length = "24"; break;
		case "SA": length = "24"; break;
		case "SE": length = "24"; break;
		case "SI": length = "19"; break;
		case "SK": length = "24"; break;
		case "SM": length = "27"; break;
		case "TN": length = "24"; break;
		case "TR": length = "26"; break;
		default:length = "1,99";
		}
		return bankAccountNumber.matches("^[A-Z0-9]{" + length + "}$");
	}

	@GetMapping(value = "/credito/comprar")
	public ModelAndView buyCredit() {
		return buyCredit(null, null, null, null);
	}

	public ModelAndView buyCredit(String errorMessage, String successMessage, String bankAccountNumber, String credits) {
		ModelAndView mav = new ModelAndView("credito/comprar");
		Actor actor = this.actorService.findLoggedIn();
		mav.addObject("saldo", actor.getSaldo());
		mav.addObject("errorMessage", errorMessage);
		mav.addObject("successMessage", successMessage);
		mav.addObject("bankAccountNumber", bankAccountNumber);
		mav.addObject("credits", credits);
		return mav;
	}

	@PostMapping(value = "/credito/comprar")
	public ModelAndView buyCredit(@RequestParam("bankAccountNumber") String bankAccountNumber, @RequestParam("credits") int credits) {
		Actor actor = this.actorService.findLoggedIn();
		int saldo = actor.getSaldo();
		if(!isBankAccountNumberValid(bankAccountNumber)) {
			return this.buyCredit("El número de cuenta bancaria no es válido.", null, bankAccountNumber, "" + credits);
		}
		if(!(saldo < 0 || credits < 0 || (saldo + credits) < 0)) {
			try {
				this.actorService.addToSaldo(actor.getUser().getUsername(), credits);
			} catch (SaldoException e) {
				return this.buyCredit("Número de créditos inválido.", null, bankAccountNumber, "" + credits);
			}
		} else {
			return this.buyCredit("Número de créditos inválido.", null, bankAccountNumber, "" + credits);
		}
		return this.buyCredit(null, credits + " créditos comprados con éxito", bankAccountNumber, null);
	}

	@GetMapping(value = "/credito/vender")
	public ModelAndView sellCredit() {
		return sellCredit(null, null, null, null);
	}

	public ModelAndView sellCredit(String errorMessage, String successMessage, String bankAccountNumber, String credits) {
		ModelAndView mav = new ModelAndView("credito/vender");
		Actor actor = this.actorService.findLoggedIn();
		mav.addObject("saldo", actor.getSaldo());
		mav.addObject("errorMessage", errorMessage);
		mav.addObject("successMessage", successMessage);
		mav.addObject("bankAccountNumber", bankAccountNumber);
		mav.addObject("credits", credits);
		return mav;
	}

	@PostMapping(value = "/credito/vender")
	public ModelAndView sellCredit(@RequestParam("bankAccountNumber") String bankAccountNumber, @RequestParam("credits") int credits) {
		Actor actor = this.actorService.findLoggedIn();
		int saldo = actor.getSaldo();
		if(!isBankAccountNumberValid(bankAccountNumber)) {
			return this.sellCredit("El número de cuenta bancaria no es válido.", null, bankAccountNumber, "" + credits);
		}
		if(!(saldo < 0 || credits < 0 || (saldo - credits) < 0)) {
			try {
				this.actorService.removeFromSaldo(actor.getUser().getUsername(), credits);
			} catch (SaldoException e) {
				return this.sellCredit("Número de créditos inválido.", null, bankAccountNumber, "" + credits);
			}
		} else {
			return this.sellCredit("Número de créditos inválido.", null, bankAccountNumber, "" + credits);
		}
		return this.sellCredit(null, credits + " créditos vendidos con éxito", bankAccountNumber, null);
	}

}
