package jobsgoias.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jobsgoias.model.Estudante;
import jobsgoias.model.IEstudanteDao;
import jobsgoias.model.IEstudanteDao;



public class EstudanteController {

	Estudante estudante;
	Scanner scan;
	IEstudanteDao EstudanteDao = new IEstudanteDao();
	
	List<Estudante> estudantes= new ArrayList<Estudante>();
	
	
	// scan.nextLine é usado para textos com espaço e só scan.next para textos sem espaço
	
	
	//4 operações básicas de um sistema computacional: crud- create-read-update-delete
	//create- C
	public void cadastrarEstudante() {
		EstudanteController controller= new EstudanteController();
		estudante= new Estudante(0); 
		estudante= controller.preencherDadosEstudante();
		estudantes.add(estudante);
	    IEstudanteDao.SalvarEstudante(estudantes);
		System.out.println("Estudante cadastrado com sucesso!");
	}
	
	//read- R
	public void listarEstudante() {
		List<Estudante> estudantes= IEstudanteDao.ListarEstudante();
		this.estudantes= estudantes;
		printarDadosEstudante(estudantes);
	}
	
	//update- U
	public void atualizarEstudante(String cpf) {
		EstudanteController controller= new EstudanteController();
		List<Estudante> EstudanteRemover= new ArrayList<Estudante>();
		Estudante EstudanteEditado= new Estudante(0);
		estudante= new Estudante(0);
		for(int i=0; i<estudantes.size(); i++) {
			estudante = estudantes.get(i);
			if((estudante).getCpf().equals(cpf)) {
			     EstudanteRemover.add(estudante) ;
			     EstudanteEditado= editarEstudante(estudante);
			}
		}
		if(!EstudanteRemover.isEmpty()) {
			estudantes.removeAll(EstudanteRemover);
			estudantes.add(EstudanteEditado);
	        IEstudanteDao.SalvarEstudante((List<Estudante>) estudante);
	        System.out.println("Estudante editado com sucesso!");
		}else {
			System.out.println("CPF não localizado");
		}
	}
	
	private Estudante editarEstudante(Estudante estudante2) {
		// TODO Auto-generated method stub
		return null;
	}

	//delete-D	
	public void excluirEstudante(String cpf) {
		//mesma coisa do for da linha 44
		for(Estudante estudante: estudantes) {
			if(estudante.getCpf().equals(cpf)) {
				estudantes.remove(estudante);
				IEstudanteDao.SalvarEstudante((List<Estudante>) estudante);
				System.out.println("Estudante deletado com sucesso!");
			}else {
				System.out.println("Estudante não foi encontrado com esse cpf");
			}
		}
	}
	
	public Estudante preencherDadosEstudante() {
		Estudante estudante= new Estudante(0);
		scan= new Scanner(System.in);
		System.out.println("Digite o nome do estudante: ");
		estudante.setNome(scan.nextLine());
		// não concluído
		
		return estudante;
	}  
	public Estudante printarDadosEstudante(List<Estudante>estudantes) {
		if(estudantes.isEmpty()) {
			System.out.println("Não existe estudante cadastrado");
		}else {
		    
		   for(Estudante estudante: estudantes) {
			    System.out.println(" nome do paciente:"+estudante.getNome());
			 
			
			    System.out.println("----------------------------------------------");
		}
	}
		return (Estudante) estudante;
		
	}
}
