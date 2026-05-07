package com.kaiozinalvez.imobiliaria_agendamento;

import com.kaiozinalvez.imobiliaria_agendamento.models.Cliente;
import com.kaiozinalvez.imobiliaria_agendamento.models.Corretor;
import com.kaiozinalvez.imobiliaria_agendamento.models.Imovel;
import com.kaiozinalvez.imobiliaria_agendamento.models.TipoImovel;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ImobiliariaAgendamentoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ImobiliariaAgendamentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.US);

		//Criar listas de corretores, clientes e imoveis
		List<Corretor> corretores = new ArrayList<>();
		List<Cliente> clientes = new ArrayList<>();
		List<Imovel> imoveis = new ArrayList<>();

		//ler corretores
		if (!scanner.hasNextInt()) {
			return;
		}
		int numCorretores = scanner.nextInt();
		for (int i = 0; i < numCorretores; i++) {
			String telefone = scanner.next();
			int avaliadorInt = scanner.nextInt();
			double lat = scanner.nextDouble();
			double lng = scanner.nextDouble();
			String nome = scanner.nextLine().trim();
			boolean avaliador = avaliadorInt == 1;

			Corretor corretor = new Corretor(nome, telefone, avaliador, lat, lng);
			corretores.add(corretor);
		}

		//ler clientes
		int numClientes = scanner.nextInt();
		for(int i = 0; i < numClientes; i++){
			String telefone = scanner.next();
			String nome = scanner.nextLine().trim();

			Cliente cliente = new Cliente(nome, telefone);
			clientes.add(cliente);
		}

		//ler imoveis
		int numImoveis = scanner.nextInt();
		for(int i = 0; i < numImoveis; i++){
			TipoImovel tipo = TipoImovel.valueOf(scanner.next());
			int idProp = scanner.nextInt();
			double lat = scanner.nextDouble();
			double lng = scanner.nextDouble();
			double preco = scanner.nextDouble();
			String endereco = scanner.nextLine().trim();

			Imovel imovel = new Imovel(tipo, idProp, lat, lng, preco, endereco);
			imoveis.add(imovel);
		}
	}
}
