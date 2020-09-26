/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.PersonDTO;
import exceptions.PersonNotFoundException;

/**
 *
 * @author Joakim
 */
public interface IPersonFacade {

    public PersonDTO addPerson(PersonDTO personDTO);

    public PersonDTO deletePerson(int id) throws PersonNotFoundException;

    public PersonDTO getPerson(int id) throws PersonNotFoundException;

    //public PersonsDTO getAllPersons();

    public PersonDTO editPerson(PersonDTO p) throws PersonNotFoundException;
}
