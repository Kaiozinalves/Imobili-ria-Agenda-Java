package com.kaiozinalvez.imobiliaria_agendamento.services;

import com.kaiozinalvez.imobiliaria_agendamento.models.Corretor;
import com.kaiozinalvez.imobiliaria_agendamento.models.Imovel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Agendamento {
    private static final double EARTH_R = 6371.0; // Raio da Terra em km


    //metodo para calculos de distancia
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dlat = Math.toRadians(lat2 - lat1);
        double dlon = Math.toRadians(lon2 - lon1);

        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.pow(Math.sin(dlon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_R * c;
    }

    public Map<Corretor, List<Imovel>> agendar(List<Corretor> corretores, List<Imovel> imoveis){

        //filtrar apenas avaliadores
        List<Corretor> avaliadores = corretores.stream()
                .filter(Corretor::getAvaliador)
                .collect(Collectors.toList());

        //round-robin para distribuir avaliadores para imoveis
        Map<Corretor, List<Imovel>> imoveisDistribuidos = new LinkedHashMap<>();

        if(avaliadores.isEmpty()){
            return imoveisDistribuidos;
        }

        for(Corretor avaliador : avaliadores){
            imoveisDistribuidos.put(avaliador, new ArrayList<>());
        }

        int avaliadorIndex = 0;
        for(Imovel imovel : imoveis){
            Corretor avaliador = avaliadores.get(avaliadorIndex);
            imoveisDistribuidos.get(avaliador).add(imovel);

            avaliadorIndex++;

            if(avaliadorIndex == avaliadores.size()){
                avaliadorIndex = 0;
            }
        }

        return imoveisDistribuidos;
    }

    public void organizarAgenda(Map<Corretor, List<Imovel>> imoveisDistribuidos){
        int contadorCorretor = 0;

        for(Corretor corretor : imoveisDistribuidos.keySet()){
            if(contadorCorretor > 0){
                System.out.println();
            }

            List<Imovel> imoveisNaoVisitados = new ArrayList<>(imoveisDistribuidos.get(corretor));

            double latAtual = corretor.getLat();
            double lngAtual = corretor.getLng();

            int horaAtual = 540;

            System.out.println("Corretor " + corretor.getIdCorretor());

            while(!imoveisNaoVisitados.isEmpty()){
                Imovel imovelMaisProximo = null;
                double menorDistancia = Double.MAX_VALUE;

                for(Imovel imovel : imoveisNaoVisitados){
                    double distancia = haversine(latAtual, lngAtual, imovel.getLat(), imovel.getLng());

                    if(distancia < menorDistancia){
                        menorDistancia = distancia;
                        imovelMaisProximo = imovel;
                    }
                }

                int tempoDeslocamento = (int) Math.round(menorDistancia * 2);
                horaAtual += tempoDeslocamento;

                int hora = horaAtual / 60;
                int minuto = horaAtual % 60;
                System.out.printf("%02d:%02d Imovel %d%n", hora, minuto, imovelMaisProximo.getIdImovel());

                horaAtual += 60;
                latAtual = imovelMaisProximo.getLat();
                lngAtual = imovelMaisProximo.getLng();
                imoveisNaoVisitados.remove(imovelMaisProximo);
            }

            contadorCorretor++;
        }
    }

}
