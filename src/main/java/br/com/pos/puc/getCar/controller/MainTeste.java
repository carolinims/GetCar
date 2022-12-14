package br.com.pos.puc.getCar.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

public class MainTeste {

	public static void main(String[] args) {

//		LocalDateTime dtHrAtual = LocalDateTime.now(ZoneId.of("America/Sao_Paulo"));
//		LocalDateTime dtHrPlus = dtHrAtual.plusHours(3);
//		
//		System.out.println(dtHrAtual);
//		System.out.println(dtHrPlus);
//		
//		System.out.println(dtHrAtual.toLocalDate().equals(dtHrPlus.toLocalDate()));
//		

		Map<Long, Integer> mapReservaPorGrupo = new HashMap<>();
		
//		mapReservaPorGrupo.put(1L, 1);
//		mapReservaPorGrupo.put(2L, 1);
//		mapReservaPorGrupo.put(1L, 2);
		
		for(int i=0; i<10; i++) {
			mapReservaPorGrupo.put(1L, mapReservaPorGrupo.get(1L) == null? 1 : mapReservaPorGrupo.get(1L) +1);
			System.out.println(mapReservaPorGrupo);
		}
		

	}

}
