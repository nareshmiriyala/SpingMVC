package com.dellnaresh.web;

import com.dellnaresh.entity.Trans;
import com.dellnaresh.entity.TransParty;
import com.dellnaresh.repos.TransPartyRepository;
import com.dellnaresh.repos.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Objects.*;

/**
 * Created by nareshm on 3/5/2016.
 */
@Controller
public class TransferController {
    @Autowired
    private TransPartyRepository transPartyRepository;
    @Autowired
    private TransRepository transRepository;

    @RequestMapping(method = RequestMethod.GET,
            value = "/home")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(method = RequestMethod.GET,
            value = "/createCustomer")
    public String createCustomer() {
        return "createCustomer";
    }
    @RequestMapping(method = RequestMethod.GET,
            value = "/viewCustomer")
    public String viewCustomers(Model model) {
        model.addAttribute("customers",transPartyRepository.findAll());
        return "viewCustomer";
    }
    @RequestMapping(method = RequestMethod.GET,
            value = "/doTransfer")
    public String doTransfer() {
        return "doTransfer";
    }
    @RequestMapping(value = "/transfer", method = RequestMethod.POST)
    @Transactional(rollbackFor = MyException.class)
    public String transfer(@ModelAttribute("trans") Trans trans) throws MyException {
     if(nonNull(trans)){
         transRepository.save(trans);
         TransParty debtorParty = transPartyRepository.getOne(trans.getDebtorId());
         TransParty creditorParty = transPartyRepository.getOne(trans.getCreditorId());
         debitDebtor(debtorParty,trans.getAmount());
         if(!trans.getAmount().equals(BigDecimal.ZERO)){
         throw new MyException();
         }
         creditCreditor(creditorParty,trans.getAmount());
     }
        return "redirect:home";
    }
    private void creditCreditor(TransParty creditorParty, BigDecimal amount) {
        creditorParty.setBalance(creditorParty.getBalance().add(amount));
        transPartyRepository.save(creditorParty);
    }
    private void debitDebtor(TransParty debtorParty, BigDecimal amount) {
        debtorParty.setBalance(debtorParty.getBalance().subtract(amount));
        transPartyRepository.save(debtorParty);
    }

    @RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
    public String add(@ModelAttribute("transParty") TransParty party) {
        if (nonNull(party)) {
            transPartyRepository.save(party);
        }
        return "redirect:home";
    }

}
