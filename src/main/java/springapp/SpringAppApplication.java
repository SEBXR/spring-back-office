package springapp;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springapp.admin.Client;
import springapp.admin.TypeProduit;
import springapp.dba.DBAConnection;
import springapp.admin.Administrateur;
import springapp.admin.Categorie;
@RestController
@SpringBootApplication
public class SpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringAppApplication.class, args);
	}
	@GetMapping("/")
	public String index(){
		return "BIENVENUE SUR NOTRE SPRING BOOT";
	}
	@GetMapping("/dba")
	public String dba() throws Exception{
		return DBAConnection.connect().toString();
	}
	
	@PostMapping("/login")
	@CrossOrigin
	public Integer log(String email, String password) throws SQLException {
		Administrateur admin=new Administrateur();
		admin.setEmail(email);
		admin.setPassword(password);
		return admin.Login();
	}

	@GetMapping("/listedemande")
	@CrossOrigin
	public ArrayList<Client> listdemand() throws SQLException{
		return Administrateur.findAllDemandesClients();
	}

	@GetMapping("/plusvendu")
	@CrossOrigin
	public ArrayList<Categorie> plusvendu() throws SQLException{
		Categorie cat=new Categorie();
		return cat.categoriePlusVendus();
	}

	@GetMapping("/argentgenere")
	@CrossOrigin
	public ArrayList<Categorie> ArgentGenere() throws Exception{		
		return Administrateur.ArgentGenere();
	}

	@PostMapping("/updatebudget")
	@CrossOrigin
	public Integer updatebudget(int idClient, int budget, int demande){
		Client client=new Client();
		client.setIdClient(idClient);
		client.setBudget(budget);
		client.setDemande(demande);
		return client.UpdateBudget();
	}

	@GetMapping("/elements")
	@CrossOrigin
	public ArrayList<Categorie> findelement() throws SQLException{
		return Administrateur.findAllElements();
	}

	@RequestMapping(method =RequestMethod.GET ,value={"/typeCategories","/typeCategories/{id}"})
	@CrossOrigin
	public ArrayList<TypeProduit> typeCategories(@PathVariable (required = false) Integer id) throws SQLException {
		Categorie categ=new Categorie();
		if(id != null){
			categ.setId(id);
			return categ.findTypePCateg();
		}
			return categ.findTypePCateg();
	}
}
