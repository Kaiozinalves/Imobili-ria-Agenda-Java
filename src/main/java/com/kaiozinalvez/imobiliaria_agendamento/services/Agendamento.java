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

    public void agendar(List<Corretor> corretores, List<Imovel> imoveis){

        //filtrar apenas avaliadores
        List<Corretor> avaliadores = corretores.stream()
                .filter(Corretor::getAvaliador)
                .collect(Collectors.toList());

        //round-robin para distribuir avaliadores para imoveis
        Map<Corretor , List<Imovel>> imoveisDistribuidos = new LinkedHashMap<>();

        for(Corretor avaliador : avaliadores){
            imoveisDistribuidos.put(avaliador, new ArrayList<>());
        }

        if(avaliadores.isEmpty()){
            return;
        }

        int avaliadorIndex = 0;
        for(Imovel imovel : imoveis){
            Corretor avaliador = avaliadores.get(avaliadorIndex);
            imoveisDistribuidos.get(avaliador).add(imovel);

            avaliadorIndex++;

            if(avaliadorIndex > avaliadores.size()){
                avaliadorIndex = 0;
            }
        }



    }

}
